import driver

def letter(row, col):
    if (row < 2 or row > 4) or (col < 3 or col > 6):
        return 'S'
    else:
        return 'M'

if __name__ == '__main__':
      driver.comparePatterns(letter)
