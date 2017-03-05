# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import unittest
import conditional

class TestCases(unittest.TestCase):
   def test_max_101_1(self):
      self.assertAlmostEqual(conditional.max_101(5,6), 6)

   def test_max_101_2(self):
      self.assertAlmostEqual(conditional.max_101(9,9), 9)

   def test_max_of_three1(self):
      self.assertAlmostEqual(conditional.max_of_three(5,6,7), 7)

   def test_max_of_three2(self):
      self.assertAlmostEqual(conditional.max_of_three(9,9,9), 9)

   def test_rental_late_fee1(self):
      self.assertAlmostEqual(conditional.rental_late_fee(0), 0)

   def test_rental_late_fee2(self):
      self.assertAlmostEqual(conditional.rental_late_fee(8), 5)

   def test_rental_late_fee3(self):
      self.assertAlmostEqual(conditional.rental_late_fee(15), 7)

   def test_rental_late_fee4(self):
      self.assertAlmostEqual(conditional.rental_late_fee(23), 19)

   def test_rental_late_fee5(self):
      self.assertAlmostEqual(conditional.rental_late_fee(25), 100)




# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

