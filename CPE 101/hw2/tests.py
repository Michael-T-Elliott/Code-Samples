# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

from vector_math import *
import data
import utility
import math
import unittest

class TestData(unittest.TestCase):
    def test_epsilon_equal1(self):
        p1 = data.Point(1,3,5)
        p2 = data.Point(1,3,5)
        self.assertEqual(p1, p2)

    def test_epsilon_equal2(self):
        p1 = data.Point(7,6,3.1)
        p2 = data.Point(7,6,3.1)
        self.assertEqual(p1, p2)

    def test_epsilon_equal3(self):
        p1 = data.Vector(7,6,3.1)
        p2 = data.Vector(7,6,3.1)
        self.assertEqual(p1, p2)

    def test_epsilon_equal4(self):
        p1 = data.Vector(0,0,0)
        p2 = data.Vector(0,0,0)
        self.assertEqual(p1, p2)

    def test_scale_vector1(self):
        vector1 = data.Vector(1,2,3)
        vector2 = data.Vector(2,4,6)
        self.assertEqual(scale_vector(vector1, 2), vector2)

    def test_scale_vector2(self):
        vector1 = data.Vector(2,3,4)
        vector2 = data.Vector(8,12,16)
        self.assertEqual(scale_vector(vector1, 4), vector2)

    def test_dot_vector1(self):
        vector1 = data.Vector(1,2,3)
        vector2 = data.Vector(2,3,4)
        self.assertEqual(dot_vector(vector1, vector2), 20)

    def test_dot_vector2(self):
        vector1 = data.Vector(0,0,0)
        vector2 = data.Vector(0,0,0)
        self.assertEqual(dot_vector(vector1, vector2), 0)

    def test_length_vector1(self):
        vector = data.Vector(2, 3, 4)
        self.assertEqual(length_vector(vector), 5.3851648071345037)

    def test_length_vector2(self):
        vector = data.Vector(0, 0, 0)
        self.assertEqual(length_vector(vector), 0)

    def test_normalize_vector1(self):
        vector1 = data.Vector(1, 2, 3)
        vector2 = data.Vector(1/math.sqrt(14),2/math.sqrt(14),3/math.sqrt(14))
        self.assertEqual(normalize_vector(vector1), vector2)

    def test_normalize_vector2(self):
        vector1 = data.Vector(99, 2.124, 7)
        vector2 = data.Vector(99/math.sqrt(9854.51138),2.124/math.sqrt(9854.51138),7/math.sqrt(9854.51138))
        self.assertEqual(normalize_vector(vector1), vector2)

    def test_difference_point1(self):
        point1 = data.Point(2, 4, 6)
        point2 = data.Point(1, 2, 3)
        vector = data.Vector(1, 2, 3)
        self.assertEqual(difference_point(point1, point2), vector)

    def test_difference_point2(self):
        point1 = data.Point(0, 0, 0)
        point2 = data.Point(0, 0, 0)
        vector = data.Vector(0, 0, 0)
        self.assertEqual(difference_point(point1, point2), vector)

    def test_difference_vector1(self):
        vector1 = data.Vector(2, 4, 6)
        vector2 = data.Vector(1, 2, 3)
        vector3 = data.Vector(1, 2, 3)
        self.assertEqual(difference_point(vector1, vector2), vector3)

    def test_difference_vector2(self):
        vector1 = data.Vector(0, 0, 0)
        vector2 = data.Vector(0, 0, 0)
        vector3 = data.Vector(0, 0, 0)
        self.assertEqual(difference_point(vector1, vector2), vector3)

    def test_translate_point1(self):
        point1 = data.Point(9, 0, 1)
        vector = data.Vector(1, 2, 3)
        point2 = data.Point(10, 2, 4)
        self.assertEqual(translate_point(point1, vector), point2)

    def test_translate_point2(self):
        point1 = data.Point(0, 0, 0)
        vector = data.Vector(0, 0, 0)
        point2 = data.Point(0, 0, 0)
        self.assertEqual(translate_point(point1, vector), point2)

    def test_vector_from_to1(self):
        point1 = data.Point(3, 4, 5)
        point2 = data.Point(2, 3, 4)
        vector = data.Vector(1, 1, 1)
        self.assertEqual(difference_point(point1, point2), vector)

    def test_vector_from_to2(self):
        point1 = data.Point(0, 0, 0)
        point2 = data.Point(0, 0, 0)
        vector = data.Vector(0, 0, 0)
        self.assertEqual(difference_point(point1, point2), vector)

if __name__ == '__main__':
   unittest.main()



