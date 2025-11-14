from fastapi import FastAPI, HTTPException
from fastapi.responses import JSONResponse
from models import Anime
from database import db
from bson import ObjectId

app = FastAPI()
collection = db["anime"]

def serialize_anime(anime):
    anime["_id"] = str(anime["_id"])
    return anime



@app.get("/api/greet")
def greet():
    return {"greet": "Welcome To NexaVerse!!"}



@app.get("/anime")
def get_all_anime():
    animes = collection.find()
    return {"data": [serialize_anime(anime) for anime in animes]}



@app.get("/anime/{id}")
def get_anime_by_id(id: str):
    anime = collection.find_one({"_id": ObjectId(id)})
    if not anime:
        raise HTTPException(status_code=404, detail="Anime not found")
    return {"data": serialize_anime(anime)}



@app.post("/anime")
def create_anime(anime: Anime):
    collection.insert_one(anime.dict())
    return JSONResponse(status_code=201, content={"message": "Anime created successfully"})



@app.put("/anime/{id}")
def update_anime_by_id(id: str, anime: Anime):
    existing = collection.find_one({"_id": ObjectId(id)})
    if not existing:
        raise HTTPException(status_code=404, detail="Anime not found")

    update_data = {k: v for k, v in anime.dict().items() if v is not None}
    collection.update_one({"_id": ObjectId(id)}, {"$set": update_data})

    updated = collection.find_one({"_id": ObjectId(id)})
    return JSONResponse(content={
        "message": "Anime updated successfully",
        "data": serialize_anime(updated)
    })



@app.delete("/anime/{id}")
def delete_anime_by_id(id: str):
    anime = collection.find_one({"_id": ObjectId(id)})
    if not anime:
        raise HTTPException(status_code=404, detail="Anime not found")

    collection.delete_one({"_id": ObjectId(id)})
    return JSONResponse(status_code=200, content={"message": "Anime deleted successfully"})
