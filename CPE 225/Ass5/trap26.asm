;Michael Elliott
;CPE 225-03
;Assignment 5
;2/17/17

.ORIG x3300
	
	;Save PC from UP1 into HCML
	STI	R7	HCML

	;Turn on the interrupt enable bit in the KBSR
	LD	R1	KBSR
	LD	R2	KBSRRB
	STR	R2	R1	#0

	;JSR to UP2
	LD	R2	UP2
	JSRR	R2

HCML	.FILL	x32FF
UP2	.FILL	x3400
KBSR	.FILL	xFE00
KBSRRB	.FILL	x4000

.END
