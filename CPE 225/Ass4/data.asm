;Addison Martin & Michael Elliott
;CPE 225-03
;Assignment 4
;2/10/17

.ORIG x3300

Q1	.STRINGZ "\nWhat is Michael's favorite movie?\n	1 - Iron Giant\n	2 - Interstellar\n	3 - Hot Rod\n	4 - The Proposal\nAnswer: "
Q1Answ   .FILL    #3
         .FILL    #4
         .FILL    #2
         .FILL    #1


Q2	.STRINGZ "\nWhat is Addison's favorite movie?\n	1 - Good Will Hunting\n	2 - Iron Man\n	3 - A Beautiful Mind\n	4 - The Clone Wars\nAnswer: "
Q2Answ   .FILL    #3
         .FILL    #2
         .FILL    #4
         .FILL    #1


Q3	.STRINGZ "\nWhat is Michael's favorite food?\n	1 - Pizza Rolls\n	2 - Brusselsprouts\n	3 - Watermelon\n	4 - Hot Cheetos\nAnswer: "
Q3Answ   .FILL    #4
         .FILL    #3
         .FILL    #1
         .FILL    #2


Q4	.STRINGZ "\nWhat is Addison's favorite food?\n	1 - Thai\n	2 - Pasta\n	3 - Meat\n	4 - Sushi\nAnswer: "
Q4Answ   .FILL    #3
         .FILL    #4
         .FILL    #1
         .FILL    #2


Q5	.STRINGZ "\nWhat is Michael's favorite hobby?\n	1 - Video Games\n	2 - Television\n	3 - Swimming\n	4 - Welding\nAnswer: "
Q5Answ   .FILL    #4
         .FILL    #3
         .FILL    #1
         .FILL    #2


Q6	.STRINGZ "\nWhat is Addison's favorite hobby?\n	1 - Video Games\n	2 - Hiking\n	3 - Basket Weaving\n	4 - Stargazing\nAnswer: "
Q6Answ   .FILL    #2
         .FILL    #4
         .FILL    #1
         .FILL    #3

Result1	.STRINGZ  "\nTerrible! You don't know us at all!\n"				;6-10
Result2	.STRINGZ  "\nHmm, I thought you'd know your students better.\n"			;11-16
Result3	.STRINGZ  "\nNot bad, Julie.  You judge well.\n"				;17-20
Result4	.STRINGZ  "\nExcellent!  Julie, you know Addison and Michael perfectly!!!\n"	;21-24

.END