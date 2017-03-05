import unittest
import filter
import point

class TestCases(unittest.TestCase):
    def test_are_positive1(self):
        numb_list = [1, 2, -3, 0]
        new_list = [1, 2]
        self.assertEqual(filter.are_positive(numb_list), new_list)

    def test_are_positive2(self):
        numb_list = [1, -2, -3, 99]
        new_list = [1, 99]
        self.assertEqual(filter.are_positive(numb_list), new_list)

    def test_are_greater_than1(self):
        numb_list = [1, 2, 3, 99]
        n = 2
        new_list = [3, 99]
        self.assertEqual(filter.are_greater_than(numb_list, n), new_list)

    def test_are_greater_than2(self):
        numb_list = [1, 2, 3, 99]
        n = 88
        new_list = [99]
        self.assertEqual(filter.are_greater_than(numb_list, n), new_list)

    def test_are_in_first_quadrant1(self):
        pt_list = [point.Point(1,-2), point.Point(3,3)]
        new_list = [point.Point(3,3)]
        self.assertEqual(filter.are_in_first_quadrant(pt_list), new_list)

    def test_are_in_first_quadrant2(self):
        pt_list = [point.Point(1,2), point.Point(3,3)]
        new_list = [point.Point(1,2), point.Point(3,3)]
        self.assertEqual(filter.are_in_first_quadrant(pt_list), new_list)


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

