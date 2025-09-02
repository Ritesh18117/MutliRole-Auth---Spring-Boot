# 🏥 Multi-Role User Authentication System (Spring Boot + JWT)

A Spring Boot 3.5.5 (Java 21) project implementing **multi-role user authentication** using **Spring Security**, **JWT tokens**, and **PostgreSQL**.  

This project demonstrates how different user roles (`PATIENT`, `DOCTOR`, `EMPLOYEE`, `ADMIN`) can securely access APIs with role-based authorization.

---

## ✨ Features

- 🔐 **JWT-based Authentication** (no session management, fully stateless)
- 👥 **Multiple User Roles**
  - `PATIENT`
  - `DOCTOR`
  - `EMPLOYEE`
  - `ADMIN`
- 📦 **Spring Boot 3.5.5 + Java 21 + Maven**
- 🗄 **PostgreSQL Database** with Spring Data JPA
- ⚡ Password hashing with **BCrypt**
- 🛡 Role-based access using Spring Security
- 📑 Database seeder for initial roles and users

---

## ⚙️ Tech Stack

- **Spring Boot 3.5.5**
- **Java 21**
- **Spring Security + JWT (com.auth0)**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Maven**

---

## 📂 Project Structure

src/main/java/com/example/multirole
│
├── config/ # Spring Security & JWT filter configs
├── controller/ # REST controllers
├── entity/ # Entities (User, Role)
├── repository/ # JPA Repositories
├── service/ # Business logic + JWT service
└── util/ # Seeder or helper classes



## 🚀 Setup & Run

### Option 1: Run Locally (PostgreSQL Installed)
1. Clone the repo  
   ```bash
   git clone https://github.com/Ritesh18117/MutliRole-Auth---Spring-Boot.git
   cd MutliRole-Auth---Spring-Boot

2. Configure your PostgreSQL connection in application.properties.

3. Build and run:
  - mvn clean package
  - java -jar target/your-app-name.jar


4. The app starts on http://localhost:8080.

Option 2: Use Docker + Docker Compose (Recommended)
1. Ensure Docker & Docker Compose are installed.

2. Run:
  - docker-compose up --build

3. This builds the app image and spins up both the API and PostgreSQL DB.

4. Access the app on http://localhost:8080.
