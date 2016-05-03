# Battlefield

The main driving loop of the program (once the battlefield is initialized) will control the 
progress of the actors through the battlefield. It will consist of the following:  
• Execution through the loop will continue until all members of one group of actors have been 
eliminated, or 100 rounds have passed.  
• On each pass through the loop, all actors (elves, orcs) will attempt to move in a random 
direction (North (up), East (right), South (down) or West (left)) by one cell position. Actors 
cannot move off of the battlefield, cannot move onto a mountain, and cannot move into a cell that 
already has a friendly unit. If their random direction was an attempt to move into an invalid 
location they do not move that round.  
• On each pass through the main loop each Square will be asked to conduct fighting, if there is an 
elf and an orc in the Square they fight to the death, based on who has the higher strength value.
• On each pass through the main driving loop, the battlefield will be displayed to show the updated 
layout as well as a count of the elves and orcs remaining and the current combat round.  
• You can choose how to control the speed of display. I suggest you ask the user to hit a key to 
continue or quit. This keyboard control lets you can see each iteration – something that will help 
to debug, or allow you to exit the game if you don’t want to conduct 100 combat rounds (some games 
will go 100 rounds with no clear winning side).  
•    The game ends when either:  
o Elves or Orcs on the board go to  zero  
o 100 rounds have  elapsed  
o The user decides to leave the game  
