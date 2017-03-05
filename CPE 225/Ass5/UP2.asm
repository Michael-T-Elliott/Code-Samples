;Michael Elliott
;
CPE 225-03

;Assignment 5

;2/17/17



.ORIG x3400

	
LD R0 AST
RESET 	
LD R1 #0


LOOP  	ADD R1 R1 #1
	
BRzp LOOP
      
	
OUT
      
	
BRnzp RESET


AST   	.FILL  #42


.END
