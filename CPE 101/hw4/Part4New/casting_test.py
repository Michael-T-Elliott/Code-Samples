# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

from cast import *
from data import *


min_x = -10
max_x = 10
min_y = -7.5
max_y = 7.5
width = 1024
height = 768
light = Light(Point(-100, 100, -100), Color(1.5, 1.5, 1.5))
eye_point = Point(0.0, 0.0, -14.0)
ambient_light = Color(1.0, 1.0, 1.0)
sphere_list = [Sphere(Point(1.0, 1.0, 0.0), 2.0, Color(0,0,1), Finish(0.2, 0.4)), 
               Sphere(Point(0.5, 1.5, -3.0), 0.5, Color(1,0,0), Finish(0.4,0.4))]


print "P3"
print width, height
print "255"


cast_all_rays(min_x, max_x, min_y, max_y, width, height, eye_point, sphere_list, ambient_light, light)
