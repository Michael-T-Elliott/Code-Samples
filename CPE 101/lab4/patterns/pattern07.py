import driver

def letter(row, col):
   if (row > 1 and row < 7) and (col > 3 and col < 13):
      if (row > 3 and row < 6 and col > 6 and col < 10):
         return 'X'
      elif (row > 1 and row < 6 and col > 3 and col < 10):  
         return 'Z'
      elif (row > 3 and row < 7 and col > 6 and col < 13):  
         return 'B'
      else:
         return 'T'
   else:
         return 'T'

if __name__ == '__main__':
      driver.comparePatterns(letter)
