# 🧾 Billing Application

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

Backend REST API for a complete billing management system, developed with Spring Boot and JPA/Hibernate.

---

## 📌 Features

- 🧑‍💼 User Management: Role-based access control  
- 🛍️ Product Catalog: CRUD for categories and products  
- 👥 Client Management: Customer information system  
- 🧾 Billing System: Full invoice generation  
- 📊 Data Validation: Jakarta Bean Validation  
- 🔒 Security Ready: Future JWT integration  


## 🚀 Quick Start

### Prerequisites

- JDK 17+  
- Maven 3.6+  
- PostgreSQL 12+ (optional)  

### Installation

- git clone https://github.com/VictorCazorla/SpringBoot-Example.git
- cd SpringBoot-Example
- mvn clean install

### Configuration

- Edit src/main/resources/application.properties:

### Database
- spring.datasource.url=jdbc:postgresql://localhost:5432/billingdb
- spring.datasource.username=dbuser
- spring.datasource.password=dbpass

### H2 Console (dev only)
- spring.h2.console.enabled=true
- spring.h2.console.path=/h2-console

### Running
- mvn spring-boot:run
- Access the API at: http://localhost:8080

## 📚 API Documentation

| Resource  | Method | Endpoint            | Description              |
|-----------|--------|---------------------|--------------------------|
| Users     | POST   | `/api/users`        | Register new user        |
| Users     | GET    | `/api/users`        | List users (Admin only)  |
| Products  | POST   | `/api/products`     | Create product           |
| Products  | GET    | `/api/products`     | Search products          |
| Invoices  | POST   | `/api/invoices`     | Generate new invoice     |
| Invoices  | GET    | `/api/invoices/{id}` | Get invoice with details |


## 🏗️ System Architecture

- Presentation Layer (REST Controllers)
- Business Layer (Services)
- Persistence Layer (Repositories)
- Database (JPA Entities)

## 🛠️ Tech Stack

- Core: Java 17, Spring Boot 3.1
- Persistence: JPA, PostgreSQL
- Validation: Jakarta Validation
- Build: Maven

## 📜 License

Distributed under the MIT License. See LICENSE for details.

## ✍️ Author

Víctor Cazorla
📧 victor.cazorla99@gmail.com
🔗 github.com/VictorCazorla
