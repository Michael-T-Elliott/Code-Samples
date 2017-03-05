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

def groups_of_3(input_list, width):
    new_list = []
    i = 0
    while i < len(input_list):
        pixel = []
        for index in range(0,int(width)):
            if i < len(input_list):
                pixel.append(input_list[i])
                i += 1
            else:
                break
        new_list.append(pixel)
    return new_list        

def c_mult(number, fade):
    num = int(int(number) * fade)
    if (num) > 255:
        return (255)
    else:
        return (num)

def image_reading(input_file, output_file, width, height, neighbor_reach):
    print 'Converting file to array...'
    file = input_file.read()
    file_array = file.split()

    print 'Grouping pixels...'
    pixels = groups_of_3(file_array, 3)
    rows = groups_of_3(pixels, width)

    loc = [0, 0]
    print 'Converting pixel color...'
    for p in pixels:
        r = p[0]
        g = p[1]
        b = p[2]
        
        loc = location(loc[0], loc[1], width)
        blurred = blur(neighbor_reach, loc, width, height, rows)
        red = str(blurred[0])
        green = str(blurred[1])
        blue = str(blurred[2])
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

def blur(neighbor_reach, loc, width, height, rows):
    row = loc[0]
    col = loc[1]
    redsum = 0
    greensum = 0
    bluesum = 0
    count = 0    
    for dy in range(-neighbor_reach, neighbor_reach + 1):
        for dx in range(-neighbor_reach, neighbor_reach + 1):
            if row + dy >= 0 and row + dy < int(height) and col + dx >= 0 and col + dx < int(width):
                pixel = rows[row+dy][col+dx]
                redsum += int(pixel[0])
                greensum += int(pixel[1])
                bluesum += int(pixel[2])
                count += 1
    redsum = (redsum/count)
    greensum = (greensum/count)
    bluesum = (bluesum/count)
    return [redsum, greensum, bluesum]

def dist_from_pixel(p1, p2):
    distance = math.sqrt((p1[0] - p2[0])**2 + (p1[1] - p2[1])**2)
    return distance

def image_output():
    input_file = command_line_argument()
    neighbor_reach = int(argv[2])

    P3 = input_file.readline()
    width_height = input_file.readline()
    color_range = input_file.readline()
    width = width_height.split()[0]
    height = width_height.split()[1]

    output_file = open('blurred.ppm', 'w')

    output_file.write(P3) 
    output_file.write(width_height)
    output_file.write(color_range)

    print 'Converting Image...'
    image_reading(input_file, output_file, width, height, neighbor_reach)


if __name__ == '__main__':
    main()

    