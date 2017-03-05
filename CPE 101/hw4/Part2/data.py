# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

from utility import *

class Point:
   def __init__(self, x, y, z):
      self.x = x
      self.y = y
      self.z = z

   def __eq__(self, other):
      return epsilon_equal(self.x, other.x) and epsilon_equal(self.y, other.y) and epsilon_equal(self.z, other.z)

class Vector:
   def __init__(self, x, y, z):
      self.x = x
      self.y = y
      self.z = z

   def __eq__(self, other):
      return epsilon_equal(self.x, other.x) and epsilon_equal(self.y, other.y) and epsilon_equal(self.z, other.z)
        
class Ray:
   def __init__(self, pt, dir):
      self.pt = pt
      self.dir = dir
      
   def __eq__(self, other):
      return (self.pt == other.pt) and (self.dir == other.dir)

class Sphere:
   def __init__(self, center, radius, color):
      self.center = center
      self.radius = radius
      self.color = color

   def __eq__(self, other):
      return (self.center == other.center) and epsilon_equal(self.radius, other.radius) and (self.color == color)

class Color:
   def __init__(self, r, g, b):
      self.r = r
      self.g = g
      self.b = b

   def __eq__(self, other):
      return epsilon_equal(self.r, other.r) and epsilon_equal(self.g, other.g) and epsilon_equal(self.b, other.b)
      
   
