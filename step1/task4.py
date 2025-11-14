def get_names_details(game):
  
  title = game["title"]
  genre = game["genre"]
  release_year = game["release_year"]
  
  formatted_string = f"Anime of Title {title} Of Genre {genre} Released in {release_year}"
  
  return formatted_string;


game_info = {
  "title": "The legend of Zelds",
  "genre" : "Adventure",
  "release_year" : 2023
}

print(get_names_details(game_info))