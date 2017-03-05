from vector_math import *
import data
import utility
import math
import unittest
import collisions

def sphere_intersection_point(ray, sphere):
    A = dot_vector(ray.dir, ray.dir)
    B = dot_vector(scale_vector(difference_point(ray.pt, sphere.center), 2), ray.dir)
    C = (dot_vector(difference_point(ray.pt, sphere.center), difference_point(ray.pt, sphere.center)) - sphere.radius**2)   

    if ((B**2) - (4*A*C)) < 0:
        return None

    t_plus  = (-B + math.sqrt(B**2 - 4*A*C))/(2*A)
    t_minus = (-B - math.sqrt(B**2 - 4*A*C))/(2*A)

    if (t_plus < 0 and t_minus < 0):
        return None

    if (t_plus >= 0 and t_minus >= 0):
        if (t_plus > t_minus):
            t = t_minus
        else:
            t = t_plus

    else:
        if (t_plus > 0):
            t = t_plus
        else:
            t = t_minus

    return translate_point(ray.pt, scale_vector(ray.dir, t))

def find_intersection_points(sphere_list, ray):
    list = []
    for sphere in sphere_list:
        point = sphere_intersection_point(ray, sphere)
        if point:
            list.append((sphere, point))
    return list
            

def sphere_normal_at_point(sphere, point):
    return normalize_vector(vector_from_to(sphere.center, point))

