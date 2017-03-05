import driver

def letter(row, col):
    if (col == row) or (col == (6-row)):
        return 'X'
    else:
        return 'O'

if __name__ == '__main__':
      driver.comparePatterns(letter)
