# Medical Log API Documentation

This document describes the REST API endpoints available in the Medical Log backend application. The API runs on `http://localhost:8080` by default.

---

## Patient API

### 1. Get All Patients
Retrieves a list of all registered patients.

- **URL:** `/patients`
- **Method:** `GET`
- **Success Response:** `200 OK`
- **Response Body Example:**
  ```json
  [
    {
      "patientId": 1,
      "name": "John Doe",
      "lastVisitDate": "2026-03-19",
      "entries": []
    }
  ]
  ```

### 2. Create a Patient
Creates a new patient. The `lastVisitDate` is automatically set to the current date by the server.

- **URL:** `/patients`
- **Method:** `POST`
- **Headers:** `Content-Type: application/json`
- **Request Body Example:**
  ```json
  {
    "name": "Jane Smith"
  }
  ```
- **Success Response:** `201 CREATED`

### 3. Get Patient by ID
Retrieves details of a specific patient.

- **URL:** `/patients/{patientId}`
- **Method:** `GET`
- **Success Response:** `200 OK`
- **Error Response:** `400 BAD REQUEST` (If patient is not found)

### 4. Update a Patient
Updates an existing patient's details.

- **URL:** `/patients/{patientId}`
- **Method:** `PUT`
- **Headers:** `Content-Type: application/json`
- **Request Body Example:**
  ```json
  {
    "name": "Jane Smith Updated"
  }
  ```
- **Success Response:** `200 OK`
- **Error Response:** `404 NOT FOUND`

### 5. Delete a Patient
Deletes a specific patient by their ID.

- **URL:** `/patients/{patientId}`
- **Method:** `DELETE`
- **Success Response:** `200 OK`
- **Error Response:** `400 BAD REQUEST`

---

## Medical Entry API (Nested)

These endpoints are strictly scoped to a specific `patientId`.

### 1. Get All Entries for a Patient
Retrieves a list of all medical entries belonging to a specific patient.

- **URL:** `/patients/{patientId}/entries`
- **Method:** `GET`
- **Success Response:** `200 OK`
- **Response Body Example:**
  ```json
  [
    {
      "id": 1,
      "date": "2026-03-19T11:20:00",
      "title": "General Checkup",
      "notes": "Patient is in good health."
    }
  ]
  ```

### 2. Create an Entry for a Patient
Creates a new medical entry for a specific patient. The `date` is automatically set to the current timestamp. If the patient does not exist, a 404 is returned.

- **URL:** `/patients/{patientId}/entries`
- **Method:** `POST`
- **Headers:** `Content-Type: application/json`
- **Request Body Example:**
  ```json
  {
    "title": "Blood Test Results",
    "notes": "All levels are normal. Prescribed vitamins."
  }
  ```
  *(Note: The `patientId` is inferred from the URL, so you do not need to pass it in the JSON body).*
- **Success Response:** `201 CREATED`
- **Error Response:** `404 NOT FOUND`

### 3. Get Entry by ID
Retrieves a specific medical entry for a specific patient.

- **URL:** `/patients/{patientId}/entries/{entryId}`
- **Method:** `GET`
- **Success Response:** `200 OK`
- **Error Response:** `404 NOT FOUND`

### 4. Update an Entry
Updates the title and/or notes of an existing entry for a specific patient.

- **URL:** `/patients/{patientId}/entries/{entryId}`
- **Method:** `PUT`
- **Headers:** `Content-Type: application/json`
- **Request Body Example:**
  ```json
  {
    "title": "Updated Blood Test Results",
    "notes": "Adding additional notes regarding cholesterol."
  }
  ```
- **Success Response:** `200 OK`
- **Error Response:** `404 NOT FOUND`

### 5. Delete an Entry
Deletes a specific medical entry belonging to a specific patient by its ID.

- **URL:** `/patients/{patientId}/entries/{entryId}`
- **Method:** `DELETE`
- **Success Response:** `200 OK`
- **Error Response:** `404 NOT FOUND`
