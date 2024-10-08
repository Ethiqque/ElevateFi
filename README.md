# ElevateFi: A Comprehensive Financial Goal Management Platform

![Elevate](https://static1.squarespace.com/static/589c9693f5e2314b231680e5/t/654e7c08d313c21e90ff54ee/1722989455844/)

## Introduction

ElevateFi is a full-stack application designed to empower users in managing their financial goals effectively. Built with a robust backend using **Java Spring Boot** and a dynamic frontend powered by **React**, the entire system is containerized using **Docker** for streamlined operations. The application's images are stored in **Amazon Elastic Container Registry (ECR)** and deployed to **Amazon Elastic Container Service (ECS)** for scalable backend processing. The frontend is hosted on **Amazon S3**, ensuring high availability and optimal performance. **Continuous Integration and Deployment (CI/CD)** pipelines are managed through **Jenkins**, automating the entire deployment process for maximum efficiency.

## Key Features

- **Real-time Notifications**  
  Keep users informed with live updates on their financial goals and platform activities.
  
- **Social Media Integration**  
  Enable users to share progress and achievements with their network.

- **Gamification Elements**  
  Engage users with interactive features like rewards, badges, and milestones to boost motivation.

- **AI-Powered Financial Advisor**  
  Provide personalized financial advice with machine learning algorithms to help users make informed decisions.

- **Video Consultation Feature**  
  Facilitate one-on-one financial consultations directly through the platform.

- **Multi-language Support**  
  Cater to a global audience with support for multiple languages.

- **Progressive Web App (PWA) Capabilities**  
  Deliver a seamless experience across devices, whether on desktop or mobile, even in offline mode.

- **Data Visualization Dashboard**  
  Offer users insightful charts and graphs to track their financial progress in real-time.

- **Collaborative Goal Setting**  
  Allow users to work together on shared financial goals with friends, family, or advisors.

- **Marketplace for Financial Products**  
  Provide a curated marketplace for users to discover financial products tailored to their needs.

- **User Authentication and Authorization**  
  Ensure secure access with role-based authentication, protecting sensitive user information.

- **Blog System with CRUD Operations**  
  Enable users to create, read, update, and delete blog posts to share financial tips and stories.

- **Email Collection and Newsletter Integration**  
  Collect emails and send curated newsletters with the latest financial trends and platform updates.

- **Appointment Scheduling**  
  Allow users to schedule meetings with financial advisors or experts directly through the platform.

- **User Dashboard**  
  A centralized hub for users to manage their financial goals, track progress, and access key features.

---

## Project Structure

```plaintext
elevatefi/
├── frontend/
│   ├── public/
│   │   ├── index.html
│   │   ├── favicon.ico
│   │   ├── manifest.json
│   │   └── service-worker.js
│   ├── src/
│   │   ├── assets/
│   │   │   ├── images/
│   │   │   ├── fonts/
│   │   │   ├── icons/
│   │   │   └── locales/
│   │   ├── components/
│   │   │   ├── common/
│   │   │   ├── layout/
│   │   │   ├── home/
│   │   │   ├── services/
│   │   │   ├── blog/
│   │   │   ├── appointments/
│   │   │   ├── auth/
│   │   │   ├── admin/
│   │   │   ├── notifications/
│   │   │   │   ├── NotificationCenter.jsx
│   │   │   │   └── NotificationItem.jsx
│   │   │   ├── social/
│   │   │   │   ├── SocialShare.jsx
│   │   │   │   └── SocialFeed.jsx
│   │   │   ├── gamification/
│   │   │   │   ├── AchievementBadge.jsx
│   │   │   │   └── ProgressTracker.jsx
│   │   │   ├── ai-advisor/
│   │   │   │   ├── AdvisorChat.jsx
│   │   │   │   └── RecommendationCard.jsx
│   │   │   ├── video-consultation/
│   │   │   │   ├── VideoRoom.jsx
│   │   │   │   └── CallControls.jsx
│   │   │   ├── data-visualization/
│   │   │   │   ├── FinancialChart.jsx
│   │   │   │   └── GoalProgressChart.jsx
│   │   │   ├── collaborative-goals/
│   │   │   │   ├── GoalBoard.jsx
│   │   │   │   └── GoalCard.jsx
│   │   │   └── marketplace/
│   │   │       ├── ProductList.jsx
│   │   │       └── ProductCard.jsx
│   │   ├── pages/
│   │   │   ├── HomePage.jsx
│   │   │   ├── ServicesPage.jsx
│   │   │   ├── BlogPage.jsx
│   │   │   ├── AppointmentPage.jsx
│   │   │   ├── Login.jsx
│   │   │   ├── Register.jsx
│   │   │   ├── AdminDashboard.jsx
│   │   │   ├── UserDashboard.jsx
│   │   │   ├── VideoConsultationPage.jsx
│   │   │   ├── AIAdvisorPage.jsx
│   │   │   ├── MarketplacePage.jsx
│   │   │   └── CollaborativeGoalsPage.jsx
│   │   ├── redux/
│   │   │   ├── actions/
│   │   │   ├── reducers/
│   │   │   ├── slices/
│   │   │   └── store.js
│   │   ├── services/
│   │   │   ├── api.js
│   │   │   ├── socket.js
│   │   │   ├── i18n.js
│   │   │   └── aiService.js
│   │   ├── styles/
│   │   ├── utils/
│   │   ├── hooks/
│   │   ├── context/
│   │   │   ├── ThemeContext.js
│   │   │   └── LanguageContext.js
│   │   ├── App.jsx
│   │   └── main.jsx
│   ├── .gitignore
│   ├── package.json
│   ├── vite.config.js
│   └── README.md
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── elevatefi/
│   │   │   │           └── backend/
│   │   │   │               ├── common/
│   │   │   │               ├── config/
│   │   │   │               ├── controllers/
│   │   │   │               ├── dto/
│   │   │   │               ├── entities/
│   │   │   │               ├── hook/
│   │   │   │               ├── repositories/
│   │   │   │               ├── services/
│   │   │   │               ├── tokens/
│   │   │   │               └── BackendApplication.java
│   ├── .mvn/
│   ├── target/
│   ├── Dockerfile.backend
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── README.md
├── schemas_designs/
│   ├── database_schema.sql
│   └── wireframes/
├── .gitignore
```
