# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

class Circle:
    def __init__(self,center, radius):
        self.center = center
        self.radius = radius

def area(my_circle):
    return 3.14159 * my_circle.radius**2

def min_area(my_circle_1, my_circle_2):
    if area(my_circle_1) > area(my_circle_2):
        return my_circle_2.center
    return my_circle_1.center


    
