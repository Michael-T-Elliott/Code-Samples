import unittest
import line

class LineTests(unittest.TestCase):
   def test_my_line(self):
      # Add code here.
      my_line = line.Line(1.1, 1.2, 1.3, 1.4)
      self.assertAlmostEqual(my_line.x1, 1.1)
      self.assertAlmostEqual(my_line.y1, 1.2)
      self.assertAlmostEqual(my_line.x2, 1.3)
      self.assertAlmostEqual(my_line.y2, 1.4)

   def test_line_again(self):
      line_again = line.Line(1.6, 1.7, 1.8, 1.9)
      self.assertAlmostEqual(line_again.x1, 1.6)
      self.assertAlmostEqual(line_again.y1, 1.7)
      self.assertAlmostEqual(line_again.x2, 1.8)
      self.assertAlmostEqual(line_again.y2, 1.9)



      # 1) Create a Line with x1, y1, x2, y2 values of your choice.
      # 2) Use assertEqual on each field in the new Line to verify
      #    that it holds the expected value.


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()

