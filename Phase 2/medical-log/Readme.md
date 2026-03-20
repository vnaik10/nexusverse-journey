# 🚀 Phase 2: Java Backend Powerhouse — Medical Log API

## 📌 Objective

Build a robust, secure, and strongly-typed backend service using **Java + Spring Boot**, focusing on structured medical data and real-world backend architecture.

---

## 🧠 What I Learned

* Java fundamentals (OOP, classes, objects, types)
* Spring Boot project setup
* Dependency Injection (DI)
* MVC Architecture
* REST API design
* Database integration using PostgreSQL (Supabase)
* JPA & Hibernate for data persistence
* Entity relationships (One-to-Many)

---

## 🏗️ Project Overview

This project is a **Medical Log Backend System** that allows:

* Managing patients
* Storing medical journal entries per patient
* Performing full CRUD operations
* Handling relational data using JPA

---

## ⚙️ Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL (Supabase)**
* **Hibernate**
* **Maven**

---

## 🧩 System Architecture

```
Controller → Service → Repository → Database
```

* **Controller** → Handles API requests
* **Service** → Business logic
* **Repository** → Database operations
* **Database** → Supabase PostgreSQL

---

## 🗂️ Data Model

### 👤 Patient

* `patientId` (Long)
* `name` (String)
* `lastVisitDate` (LocalDate)
* `entries` (List of MedicalEntry)

### 📝 MedicalEntry

* `id` (Long)
* `date` (LocalDateTime)
* `title` (String)
* `notes` (String)
* `patient` (Many-to-One relationship)

---

## 🔗 Relationship

```
One Patient → Many Medical Entries
```

* Implemented using:

  * `@OneToMany`
  * `@ManyToOne`

---

## 📡 API Endpoints

### 👤 Patient APIs

| Method | Endpoint         | Description        |
| ------ | ---------------- | ------------------ |
| GET    | `/patients`      | Get all patients   |
| POST   | `/patients`      | Create new patient |
| GET    | `/patients/{id}` | Get patient by ID  |
| PUT    | `/patients/{id}` | Update patient     |
| DELETE | `/patients/{id}` | Delete patient     |

---

### 📝 Medical Entry APIs (Nested)

| Method | Endpoint                           | Description                  |
| ------ | ---------------------------------- | ---------------------------- |
| GET    | `/patients/{id}/entries`           | Get all entries of a patient |
| POST   | `/patients/{id}/entries`           | Create entry for patient     |
| GET    | `/patients/{id}/entries/{entryId}` | Get entry by ID              |
| PUT    | `/patients/{id}/entries/{entryId}` | Update entry                 |
| DELETE | `/patients/{id}/entries/{entryId}` | Delete entry                 |

---

## 🧪 Example API Request

### Create Medical Entry

**POST** `/patients/2/entries`

```json
{
  "title": "Annual Checkup",
  "notes": "Patient is healthy and vitals are normal"
}
```

---

## 🛢️ Database Configuration

Uses **Supabase PostgreSQL**

```properties
spring.datasource.url=jdbc:postgresql://<host>:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

---

## ▶️ How to Run

1. Clone the repository
2. Configure database in `application.properties`
3. Run the application:

```
mvn spring-boot:run
```

4. Server runs at:

```
http://localhost:8080
```

---

## 🔥 Key Features

* Full CRUD operations
* Clean layered architecture
* RESTful API design
* Entity relationship mapping
* Automatic table creation using JPA
* Integration with cloud database (Supabase)

---

## 🚀 Future Improvements

* JWT Authentication (Security)
* DTO Layer (Clean API responses)
* Global Exception Handling
* Validation (`@NotNull`, `@NotBlank`)
* Swagger API Documentation

---

## 🎯 Outcome

This project demonstrates:

* Real-world backend development skills
* Strong understanding of Spring Boot
* Database design and relationships
* API design and implementation

---

## 📌 Repository Structure

```
Phase 2/
   medical-log/
      src/
      pom.xml
      README.md
```

---

## 🙌 Author

**Vikas Naik**

---

## ⭐ Final Note

This project is part of my **backend engineering journey** and represents my progress toward building **enterprise-grade backend systems**.
