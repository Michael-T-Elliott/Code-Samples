# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

def max_101(x, y):
    if (x > y):
        return x
    return y

def max_of_three(x, y, z):
    return max_101(max_101(x, y), z)

def rental_late_fee(a):
    if (a <= 0):
        return 0
    elif (a <= 9):
        return 5
    elif (a <= 15):
        return 7
    elif (a <= 24):
        return 19
    else:
        return 100
         
