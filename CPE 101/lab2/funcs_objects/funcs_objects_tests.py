# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import unittest
import funcs
import objects
import funcs_objects

class TestCases(unittest.TestCase):
   def test_point(self):
      pt1 = objects.Point(15, 16.6)
      self.assertAlmostEqual( pt1.x, 15)
      self.assertAlmostEqual( pt1.y, 16.6)

      pt2 = objects.Point(2, 0)
      self.assertAlmostEqual(pt2.x, 2)
      self.assertAlmostEqual(pt2.y, 0)


   def test_circle(self):
      pt1 = objects.Circle(17, 3.14)
      self.assertAlmostEqual( pt1.c, 17)
      self.assertAlmostEqual( pt1.r, 3.14)

      pt2 = objects.Circle(10, 9.99)
      self.assertAlmostEqual(pt2.c, 10)
      self.assertAlmostEqual(pt2.r, 9.99)

   def test_distance(self):
      pt1 = funcs_objects.Point(10, -5)
      pt2 = funcs_objects.Point(50, 0)
      self.assertAlmostEqual(funcs_objects.distance(pt1,pt2), 40.31128874149275)

      pt1 = funcs_objects.Point(0,0)
      pt2 = funcs_objects.Point(0,0)
      self.assertAlmostEqual(funcs_objects .distance(pt1,pt2), 0)

   def test_circles_overlap(self):
      pt1 = funcs_objects.Circle(funcs_objects.Point(0,0), 10)
      pt2 = funcs_objects.Circle(funcs_objects.Point(15,15), 2 )
      self.assertFalse(funcs_objects.circles_overlap(pt1, pt2))

      pt1 = funcs_objects.Circle(funcs_objects.Point(9,0),18)
      pt2 = funcs_objects.Circle(funcs_objects.Point(0,0),6)
      self.assertTrue(funcs_objects.circles_overlap(pt1, pt2))


if __name__ == '__main__':
   unittest.main()

