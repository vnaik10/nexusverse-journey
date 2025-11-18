# Phase 2 – Step 4: Java & Spring Boot Fundamentals  

---

## 🎯 Objective  
Set up a Spring Boot backend project and demonstrate core Java fundamentals by implementing a `Patient` model (POJO).  
This forms the foundation for building an enterprise-grade medical journal API in the next step.

---

## 🏗️ Technologies Used  
- **Java 17**
- **Spring Boot 3**
- **Maven**

---

## 🧠 Java Concepts Demonstrated

### Classes & Objects  
Defined a `Patient` class as a blueprint for patient data. Instances of this class represent real patient records.

### Types  
- Primitives/Wrapper: `Long`
- Reference types: `String`, `LocalDate`

### Encapsulation  
All class fields were marked `private` and accessed via public getters and setters.

### Constructors  
- **No-Args Constructor:** Required by frameworks and JSON serialization  
- **Parameterized Constructor:** For quick object initialization

### Method Override  
Overrode `toString()` to provide a meaningful text representation.

---

## 📝 Project Structure
src/main/java/com/medical/medical_api/
├── MedicalApiApplication.java
└── model/
└── Patient.java


---

## 📦 Patient Model

**File:** `src/main/java/com/medical/medical_api/model/Patient.java`  
**Fields:**
- `Long patientId`
- `String name`
- `LocalDate lastVisitDate`

This class is used to represent patient data in a structured and strongly-typed format.

---

## 🔧 Planned Enhancements (Step 5 and Beyond)

To simplify and scale the model class, the following annotations will be added when integrating with the database:

```java
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
```
@Entity: Marks this class as a JPA entity for persistence.

@NoArgsConstructor, @AllArgsConstructor: Eliminates manual constructor boilerplate (via Lombok).

@Getter, @Setter: Auto-generate getters and setters to simplify encapsulation boilerplate.


### How to Run:
```bash
mvn spring-boot:run
```
Or open the project in your IDE and run MedicalApiApplication.java.
