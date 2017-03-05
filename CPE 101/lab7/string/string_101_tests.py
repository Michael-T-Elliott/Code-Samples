import unittest
from string_101 import *

class TestString(unittest.TestCase):
   def test_string101(self):
      string = 'asdf'
      self.assertEqual(str_rot_13('abcd'), 'nopq')
      self.assertEqual(str_rot_13('ABCD'), 'NOPQ')
      self.assertEqual(str_rot_13('NOPQ'), 'ABCD')
      self.assertEqual(str_rot_13('nopq'), 'abcd')

   def test_translate_101(self):
      self.assertEqual(str_translate_101('axbx', 'x', 'y'), 'ayby')
      self.assertEqual(str_translate_101('zxxxyz', 'x', 'y'), 'zyyyyz')
     


if __name__ == '__main__':
   unittest.main()

