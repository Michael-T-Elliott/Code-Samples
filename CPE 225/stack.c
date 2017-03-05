/*Michael Elliott
  Assignment 6
  CPE 225-03
  2/24/17 */

#include <stdio.h>
#include "stack.h"
#define STACK_SIZE 10

int stack[STACK_SIZE];
int TOS = -1;

/* increment TOS, place value in memory at location stack + TOS */
int push(int value){

  if(TOS >= 9){
    return 1;
  }

  TOS++;
  stack[TOS] = value;

  return 0;
	
}

/* Pop value at memory loc stack + TOS and put it into 
   location that value points to, decrement TOS */
int pop(int *value){

  if(TOS <= -1){
    return 1;
  }

  *value = stack[TOS];
  TOS--;

  return 0;

}

/* Print the stack in FIFO order, if 0 print values in decimal, if 1 in hex, if 2 in char */
void printStack(int format){
  
  int i = 0;

  if(format == 0){
    while(i <= TOS){
      printf("%d ", stack[i]);
      i++;
    }
  }

  else if(format == 1){
    while(i <= TOS){
      printf("%x ", stack[i]);
      i++;
    }
  }

  else if(format == 2){
    while(i <= TOS){
      printf("%c ", stack[i]);
      i++;
    }
  }

}


