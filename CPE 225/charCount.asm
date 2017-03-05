;Michael Elliott && Addison Martin
;CPE-225 Section 03
;2/29/17
;
; RECURSIVE CHAR COUNT Function
;
; Assumptions:
;   - the input string will be no longer than 19 characters
;   - the search char will occur less than 10 times
;
; R0 - I/O, temp results
; R1 - result value
; R2 - temp results
; R3 - word length
; R5 - frame pointer
; R6 - stack pointer
; R7 - return address

.orig x3300
	
; *************** CHAR_COUNT SETUP (Activation Record Setup) ******************************

CHAR_COUNT    ADD R6 R6 #-1 ;Ready R6 for return val
              ADD R6 R6 #-1 ;Iterate stack
              STR R7 R6 #0  ;store return address
              ADD R6 R6 #-1 ;Iterate stack
              STR R5 R6 #0  ;store dynamic link
              ADD R5 R6 #-1 ;set frame pointer
              ADD R6 R6 #-1 ;leave room for result


; *************** CHAR_COUNT CODE ******************************

              LDR R3 R5 #4       ;load R5 with an offset of 4 into R3
              ST  R3 CharAddress ;store the character address in memory
              LDI R0 CharAddress ;load a char into R0 from character address in memory
              BRZ StringEnd
              BRNP ElseIf

;***************************************************************
 
ElseIf        LDR R1 R5 #5  ;load the character we're searching for into R1
              NOT R1 R1     ;not a char in R1
              ADD R1 R1 #1  ;iterate a char
              ADD R2 R1 R0  ;compare current char to char in R0
              BRZ FoundChar
              BRNP IfNotFound

;***************************************************************
 
StringEnd     AND R1 R1 #0  ;clear R1
              STR R1 R5 #0  ;store R1 in R5
              BR Return

;***************************************************************
             
FoundChar     AND R1 R1 #0  ;clear R1
              ADD R1 R1 #1  ;add 1 to R1
              STR R1 R5 #0  ;store R1 in R5
              BR NewFuncCall  

;***************************************************************  
 
IfNotFound    AND R1 R1 #0  ;clear R1
              STR R1 R5 #0  ;store R1 in R5

;***************************************************************
 
NewFuncCall   LDR R0 R5 #5  ;load R5 into R0
              ADD R6 R6 #-1 ;iterate stack
              STR R0 R6 #0  ;store the second argument in the new activation record
			  LDR R0 R5 #4  ;load R5 into R0
		   	  ADD R0 R0 #1  ;increment our string
			  ADD R6 R6 #-1 ;increment stack
			  STR R0 R6 #0  ;store R0 as new argument

			  JSR CHAR_COUNT ;CHAR_COUNT Subroutine, equivalent to a C function

			  LDR R0 R6 #0 ;load R6 into R0
			  LDR R1 R5 #0 ;load result into R5
			  ADD R0 R1 R0 ;add R1 to the return value
			  STR R0 R5 #0 ;store result
			  ADD R6 R6 #3 ;pop off the stack

;***************************************************************	 
				 
Return        LDR R0 R5 #0 ;load R0 into R5
			  STR R0 R5 #3 ;store R5 + 3 in R0
			  ADD R6 R5 #1 ;pop variables
			  LDR R5 R6 #0 ;load R5 into stack (R6)
			  ADD R6 R6 #1 ;pop
			  LDR R7 R6 #0 ;load R7 (PC) into R6
			  ADD R6 R6 #1 ;pop PC return location
				 
			  RET          ;Return 
 
CharAddress .FILL #0       ;Character Storage Address in Memory
.END