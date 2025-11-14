anime_list = ["attack on titan", "haikyu", "demon slayer", "one piece"]
anime_list.append("naruto")
print(anime_list)

game_info = [{
  "title": "The legend of Zelds",
  "genre" : "Adventure",
  "release_year" : 2023
},
{
        "title": "Elden Ring",
        "genre": "Action RPG",
        "release_year": 2022
    }
]


print(game_info)
print(anime_list)

for game in game_info:
    print(f"{game['title']} ({game['release_year']}) - {game['genre']}")
    
