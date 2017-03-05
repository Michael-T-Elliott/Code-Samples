;Michael Elliott
;CPE 225-03
;Assignment 5
;2/17/17

.ORIG	x3000

	;Load locs of Trap26 and ISR into vector tables

	LD 	R1	T26
	LD	R2	J1
	STR	R2	R1	#0	

	LD 	R1	L180
	LD	R2	J2
	STR	R2	R1	#0

	; initialize stack pointer
	LD	R6	Stack
	

LOOP	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	LEA	R0, END_MSG
	PUTS
	BRnzp LOOP

END_MSG .STRINGZ "\nSuccess!  Running again...\n"
T26	.FILL	x0026
L180	.FILL	x0180
J1	.FILL	x3300	
J2	.FILL	x3500
Stack	.FILL	x3000
        .END
