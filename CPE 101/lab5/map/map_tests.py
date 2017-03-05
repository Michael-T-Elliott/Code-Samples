import unittest
import map
import point
import math

class TestCases(unittest.TestCase):
    def test_square_all1(self):
        numb_list = [2, 3, 4, 5]
        new_list = [4, 9, 16, 25]
        self.assertEqual(map.square_all(numb_list), new_list)

    def test_square_all2(self):
        numb_list = [.5, 6, 2, 11, 10]
        new_list = [0.25, 36, 4, 121, 100]
        self.assertEqual(map.square_all(numb_list), new_list)

    def test_add_n_all1(self):
        numb_list = [1, 2, 3]
        n = 1
        new_list = [2, 3, 4]
        self.assertEqual(map.add_n_all(numb_list, n), new_list)

    def test_add_n_all2(self):
        numb_list = [11, 22, 33, 44]
        n = 3
        new_list = [14, 25, 36, 47]
        self.assertEqual(map.add_n_all(numb_list, n), new_list)

    def test_distance_all1(self):
        pt_list = [point.Point(1, 1), point.Point(2, 2)]
        new_list = [math.sqrt(2), math.sqrt(8)]
        self.assertEqual(map.distance_all(pt_list), new_list)

    def test_distance_all2(self):
        pt_list = [point.Point(1, 0), point.Point(2, 0), point.Point(3,3)]
        new_list = [1, 2, math.sqrt(18)]
        self.assertEqual(map.distance_all(pt_list), new_list)


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

