

#include <stdio.h>
void countBackwardFrom(int x);
void countForwardTo(int x);

void main(){

	int x;

	printf("Input initial integer: ");

	scanf(" %d", &x);

	countBackwardFrom(x);

	printf("\n");	
	
	countForwardTo(x);
}

void countBackwardFrom(int x){
	printf("%d", x);
	if (x == 1){
		printf("\n");
		return;
	}
	x--;
	printf(", ");
	countBackwardFrom(x);
} 

void countForwardTo(int x){
	
	if(x > 1){
		x--;
		countForwardTo(x);
		printf("%d, ", x+1);
	}
	else{
		printf("%d, ", x);
	}

	return;
}
