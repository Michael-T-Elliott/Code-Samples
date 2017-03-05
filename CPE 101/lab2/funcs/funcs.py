# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import math

def f(x):
    return 7*(x**2)+(2*x)

def g(x,y):
    return (x*x)+(y*y)

def hypotenuse(a,b):
    return math.sqrt(g(a,b))

def is_positive(x):
    return x >= 0
