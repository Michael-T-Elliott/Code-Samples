# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import unittest
import logic

class TestCases(unittest.TestCase):
   def test_is_even(self):
      self.assertTrue(logic.is_even(6))

   def test_is_even2(self):
      self.assertFalse(logic.is_even(5))
      
   def test_in_an_interval1(self):
      self.assertTrue(logic.in_an_interval(6))

   def test_in_an_interval2(self):
      self.assertTrue(logic.in_an_interval(50))

   def test_in_an_interval3(self):
      self.assertTrue(logic.in_an_interval(15))

   def test_in_an_interval4(self):
      self.assertTrue(logic.in_an_interval(101))

   def test_in_an_interval5(self):
      self.assertFalse(logic.in_an_interval(1))


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

