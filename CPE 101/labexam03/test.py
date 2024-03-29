import unittest
from conversion import *
import math
from math import *
from utility import *

class TestCases(unittest.TestCase):
   def test_convert(self):
      rect = (0, 1)
      polar = math.pi/2
      testpoint = Point(rect, polar)
      self.assertEqual(convert(0, 1), testpoint)

   def test_convert_list(self):
      rect1 = (0, 1)
      polar1 = math.pi/2
      testpoint1 = Point(rect1, polar1)
      rect2 = (0, -1)
      polar2 = (3*(math.pi/2))
      testpoint2 = Point(rect2, polar2)
      point_list = (Point((0,1), (0,0)), Point((0,-1), (0,0)))
      new_list = (testpoint1, testpoint2)
      self.assertEqual(convert_list(point_list), new_list)


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

