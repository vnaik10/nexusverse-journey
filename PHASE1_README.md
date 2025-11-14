# Project Overview

## 📁 Project Structure

```
step1/
  task1.py
  task2.py
  task3.py
  task4.py

step2/
  task1.py
  task2.py

step3/
  main.py

step4/
  database.py
  models.py
  main.py     ← FastAPI app (Anime CRUD)

step5/
  fastapi_app.py
  celery_worker.py
```

**Notes:**

* `step4/main.py` hosts the primary CRUD API.
* `step5/fastapi_app.py` exposes Celery-powered endpoints.

---

## 🛠️ Technologies Used

| Component         | Technology                       |
| ----------------- | -------------------------------- |
| Backend Framework | FastAPI                          |
| Database          | MongoDB (`anime_codex_db.anime`) |
| Task Queue        | Celery                           |
| Message Broker    | Redis                            |
| Language          | Python 3                         |

---

## 🔌 Environment Setup

### 1. Create Virtual Environment

```bash
python -m venv venv
```

**Activate:**

* **Windows:**

  ```bash
  venv\Scripts\activate
  ```
* **macOS/Linux:**

  ```bash
  source venv/bin/activate
  ```

### 2. Install Dependencies

```bash
pip install -r requirements.txt
```

### 3. Start MongoDB and Redis

**Using Docker:**

```bash
docker run -d --name mongo -p 27017:27017 mongo
docker run -d --name redis -p 6379:6379 redis
```

**MongoDB Database:**

* Database: `anime_codex_db`
* Collection: `anime`

### 4. Run FastAPI CRUD App (Step 4)

```bash
uvicorn step4.main:app --reload --port 8000
```

### 5. Run FastAPI Celery App (Step 5)

```bash
uvicorn step5.fastapi_app:app --reload --port 8001
```

### 6. Start Celery Worker

```bash
celery -A step5.celery_worker worker --loglevel=info
```

---

## 📡 API Documentation & Endpoints

FastAPI auto-generated documentation:

* [http://localhost:8000/docs](http://localhost:8000/docs)
* [http://localhost:8001/docs](http://localhost:8001/docs)

---

## 🟢 Health Check

**GET `/api/greet`**

* Confirms the service is operational.

---

## 📚 Anime CRUD API

### **GET `/anime`**

Retrieve all anime documents.

### **GET `/anime/{id}`**

Retrieve a specific record by MongoDB `_id`.

### **POST `/app`**

Create a new anime entry.

**Example Payload:**

```json
{
  "title": "Naruto",
  "genre": "Shonen",
  "year": 2002
}
```

### **PUT `/anime/{id}`**

Update an existing anime document.

### **DELETE `/anime/{id}`**

Remove a record from the collection.

---

## ⏳ Celery Background Task API

### **POST `/anime/scrape`**

Initiates a simulated long-running scrape.

**Response Example:**

```json
{
  "message": "scrapping initiated",
  "task_id": "xxxx",
  "status_endpoint": "/anime/status/xxxx"
}
```

### **GET `/anime/status/{task_id}`**

Retrieve status and result of the background task.

**Example Response:**

```json
{
  "task_id": "123",
  "status": "SUCCESS",
  "result": "...",
  "progress": null
}
```

---

## 🧪 Testing the API

### Sample Commands

```bash
curl http://localhost:8000/anime
```

```bash
curl -X POST http://localhost:8000/app \
  -H "Content-Type: application/json" \
  -d '{ "title": "Naruto", "genre": "Shonen" }'
```

```bash
curl -X POST http://localhost:8001/anime/scrape
```

---
