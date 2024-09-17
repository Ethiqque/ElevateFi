package com.elevatefi.service;

import com.elevatefi.aws.AwsSesService;
import com.elevatefi.common.ResourceNotFoundException;
import com.elevatefi.common.TokenCommons;
import com.elevatefi.config.SecretConfig;
import com.elevatefi.dto.PasswordResetConfirmDTO;
import com.elevatefi.dto.PasswordResetRequestDTO;
import com.elevatefi.entity.EmailVerificationToken;
import com.elevatefi.entity.User;
import com.elevatefi.repository.EmailVerificationTokenRepository;
import com.elevatefi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class PasswordResetService {

   private final UserRepository userRepository;
   private final EmailVerificationTokenRepository emailVerificationTokenRepository;
   private final EmailTemplateService emailTemplateService;
   private final AwsSesService awsSesService;
   private final PasswordEncoder passwordEncoder;
   private final UuidTokenService uuidTokenService;
   private final SecretConfig secretConfig;


   @Autowired
   public PasswordResetService(UserRepository userRepository, EmailVerificationTokenRepository emailVerificationTokenRepository, EmailTemplateService emailTemplateService, AwsSesService awsSesService, PasswordEncoder passwordEncoder, UuidTokenService uuidTokenService, SecretConfig secretConfig) {
      this.userRepository = userRepository;
      this.emailVerificationTokenRepository = emailVerificationTokenRepository;
      this.emailTemplateService = emailTemplateService;
      this.awsSesService = awsSesService;
      this.passwordEncoder = passwordEncoder;
      this.uuidTokenService = uuidTokenService;
      this.secretConfig = secretConfig;
   }

   /**
    * Initiates the password reset process by generating a token and sending a password reset email to the user's registered email address.
    *
    * @param passwordResetRequestDTO The DTO containing the user's email address.
    */
   public void initiatePasswordReset(PasswordResetRequestDTO passwordResetRequestDTO) {
      User user = userRepository.findByEmail(passwordResetRequestDTO.getEmail())
         .orElseThrow(() -> new ResourceNotFoundException("User not found"));

      // Generate and save password reset token
      String token = uuidTokenService.generateUuidToken(user);

      // Send password reset email
      sendPasswordResetEmail(user, token);
   }


   /**
    * Sends a password reset email to the user's registered email address.
    *
    * @param user  The user who requested the password reset.
    * @param token The password reset token generated for the user.
    */
   private void sendPasswordResetEmail(User user, String token) {
      String passwordResetEmailTemplate = secretConfig.getEmail().getTemplates().getPasswordReset();
      String domain = secretConfig.getActiveDomain();

      String subject = emailTemplateService.getSubjectByTemplateName(passwordResetEmailTemplate);
      String body = emailTemplateService.getBodyByTemplateName(passwordResetEmailTemplate)
         .replace("{reset_url}", domain + "/password-reset-confirm?token=" + token);

      awsSesService.sendEmail(user.getEmail(), subject, body);
   }

   /**
    * Resets the user's password based on the provided token and new password.
    *
    * @param passwordResetConfirmDTO       Dto with password reset token & new password.
    */
   public void resetPassword(PasswordResetConfirmDTO passwordResetConfirmDTO) {
      EmailVerificationToken resetToken = emailVerificationTokenRepository.findByToken(passwordResetConfirmDTO.getToken())
         .orElseThrow(() -> new ResourceNotFoundException("Invalid or expired token"));

      if (resetToken.getExpirationDate().isBefore(LocalDateTime.now())) {
         throw new TokenCommons("Token has expired");
      }

      User user = resetToken.getUser();
      user.setPassword(passwordEncoder.encode(passwordResetConfirmDTO.getNewPassword()));
      userRepository.save(user);

      emailVerificationTokenRepository.delete(resetToken);  // Token should not be reused
   }
}