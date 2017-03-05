# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

import unittest
import data

class TestData(unittest.TestCase):
    def test_point1(self):
        pt1 = data.Point(0.5, 6, 9)
        self.assertAlmostEqual(pt1.x, 0.5)
        self.assertAlmostEqual(pt1.y, 6)
        self.assertAlmostEqual(pt1.z, 9)
       
    def test_point2(self):
        pt2 = data.Point(0,0,0)
        self.assertAlmostEqual(pt2.x, 0)
        self.assertAlmostEqual(pt2.y, 0)
        self.assertAlmostEqual(pt2.z, 0)
        
    def test_vector1(self):
        vt1 = data.Vector(12, 3.14, 13)
        self.assertAlmostEqual(vt1.x, 12)
        self.assertAlmostEqual(vt1.y, 3.14)
        self.assertAlmostEqual(vt1.z, 13)
        
    def test_vector2(self):
        vt2 = data.Vector(0,0,0)
        self.assertAlmostEqual(vt2.x, 0)
        self.assertAlmostEqual(vt2.y, 0)
        self.assertAlmostEqual(vt2.z, 0)
        
    def test_ray1(self):
        rt1 = data.Ray(data.Point(-9, 7, 3.55), data.Vector(8, -6, 888))
        self.assertAlmostEqual(rt1.pt.x, -9)
        self.assertAlmostEqual(rt1.pt.y, 7)
        self.assertAlmostEqual(rt1.pt.z, 3.55)

        self.assertAlmostEqual(rt1.dir.x, 8)
        self.assertAlmostEqual(rt1.dir.y, -6)
        self.assertAlmostEqual(rt1.dir.z, 888)

    def test_ray2(self):
        rt2 = data.Ray(data.Point(0,0,0), data.Vector(0, 0, 0))
        self.assertAlmostEqual(rt2.pt.x, 0)
        self.assertAlmostEqual(rt2.pt.y, 0)
        self.assertAlmostEqual(rt2.pt.z, 0)

        self.assertAlmostEqual(rt2.dir.x, 0)
        self.assertAlmostEqual(rt2.dir.y, 0)
        self.assertAlmostEqual(rt2.dir.z, 0)
        
    def test_sphere1(self):
        st1 = data.Sphere(data.Point(13, 7, 9.9), 220)
        self.assertAlmostEqual(st1.center.x, 13)
        self.assertAlmostEqual(st1.center.y, 7)
        self.assertAlmostEqual(st1.center.z, 9.9)
        self.assertAlmostEqual(st1.radius, 220)
        
    def test_sphere2(self):
        st2 = data.Sphere(data.Point(0, 0, 0), 0)
        self.assertAlmostEqual(st2.center.x, 0)
        self.assertAlmostEqual(st2.center.y, 0)
        self.assertAlmostEqual(st2.center.z, 0)
        self.assertAlmostEqual(st2.radius, 0)


if __name__ == '__main__':
   unittest.main()


