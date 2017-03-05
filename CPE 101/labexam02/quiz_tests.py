# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import unittest
from data import *
from functions import *

class TestLabQuiz(unittest.TestCase):
    def test_check_circle1(self):
        circle = Circle(Point(0,0), 1)
        point = Point(0, 0)
        self.assertEqual(check_circle(circle, point), -1)

    def test_check_circle2(self):
        circle = Circle(Point(0,0), 1)
        point = Point(5, 5)
        self.assertEqual(check_circle(circle, point), 1)

    def test_check_circle3(self):
        circle = Circle(Point(0,0), 1)
        point = Point(0, 1)
        self.assertAlmostEqual(check_circle(circle, point), 0)

    def test_in_or_out1(self):
        circle_list = [Circle(Point(0,0), 1)]
        point = Point(0, 3)
        output_list = []
        self.assertEqual(in_or_out(circle_list, point), output_list)

    def test_in_or_out2(self):
        circle_list = [Circle(Point(0,0), 1)]
        point = Point(0, 1)
        output_list = [Circle(Point(0,0), 1)]
        self.assertEqual(in_or_out(circle_list, point), output_list)

    def test_list_multiply1(self):
        num_list1 = [1,2,3]
        num_list2 = [1,2,3]
        new_list = [1, 4, 9]
        self.assertEqual(list_multiply(num_list1, num_list2), new_list)

    def test_list_multiply2(self):
        num_list1 = [2,2,2]
        num_list2 = [2,2,2]
        new_list = [4, 4, 4]
        self.assertEqual(list_multiply(num_list1, num_list2), new_list)


# Run the unit tests.
if __name__ == '__main__':
    unittest.main()
