# 🚀 LeetCode Clone – Microservices Project

## 📌 Overview

This project is a **LeetCode-like coding platform** built using **Spring Boot Microservices Architecture**.

It demonstrates real-world backend concepts like:

* Microservices design
* Service discovery
* API Gateway
* Authentication service
* Database integration
* Basic security

---

## 🧱 Architecture

Client → API Gateway → Microservices
            ↓
         Eureka Server

---

## ⚙️ Services Implemented (Day 1)

### 1️⃣ Discovery Server (Eureka)

* Service registry for all microservices
* Runs on **port 8761**
* Annotation: `@EnableEurekaServer`

---

### 2️⃣ API Gateway

* Entry point for all client requests
* Routes requests to services
* Connected to Eureka
* Runs on **port 8080**

---

### 3️⃣ Auth Service

* Handles user registration and login
* Connected to:

  * Eureka Server
  * MySQL Database
* Runs on **port 8081**

---

## 🧩 Tech Stack

* Java 17
* Spring Boot
* Spring Cloud (Eureka, Gateway)
* Spring Security (basic)
* Spring Data JPA
* MySQL
* Maven

---

## 🧠 Key Concepts Learned

### 🔹 Microservices

* Each service runs independently
* Communication via REST APIs

---

### 🔹 Eureka Server

* Registers all services
* Enables service discovery

---

### 🔹 API Gateway

* Single entry point
* Handles routing

---

### 🔹 Layered Architecture

Controller → Service → Repository → Database

---

### 🔹 Entity (JPA)

* Java class mapped to database table

---

### 🔹 Repository

* Extends `JpaRepository`
* Provides built-in CRUD operations

---

### 🔹 Service Layer

* Contains business logic
* Handles registration and login

---

### 🔹 Controller Layer

* Exposes REST APIs
* Handles client requests

---

### 🔹 Spring Security (Basic)

* By default blocks all APIs
* Configured to allow:

  * `/auth/register`
  * `/auth/login`

---

## 🔐 APIs Implemented

### Register User

POST `/auth/register`

```json
{
  "username": "user",
  "email": "user@gmail.com",
  "password": "123",
  "role": "USER"
}
```

---

### Login User

POST `/auth/login?email=user@gmail.com&password=123`

---

## ⚠️ Current Limitations

* Password stored in plain text ❌
* No JWT authentication ❌
* No authorization ❌

---

## 🚀 Next Steps

* Implement JWT Authentication
* Encrypt passwords (BCrypt)
* Secure APIs
* Add more microservices:

  * User Service
  * Problem Service
  * Submission Service

---

## 📅 Progress

### ✅ Day 1

* Project setup (multi-module structure)
* Eureka Server
* API Gateway
* Auth Service
* Database integration
* Basic APIs
* Security configuration

---

## 🧠 Summary

Built a working microservice system with:

* Service discovery
* API routing
* Authentication basics
* Database integration

---

## 👨‍💻 Author

Surya
