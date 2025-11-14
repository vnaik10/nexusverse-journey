from pydantic import BaseModel
from typing import Optional

class Anime(BaseModel):
  title:     Optional[str] = None 
  genre:     Optional[str] = None
  episodes:  Optional[str] = None
  rating:    Optional[str] = None
  

