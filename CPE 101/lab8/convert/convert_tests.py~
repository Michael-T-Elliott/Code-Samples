import unittest
from convert import *

class TestConvert(unittest.TestCase):
   def test_convert1(self):
      string = "8"
      default = None
      self.assertEqual(float_default(string, default), 8)

   def test_convert2(self):
      string = "banana"
      default = None
      self.assertEqual(float_default(string, default), None)

   def test_convert3(self):
      string = "86"
      default = None
      self.assertEqual(float_default(string, default), 86)

   def test_convert1(self):
      string = "0"
      default = None
      self.assertEqual(float_default(string, default), 0)


if __name__ == '__main__':
   unittest.main()

