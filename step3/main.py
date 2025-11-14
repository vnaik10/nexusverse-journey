from  fastapi import FastAPI, Query
app = FastAPI()


@app.get("/")
def getName():
  return {"message": "Welcome to the NexusVerse API!"}


@app.get("/anime/{title}")
def getAnimeTitle(title : str):
  return {"the anime title ": title}



@app.get("/anime")
def get_games(genre: str | None = Query(None, description="Filter games by genre")):
  
  
  
   games = [
        {"title": "Elden Ring", "genre": "RPG"},
        {"title": "Valorant", "genre": "Shooter"},
        {"title": "God of War", "genre": "Action"},
        {"title": "Zelda: Tears of the Kingdom", "genre": "Adventure"},
    ]
   
   if genre:
     filtered = [g for g in games if genre.lower() in g["genre"].lower()]
    
   return {"filtered_by": genre, "games": filtered}
