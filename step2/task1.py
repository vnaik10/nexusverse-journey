class GameCharacter:
  def __init__(self,name, char_class, level):
    self.name = name
    self.char_class = char_class
    self.level = level
    
    
    
character = GameCharacter("Naruto Uzumaki", "Shinobi", 85)

print(f"character Name : {character.name}")
print(f"character Class : {character.char_class}")
print(f"character Level : {character.level}")