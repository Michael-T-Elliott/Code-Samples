# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import unittest
import lab_quiz

class TestLabQuiz(unittest.TestCase):
    def test_area(self):
        p1 = lab_quiz.Point(1,1)
        c1 = lab_quiz.Circle(p1,3)
        self.assertEqual(lab_quiz.area(c1), 28.27431)

    def test_min_area_1(self):
        p1 = lab_quiz.Point(1,1)
        c1 = lab_quiz.Circle(p1,3)
        p2 = lab_quiz.Point(2,2)
        c2 = lab_quiz.Circle(p2,4)
        self.assertEqual(lab_quiz.min_area(c1, c2),c1.center)

    def test_min_area_2(self):
        p1 = lab_quiz.Point(2,3)
        c1 = lab_quiz.Circle(p1,8)
        p2 = lab_quiz.Point(4,7)
        c2 = lab_quiz.Circle(p2,2)
        self.assertEqual(lab_quiz.min_area(c1, c2),c2.center)


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

