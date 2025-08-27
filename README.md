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

