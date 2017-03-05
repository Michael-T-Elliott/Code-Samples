;Addison Martin & Michael Elliott
;CPE 225-03
;Assignment 4
;2/10/17

.ORIG x3000

BEGIN	AND	R3	R3	#0
	LD	R4	One

	;Display Question 1
	LD	R0	Q1
	PUTS

	;Get Reponse to Question 1
	GETC
	OUT

	;Compute Question 1
	ADD	R0	R0	R4
	LD	R1	Q1Ans
	JSR	COMP



	;Display Question 2
	LD	R0	Q2
	PUTS

	;Get Reponse to Question 2
	GETC
	OUT

	;Compute Question 2
	ADD	R0	R0	R4
	LD	R1	Q2Ans
	JSR	COMP



	;Display Question 3
	LD	R0	Q3
	PUTS

	;Get Reponse to Question 3
	GETC
	OUT

	;Compute Question 3
	ADD	R0	R0	R4
	LD	R1	Q3Ans
	JSR	COMP



	;Display Question 4
	LD	R0	Q4
	PUTS

	;Get Reponse to Question 4
	GETC
	OUT

	;Compute Question 4
	ADD	R0	R0	R4
	LD	R1	Q4Ans
	JSR	COMP



	;Display Question 5
	LD	R0	Q5
	PUTS

	;Get Reponse to Question 5
	GETC
	OUT

	;Compute Question 5
	ADD	R0	R0	R4
	LD	R1	Q5Ans
	JSR	COMP


	;Display Question 6
	LD	R0	Q6
	PUTS

	;Get Reponse to Question 6
	GETC
	OUT

	;Compute Question 6
	ADD	R0	R0	R4
	LD	R1	Q6Ans
	JSR	COMP


	LD	R4	Res1Val
	ADD	R4	R3	R4
	BRnz Grade1

	LD	R4	Res2Val
	ADD	R4	R3	R4
	BRnz Grade2

	LD	R4	Res3Val
	ADD	R4	R3	R4
	BRnz Grade3

	LD	R4	Res4Val
	ADD	R4	R3	R4
	BRnz Grade4

Grade1	LD	R0	Result1

	PUTS
	BRnzp BEGIN

Grade2	LD	R0	Result2

	PUTS
	BRnzp BEGIN	

Grade3	LD	R0	Result3

	PUTS
	BRnzp BEGIN	

Grade4	LD	R0	Result4

	PUTS
	BRnzp BEGIN	
	

	HALT

COMP	ST	R2	SR2		;Save R2
	ADD	R2	R1	R0	;Add response offset to memor loc in R1 (Q1 Ans)
	LDR	R0	R2	#0	;Load Memory at R2 into R0 (Points)
	LD	R2	SR2		;Recovering R2
	ADD	R3	R0	R3	;Add Point Value to R3 (Running Total)
	RET

	

One	.FILL	#-49

SR2	.FILL	x0000

Q1	.FILL	x3300
Q1Ans	.FILL	x336D
Q2	.FILL	x3371
Q2Ans	.FILL	x33EC
Q3	.FILL	x33F0
Q3Ans	.FILL	x3461
Q4	.FILL	x3465
Q4Ans	.FILL	x34BA
Q5	.FILL	x34BE
Q5Ans	.FILL	x3526
Q6	.FILL	x352A
Q6Ans	.FILL	x3597
Res1Val	.FILL	#-10
Res2Val	.FILL	#-16
Res3Val	.FILL	#-20
Res4Val .FILL	#-24
Result1	.FILL	x359B
Result2	.FILL	x35C1
Result3	.FILL	x35F3
Result4	.FILL	x3616

.END