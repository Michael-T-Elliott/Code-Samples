# Name: Michael Elliott
# Instructor: Dr. John Campbell
# Section: 17

from vector_math import *
import data
import utility
import math
import unittest
import collisions

class TestData(unittest.TestCase):

    def test_epsilon_equal1(self):
        p1 = data.Point(1,3,5)
        p2 = data.Point(1,3,5)
        self.assertEqual(p1, p2)

    def test_epsilon_equal2(self):
        p1 = data.Point(7,6,3.1)
        p2 = data.Point(7,6,3.1)
        self.assertEqual(p1, p2)

    def test_epsilon_equal3(self):
        p1 = data.Vector(7,6,3.1)
        p2 = data.Vector(7,6,3.1)
        self.assertEqual(p1, p2)

    def test_epsilon_equal4(self):
        p1 = data.Vector(0,0,0)
        p2 = data.Vector(0,0,0)
        self.assertEqual(p1, p2)

    def test_scale_vector1(self):
        vector1 = data.Vector(1,2,3)
        vector2 = data.Vector(2,4,6)
        self.assertEqual(scale_vector(vector1, 2), vector2)

    def test_scale_vector2(self):
        vector1 = data.Vector(2,3,4)
        vector2 = data.Vector(8,12,16)
        self.assertEqual(scale_vector(vector1, 4), vector2)

    def test_dot_vector1(self):
        vector1 = data.Vector(1,2,3)
        vector2 = data.Vector(2,3,4)
        self.assertEqual(dot_vector(vector1, vector2), 20)

    def test_dot_vector2(self):
        vector1 = data.Vector(0,0,0)
        vector2 = data.Vector(0,0,0)
        self.assertEqual(dot_vector(vector1, vector2), 0)

    def test_length_vector1(self):
        vector = data.Vector(2, 3, 4)
        self.assertEqual(length_vector(vector), 5.3851648071345037)

    def test_length_vector2(self):
        vector = data.Vector(0, 0, 0)
        self.assertEqual(length_vector(vector), 0)

    def test_normalize_vector1(self):
        vector1 = data.Vector(1, 2, 3)
        vector2 = data.Vector(1/math.sqrt(14),2/math.sqrt(14),3/math.sqrt(14))
        self.assertEqual(normalize_vector(vector1), vector2)

    def test_normalize_vector2(self):
        vector1 = data.Vector(99, 2.124, 7)
        vector2 = data.Vector(99/math.sqrt(9854.51138),2.124/math.sqrt(9854.51138),7/math.sqrt(9854.51138))
        self.assertEqual(normalize_vector(vector1), vector2)

    def test_difference_point1(self):
        point1 = data.Point(2, 4, 6)
        point2 = data.Point(1, 2, 3)
        vector = data.Vector(1, 2, 3)
        self.assertEqual(difference_point(point1, point2), vector)

    def test_difference_point2(self):
        point1 = data.Point(0, 0, 0)
        point2 = data.Point(0, 0, 0)
        vector = data.Vector(0, 0, 0)
        self.assertEqual(difference_point(point1, point2), vector)

    def test_difference_vector1(self):
        vector1 = data.Vector(2, 4, 6)
        vector2 = data.Vector(1, 2, 3)
        vector3 = data.Vector(1, 2, 3)
        self.assertEqual(difference_point(vector1, vector2), vector3)

    def test_difference_vector2(self):
        vector1 = data.Vector(0, 0, 0)
        vector2 = data.Vector(0, 0, 0)
        vector3 = data.Vector(0, 0, 0)
        self.assertEqual(difference_point(vector1, vector2), vector3)

    def test_translate_point1(self):
        point1 = data.Point(9, 0, 1)
        vector = data.Vector(1, 2, 3)
        point2 = data.Point(10, 2, 4)
        self.assertEqual(translate_point(point1, vector), point2)

    def test_translate_point2(self):
        point1 = data.Point(0, 0, 0)
        vector = data.Vector(0, 0, 0)
        point2 = data.Point(0, 0, 0)
        self.assertEqual(translate_point(point1, vector), point2)

    def test_vector_from_to1(self):
        point1 = data.Point(3, 4, 5)
        point2 = data.Point(2, 3, 4)
        vector = data.Vector(1, 1, 1)
        self.assertEqual(difference_point(point1, point2), vector)

    def test_vector_from_to2(self):
        point1 = data.Point(0, 0, 0)
        point2 = data.Point(0, 0, 0)
        vector = data.Vector(0, 0, 0)
        self.assertEqual(difference_point(point1, point2), vector)

#Specific to assignment 3 below

    def test_sphere_intersection_point1(self):
        #Test When Ray Passes Through Sphere Twice
        ray1 = data.Ray(data.Point(0,0,0), data.Vector(20,0,0))
        sphere1 = data.Sphere(data.Point(10,0,0), 1)
        self.assertEqual(collisions.sphere_intersection_point(ray1, sphere1), data.Point(9,0,0))

    def test_sphere_intersection_point2(self):
        #Test When Ray Starts in Sphere
        ray2 = data.Ray(data.Point(0,5,0), data.Vector(0,10,0))
        sphere2 = data.Sphere(data.Point(0,5,0), 1)
        self.assertEqual(collisions.sphere_intersection_point(ray2, sphere2), data.Point(0,6,0))
        
    def test_sphere_intersection_point3(self):
        #Test when Ray misses Sphere
        ray3 = data.Ray(data.Point(0,0,0), data.Vector(-10,0,0))
        sphere3 = data.Sphere(data.Point(15,0,0), 1)
        self.assertEqual(collisions.sphere_intersection_point(ray3, sphere3), None)

    def test_sphere_intersection_point4(self):
        #Test when Ray glances/skims sphere
        ray4 = data.Ray(data.Point(1,1,0), data.Vector(-3,0,0))
        sphere4 = data.Sphere(data.Point(0,0,0), 1)
        self.assertEqual(collisions.sphere_intersection_point(ray4, sphere4), data.Point(0,1,0))

    def test_find_intersection_point1(self):
        #test ray 1
        ray1 = data.Ray(data.Point(0, 0, 0), data.Vector(1, 0, 0))
        spheres_list1 = [data.Sphere(data.Point(3, 0, 0), 1), data.Sphere(data.Point(6, 0, 0), 1)]
        intersection_points1 = [(spheres_list1[0], data.Point(2, 0, 0)), (spheres_list1[1], data.Point(5, 0, 0))]
        self.assertEqual(collisions.find_intersection_point(spheres_list1, ray1), intersection_points1)

    def test_find_intersection_point2(self):
        #test ray 2
        ray2 = data.Ray(data.Point(1, 5, 0), data.Vector(0, -1, 0))
        spheres_list2 = [data.Sphere(data.Point(1, 0, 0), 1), data.Sphere(data.Point(1, -5, 0), 1)]
        intersection_points2 = [(spheres_list2[0], data.Point(1, 1, 0)), (spheres_list2[1], data.Point(1, -4, 0))]
        self.assertEqual(collisions.find_intersection_point(spheres_list2, ray2), intersection_points2)

    def test_sphere_normal_at_point1(self):
        sphere1 = data.Sphere(data.Point(0, 0, 0), 1) #This one should go left
        self.assertEqual(collisions.sphere_normal_at_point(sphere1, data.Point(-1, 0, 0)), data.Vector(-1, 0, 0))

    def test_sphere_normal_at_point2(self):
        sphere2 = data.Sphere(data.Point(1, 2, 0), 1) #This should go up
        self.assertEqual(collisions.sphere_normal_at_point(sphere2, data.Point(1, 1, 0)), data.Vector(0, -1, 0))
        
    

if __name__ == '__main__':
   unittest.main()
