from celery import Celery
import time


celery = Celery(
    "anime_scraper",
    broker="redis://localhost:6379/0",
    backend="redis://localhost:6379/1",
)

celery.conf.update(
    task_serializer="json",
    result_serializer="json",
    accept_content=["json"],
    timezone="UTC",
    enable_utc=True,
)

@celery.task
def anime_scraper():
  print("scrapping Initiated")
  
  i = 0;
  
  while i<15:
    print(f"step {i+1}/15 Completed...")
    time.sleep(1)
    i+= 1
    
  return f"scrapping completed"
