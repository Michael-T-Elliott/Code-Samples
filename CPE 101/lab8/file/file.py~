from sys import *

def float_default(string, default):
    try:
        return float(string)
    except:
        return default

if len(argv) < 2:
    print "Error. Not enough arguments."
    exit()

file_name = argv[1]
try:
    file_object = open(file_name, "r")
except:
    print "Error. Failed to Open File."
    exit()

while True:
    cmd_line = file_object.readline()
    if len(cmd_line) == 0:
        break

    floats = cmd_line.split()
    if len(floats) != 2:
        print "Error. Line does not consist of two string values."

    if len(floats) == 2:
        float1 = float_default(floats[0], None)
        float2 = float_default(floats[1], None)

        if float1 == None or float2 == None:
            print "Error. One or more strings cannot be converted."
        else:
            print float1 + float2
 
