class GameCharacter:
  def __init__(self,name, char_class, level):
    self.name = name
    self.char_class = char_class
    self.level = level
    
  def incrementLevel(self):
      self.level += 1
      
  def displayDetails(self):
      print(f"character Name : {self.name}")
      print(f"character Class : {self.char_class}")
      print(f"character Level : {self.level}")
    


char1 = GameCharacter("Naruto Uzumaki", "Shinobi", 85)
char2 = GameCharacter("Goku", "Saiyan Warrior", 49)

char1.displayDetails()
char2.displayDetails()

char1.incrementLevel()
char2.incrementLevel()

char1.displayDetails()
char2.displayDetails()