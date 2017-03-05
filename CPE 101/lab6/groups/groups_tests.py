import unittest
from groups import *

class TestGroups(unittest.TestCase):

   def assertListAlmostEqual(self, l1, l2):
      self.assertEqual(len(l1), len(l2))
      for el1, el2 in zip(l1, l2):
         self.assertAlmostEqual(el1, el2)

   def test_groups_of_3_1(self):
      input_list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
      output_list = [[1,2,3],[4,5,6],[7,8,9]]
      self.assertEqual(groups_of_3(input_list), output_list)

   def test_groups_of_3_2(self):
      input_list = [1, 2, 3, 4, 5, 6, 7, 8]
      output_list = [[1,2,3],[4,5,6],[7,8]]
      self.assertEqual(groups_of_3(input_list), output_list)


   # Add tests here

if __name__ == '__main__':
   unittest.main()
