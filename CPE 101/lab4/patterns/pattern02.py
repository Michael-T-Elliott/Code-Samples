import driver

def letter(row, col):
    if (row < 10):
        return 'R'
    if (row >= 10):
        return 'Q'

if __name__ == '__main__':
      driver.comparePatterns(letter)
