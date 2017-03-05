from collisions import *
from data import *



def cast_ray(ray, sphere_list):
    if find_intersection_points(sphere_list, ray) != []:
        return True
    else:
        return False

def cast_all_rays(min_x, max_x, min_y, max_y, width, height, eye_point, sphere_list):
    dx = (max_x - min_x)/float(width)  #pixel width
    dy = (max_y - min_y)/float(height) #pixel height

    for y in range(height):
        for x in range(width):
            pixel_point = Point(dx * x + min_x, max_y - y * dy, 0) #may need tinkering
            ray_direction = normalize_vector(vector_from_to(eye_point, pixel_point))
            my_ray = Ray(eye_point, ray_direction)
            intersection = cast_ray(my_ray, sphere_list)
            if intersection:
                print "0 0 0"
            else:
                print "255 255 255"
            
            
            
            
            


