from fastapi import FastAPI
import celery_worker
import time 
from celery.result import AsyncResult


app = FastAPI()

@app.get("/greet")
def greetUser():
  return {"greet":f"Hello Your Fast Api is running Successfully!!"}

@app.post("/anime/scrape")
def begin_anime_scrape():
  task = celery_worker.anime_scraper.delay()
  return  {
            "message": "scrapping initiated",
            "task_id": task.id,
            "status_endpoint": f"/anime/status/{task.id}"
          }

@app.get("/anime/status/{task_id}")
def anime_get_status(task_id:str):
  
  task = AsyncResult(task_id,app = celery_worker.celery)
  
  return{
          "task_id":task_id,
          "status":task.status,
          "result": task.result if task.ready() else None,
          "progress":task.info  if task.status == "PROGRESS" else None
        } 
  
  
  
  
