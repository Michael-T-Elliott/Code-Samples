# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import funcs

def distance(pt1, pt2):
    return funcs.hypotenuse(pt1.x-pt2.x, pt1.y-pt2.y)

def circles_overlap(a, b):
    return distance(a.c, b.c) < a.r + b.r

class Point():
    def __init__(self, x, y):
        self.x = x
        self.y = y

class Circle():
    def __init__(self, c, r):
        self.c = c
        self.r = r
