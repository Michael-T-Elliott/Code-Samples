;Michael Elliott
;CPE 225-03
;Assignment 5
;2/17/17

.ORIG x3500

; Get character from KBDR
	LDI	R0 	KBDR

;Clear KBSR
	LD	R1	NULL
	STI	R1	KBSR

;Overwrite PC of UP2 with PC of UP1
	LDI	R1	HCML
	STR	R1	R6	#0

;USE RTI
RTI	


KBDR	.Fill xFE02
KBSR	.FILL xFE00
HCML	.FILL x32FF
NULL	.FILL #0

.END
