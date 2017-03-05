# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

from cast import *
from collisions import *
from data import *

class TestCases(unittest.TestCase):
    def test_convert_to_int1(self):
        number = 0.5
        num = 127
        self.assertEqual(convert_to_int(number), num)

    def test_convert_to_int2(self):
        number = 11
        num = 255
        self.assertEqual(convert_to_int(number), num)

    def test_cast_ray1(self):
        ray = Ray(Point(0.0, 0.0, -14.0), Vector(0, 0, 1))
        sphere_list = [Sphere(Point(1.0, 1.0, 0.0), 2.0, Color(0,0,1)), 
                       Sphere(Point(0.5, 1.5, -3.0), 0.5, Color(1,0,0))]
        color = Color(0,0,1)
        self.assertEqual(cast_ray(ray, sphere_list), color)

    def test_cast_ray2(self):
        ray = Ray(Point(0.0, 0.0, -14.0), Vector(0, 0, -1))
        sphere_list = [Sphere(Point(1.0, 1.0, 0.0), 2.0, Color(0,0,1)), 
                       Sphere(Point(0.5, 1.5, -3.0), 0.5, Color(1,0,0))]
        color = Color(1, 1, 1)
        self.assertEqual(cast_ray(ray, sphere_list), color)



# Run the unit tests.
if __name__ == '__main__':
   unittest.main()
