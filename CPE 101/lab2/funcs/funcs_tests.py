# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import unittest
import funcs

class TestCases(unittest.TestCase):
   def test_f_1(self):
      self.assertAlmostEqual(funcs.f(2), 32)
      self.assertAlmostEqual(funcs.f(5), 185)

   def test_f_2(self):
      self.assertEqual(funcs.g(5,6), 61)
      self.assertEqual(funcs.g(2,3), 13)

   def test_f_3(self):
      self.assertAlmostEqual(funcs.hypotenuse(5,6), 7.810249675906654)
      self.assertAlmostEqual(funcs.hypotenuse(3,7), 7.615773105863909)

   def test_f_4(self):
      self.assertTrue(funcs.is_positive(21))
      self.assertTrue(funcs.is_positive(0))
      self.assertFalse(funcs.is_positive(-5))


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

