import unittest
from char import *

class TestChar(unittest.TestCase):
   def test_lower(self):
      self.assertEqual(is_lower_101('a'), True)
      self.assertEqual(is_lower_101('A'), False)
      self.assertEqual(is_lower_101('n'), True)
      self.assertEqual(is_lower_101('N'), False)

   def test_rot_13(self):
      self.assertEqual(char_rot_13('a'), 'n')
      self.assertEqual(char_rot_13('A'), 'N')
      self.assertEqual(char_rot_13('n'), 'a')
      self.assertEqual(char_rot_13('N'), 'A')

if __name__ == '__main__':
   unittest.main()

