import unittest
from fold import *
from point import *

class TestCases(unittest.TestCase):
   def test_sum1(self): 
      input_list = [1, 2, 3, 4]
      self.assertEqual(sum(input_list), 10)

   def test_sum2(self): 
      input_list = [0, 0, 1]
      self.assertEqual(sum(input_list), 1)

   def test_index_of_smallest1(self): 
      input_list = [4, 2, 1, 5]
      self.assertEqual(index_of_smallest(input_list), 2)   

   def test_index_of_smallest2(self): 
      input_list = []
      self.assertEqual(index_of_smallest(input_list), -1)   
  
   def test_nearest_origin1(self):
      point_list = [Point(2,2), Point(1,1)]
      self.assertEqual(nearest_origin(point_list), 1) 

   def test_nearest_origin2(self):
      point_list = []
      self.assertEqual(nearest_origin(point_list), -1)


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

