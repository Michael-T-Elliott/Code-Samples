from sys import *
import math

def main():
    print 'This program may take several minutes. Please wait.'
    image_output()

def command_line_argument():
    try:
        input_file = open(argv[1], 'r')
        return input_file
    except: 
        print "usage: file.py file.ppm row column radius"
        exit()

def groups_of_3(input_list):
    new_list = []
    i = 0
    while i < len(input_list):
        pixel = []
        for index in range(0,3):
            if i < len(input_list):
                pixel.append(input_list[i])
                i += 1
            else:
                break
        new_list.append(pixel)
    print new_list[-3:]
    return new_list    	

def c_mult(number, fade):
    num = int(int(number) * fade)
    if (num) > 255:
        return (255)
    else:
        return (num)

def image_reading(input_file, output_file, width, row, col, radius):
    print 'Converting file to array...'
    file = input_file.read()
    file_array = file.split()

    print 'Grouping pixels...'
    pixels = groups_of_3(file_array)
    loc = [0, 0]
    givenp = [row, col]
    print 'Converting pixel color...'
    for p in pixels:
        distance = dist_from_pixel(loc, givenp)
        fade_value = fade(radius, distance)
        loc = location(loc[0], loc[1], width)
        red = str(c_mult(p[0], fade_value))
        green = str(c_mult(p[1], fade_value))
        blue = str(c_mult(p[2], fade_value))
        output_file.write(red + " " + green + " " + blue + "\n")
    return pixels

def location(row, col, width):
    col += 1
    if col >= int(width):
        col = 0
        row += 1
    return [row, col]

def fade(radius, distance):
    fade_value = ((radius - distance)/radius)
    if fade_value > 0.20:
        return fade_value
    else:
        return 0.20

def dist_from_pixel(p1, p2):
    distance = math.sqrt((p1[0] - p2[0])**2 + (p1[1] - p2[1])**2)
    return distance

def image_output():
    input_file = command_line_argument()
    row = int(argv[2])
    col = int(argv[3])
    radius = int(argv[4])

    P3 = input_file.readline()
    width_height = input_file.readline()
    color_range = input_file.readline()
    width = width_height.split()[0]

    output_file = open('faded.ppm', 'w')

    output_file.write(P3) 
    output_file.write(width_height)
    output_file.write(color_range)

    print 'Converting Image...'
    image_reading(input_file, output_file, width, row, col, radius)


if __name__ == '__main__':
    main()

    