anime_list = ["attack on titan", "haikyu", "demon slayer", "one piece","naruto"]

fav_anime = "naruto"

for anime in anime_list:
  if(anime == fav_anime):
    print(f"{anime} is my Favorite anime")
  else:
    print(anime)
    
    
animes = {
  "naruto": 8.5,
  "demon slayer": 9.4,
  "one piece" : 7.3,
  "attack on titan" : 8.9
  }


for anime, rating in animes.items():
  if(rating >= 9.0 and rating <= 10.0):
    print("Anime of raing 9.0 - 10.0 ")
    print(anime)
    
  elif(rating >= 8.0 and rating < 9.0):
    print("Anime of raing 8.0 - 9.0 ")
    print(anime)
    
  else:
    print("Anime of raing less than 8.0 ")
    print(anime)
      

