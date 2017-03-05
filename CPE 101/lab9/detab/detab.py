from sys import *

OUTFILE_NAME = "detabbed"
TAB_STOP_SIZE = 8
NUM_ARGS = 2
FILE_ARG_IDX = 1

def main(argv):
   character_count = 0;
   check_arg_number(argv)
   infile = open_in_file(argv)
   c = infile.read(1)
   outfile = open_out_file(argv)
   while_c(c, character_count, infile, outfile)

   infile.close()
   outfile.close()



def check_arg_number(argv):
   if (len(argv) < NUM_ARGS):
      print >> stderr, "file name missing"
      exit(1)

def open_in_file(argv):
   try:
      infile = open(argv[FILE_ARG_IDX], "r")
      return infile
   except IOError as e:
      print >> stderr, e
      exit(1)

def open_out_file(argv):
   try:
      outfile = open(OUTFILE_NAME, "w")
      return outfile
   except IOError as e:
      print >> stderr, e
      exit(1)

def while_c(c, character_count, infile, outfile):
      while (c):
         if (c == '\t'):
            num_spaces =  TAB_STOP_SIZE - (character_count % TAB_STOP_SIZE)
            for i in range(num_spaces):
               outfile.write(' ')
            character_count = character_count + num_spaces
         elif (c == '\n'):
            outfile.write('\n')
            character_count = 0
         else:
            outfile.write(c)
            character_count = character_count + 1
         c = infile.read(1)   


if __name__ == "__main__":
   main(argv)
