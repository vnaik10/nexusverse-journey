## Phase 1 — Process, Code Logic, Challenges & Solutions

This section describes the complete learning journey from Step 1 to Step 5, covering thought‑process, implementation patterns, challenges, and solutions.

### ✅ Step 1 — Python Core Concepts

**What I Did**

* Reviewed variables, data types, lists, dictionaries.
* Practiced control flow using loops and conditionals.
* Worked with functions using parameters and return values.
* Wrote simple exercises such as printing formatted character stats and iterating over anime lists.

**Experience**
This step was smooth and served mainly as a refresher.

**Key Learning**

* Reinforced core Python syntax.
* Improved comfort with small scripts.
* Built a base for later API logic.

### ✅ Step 2 — Object-Oriented Python

**What I Built**
A `GameCharacter` class with:

* name
* character_class
* level

Methods implemented:

* `display_stats()`
* `level_up()`

**Experience**
Comfortable due to prior experience with C++ and Java.

**Challenges**
None — adapting to Python’s class syntax was simple.

**Key Learning**

* Python’s OOP syntax is clean and readable.
* Methods and attributes integrate well with backend logic.

### ✅ Step 3 — FastAPI Basics

**What I Implemented**
Inside `step3/main.py`:

* A root endpoint.
* Basic path and query parameters.

**Experience**
First time using FastAPI but very smooth because of prior Spring Boot knowledge.

**Challenges**
None — FastAPI and Uvicorn ran correctly on first try.

**Key Learning**

* FastAPI’s syntax is modern and expressive.
* Pydantic validation is extremely convenient.
* Feels similar to Spring Boot, but lighter.

### ✅ Step 4 — MongoDB CRUD API (Anime Codex)

**What I Built**
In `step4/main.py`:

* Connected FastAPI with MongoDB.
* Implemented full CRUD for anime.

Database structure:

* Database: `anime_codex_db`
* Collection: `anime`

**Core Logic**

* Used `pymongo` for database operations.
* Implemented insert, update, fetch, delete.
* Returned clean JSON from FastAPI.

**Challenges**
Handling MongoDB’s ObjectId caused errors.

**Breakthrough**
Converting ObjectId to a string resolved the issue:

```
"id": str(document["_id"])
```

**Key Learning**

* Always convert ObjectId → string.
* Clean CRUD structure improves scalability.
* Python + MongoDB enables flexible data models.

### ✅ Step 5 — Celery & Redis Background Tasks

**What I Built**
In `step5/fastapi_app.py` and `celery_worker.py`:

* Created a Celery worker.
* Configured Redis as message broker.
* Implemented a simulated background scraping task.
* Added `/anime/scrape` and `/anime/status/{task_id}` endpoints.

**Experience**
First exposure to Celery, Redis, and distributed workers — very impressive.

**Challenges**
Celery failed on Windows.

**Breakthrough**
Switching to WSL fixed everything. Tasks ran, statuses updated, background execution worked smoothly.

**Key Learning**

* Redis + Celery provide a strong background task workflow.
* Excellent for long processes like scraping or reporting.
* Motivated to use Celery in future projects.
