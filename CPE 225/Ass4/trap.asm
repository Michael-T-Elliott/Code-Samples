;Addison Martin & Michael Elliott
;CPE 225-03
;Assignment 4
;2/10/17

.ORIG x3300

	;Store Registers In Use
	ST R1 SaveR1
	ST R2 SaveR2
	ST R3 SaveR3

	;Copying R0 into R1
	ADD R1 R0 #0

	;Loop until KBSR status bit is ready!
LOOP	LDI R2 KBSR ;Load KBSR into R2
	BRzp LOOP

	;Load key entered into R2, if 'enter' loopout
	LDI R2 KBDR
	ADD R3 R2 #-10
	BRz LOOPOUT

	;Poll DSR, then Echo to monitor (after loopout so 'enter' doesn't get echoed)
ECHO	LDI R3 DSR
	BRzp ECHO
	STI R2 DDR

	;Store what it's R2 in address @ R1 (where string is stored), increment R1
	STR R2 R1 #0
	ADD R1 R1 #1
	BRnzp LOOP ;Loop till 'enter'

	;Store 'null' at end of string
LOOPOUT	AND R2 R2 #0
	STR R2 R1 #0

	;Reload registers
	LD R1 SaveR1
	LD R2 SaveR2
	LD R3 SaveR3
	
	RET

SaveR1	.Fill x0000
SaveR2	.Fill x0000
SaveR3	.Fill x0000
KBSR	.Fill xFE00
KBDR	.Fill xFE02
DSR	.Fill xFE04
DDR	.Fill xFE06

.END