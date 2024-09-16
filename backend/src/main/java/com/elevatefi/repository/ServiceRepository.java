package com.elevatefi.repository;

import com.elevatefi.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for Service entities.
 */
@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, UUID> {
}