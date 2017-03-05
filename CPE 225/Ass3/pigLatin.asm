;Michael Elliott & Addison Martin
;CPE 225 Assignment 3 "Pig Latin"
;1/30/17

.ORIG x3000

	;Clearing Registers
BEGIN	AND R0 R0 #0 ;Char
	AND R1 R1 #0 ;Enter
	AND R2 R2 #0 ;User Input
	AND R3 R3 #0 ;Temp Register
	AND R4 R4 #0 ;Vowe
	AND R5 R5 #0 ;First Char
	AND R6 R6 #0 ;Null

	;Load Values into registers (Opp. of Enter, Input Address)
	LD  R1 Enter
	LEA R2 Input

	;Load/Print Initial User Prompt
	LEA R0 Prompt
	PUTS

	;Getting/Printing User Input
LOOP	GETC
	ADD R3 R1 R0 ;Checking for 'Enter' keystroke
	BRz ENDLOOP  ;if 'Enter' is hit break out of loop
	STR R0 R2 #0
        ADD R2 R2 #1
	STR R6 R2 #1 ;Ultimately adds null char after user inputted word
	OUT
	BRnzp LOOP

	;Print "Pig-Latin Word:"
ENDLOOP	LEA R0 Phrase
	PUTS

	;Checks for Each Vowel, branches over normal pig-latin print if vowel is found (A, E, I, O, U)
	LEA R5 Input

	LDR R3 R5 #0
	LD  R4 A
	ADD R3 R4 R3
	BRz VPRINT

	LDR R3 R5 #0
	LD  R4 E
	ADD R3 R4 R3
	BRz VPRINT

	LDR R3 R5 #0
	LD  R4 I
	ADD R3 R4 R3
	BRz VPRINT

	LDR R3 R5 #0
	LD  R4 O
	ADD R3 R4 R3
	BRz VPRINT

	LDR R3 R5 #0
	LD  R4 U
	ADD R3 R4 R3
	BRz VPRINT

	;Normal Pig-Latin Output (Non-Vowel Starts)
	LEA R0 Input
	ADD R0 R0 #1
	PUTS 	;Prints starting at second char of word

	LD R0 Input
	OUT 	;Prints first character

	LEA R0 Append
	PUTS 	;Appends "ay" to word

	BRnzp BEGIN ;Loops to beginning of program
	
	;Vowel-First Pig-Latin Output
VPRINT	LEA R0 Input
	PUTS

	LEA R0 Way
	PUTS 	;Prints "way" after word

	BRnzp BEGIN ;Loops to beginning of program

Prompt	.STRINGZ "\nEnglish Word: "
Phrase	.STRINGZ "\nPig-Latin Word: "
Append  .STRINGZ "ay"
Enter	.FILL 		#-10
Input	.BLKW 		#19
A	.FILL		#-97

E 	.FILL		#-101

I 	.FILL		#-105

O 	.FILL 		#-111

U	.FILL 		#-117

Way 	.STRINGZ 	"way"


.END