/*Michael Elliott
  Assignment 6
  CPE 225-03
  2/24/17 */

#include <stdio.h>
#include "stack.h"

/*Function: Main
  Description: Driver for stack: 'u' to push num onto stack, 'o' to pop, 
  'h' to convert to hex, 'd' to decimal, 'c' for char, 'x' to quit */

int main(int argc, char *argv[]){

  /* variable declerations */
  char format;
  int number;
  int stackFormat = 0;

  /* code to run here */
  printf("Welcome to the stack program.\n");

  printf("\nEnter option: ");

  while(format != 'x'){
    
    	scanf(" %c", &format);

	/* 'u' to push num onto stack */
	if (format == 'u'){
		printf("What number? ");
		scanf("%d", &number);

		if((push(number)) == 1){
			printf("Overflow!!!\n");
			printf("Stack: ");
			printStack(stackFormat);
		}

		else{
			printf("Stack: ");
			printStack(stackFormat);
		}
		printf("\n\nEnter option: ");
	}

	/* 'o' to pop */
	else if (format == 'o'){
		
		int value = 0;


		if((pop(&value)) == 1){
			printf("Underflow!!!\n");
		}
		else
		{
			printf("Popped %d\n", value);
		}
		
		printf("Stack: ");
		printStack(stackFormat);
		printf("\n\nEnter option: ");
	}

	/* 'h' to convert to hex */
	else if (format == 'h'){
		stackFormat = 1;
		printf("Stack: ");
		printStack(stackFormat);
		printf("\n\nEnter option: ");
	}

	/* 'c' for char */
	else if (format == 'c'){
		stackFormat = 2;
		printf("Stack: ");
		printStack(stackFormat);
		printf("\n\nEnter option: ");
	}

	/* 'd' to decimal */
	else if (format == 'd'){
		stackFormat = 0;
		printf("Stack: ");
		printStack(stackFormat);
		printf("\n\nEnter option: ");
	}

	/* 'x' to quit */
	else if (format == 'x'){
		printf("Goodbye!\n");
		return 0;
	}

	else{
		printf("\n\nEnter option: ");
	}
	
  }

  printf("Goodbye!\n");
  return 0;

}
