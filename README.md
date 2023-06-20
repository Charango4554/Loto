# Loto
This is a university project to simulate a lotto game with several participants.


The game consists of traversing a board filled with different types of squares that influence the player's progress through the game.

Game parameters :
- the dimensions of the board (between 2 and 26 for rows and columns), so that you have at least 4 squares and can number up to 26 letters of the alphabet
- the percentage of squares
- player's stone number (automatically calculated) - player's name
Description of functions:
- At program start-up :
- choose the percentage of the different squares (Stone, Mine, 0bstacle and Passage) - enter the number of rows on the board
- enter number of columns
- enter player name


A message prompts you to choose between moving forward (A) or throwing a stone (P).
Then, depending on the previous choice, select the direction (g|d|h|b|hg|bg|hd|bd)
respectively (left, right, bottom, top-left, bottom-left, top-right, bottom-right) If a stone is thrown, then :

-it is lost if it touches a board edge
it is lost and added to the stones of a stone-type square if this is the case
-lost if it encounters a resistant obstacle, the obstacle loses resistance by one unit.
resistance is 0, the stone continues in the same direction
-lost if it encounters a mine, the mine is deactivated if it wasn't, otherwise the stone continues in the same direction
continues in the same direction to the destination square if the stone encounters a passage-type square.
- If the player is advancing
-is blocked if it encounters the edge of the board
-picks up stones from this type of square if he reaches it
-is blocked if it encounters an obstacle, unless the obstacle has a resistance of 0
-explodes and the game ends if it encounters an active mine; nothing happens if the mine was
Inactive
he reaches the destination square if he comes across a passage-type square.
- If he finds the exit, the game ends and the player wins.
- The board is displayed with the type of each revealed square at the end of each game, after winning or losing.
having won or lost
- At the end of each game, the player decides whether or not (Y/N) to play again.


Each square over which the player passes is revealed, leaving behind the player the path taken

Program classes :
Bordure: used to build the board's boundaries
Case: mother class of all cases, an abstract class
Categories: used to categorize squares and associate each type with a percentage on the board
Depart: square from which the player starts, located in the upper left corner, in the same line as the borders.
Direction: to create the different possible directions
Joueur: to model the player
Mine: subclass of Case and explodes if active
Obstacle: subclass of Case, cannot be crossed if its resistance is greater than zero
Passage: subclass of Case n redirects to a square of
Pierre: subclass of Case, stops a stone by adding it to itself, and is picked up by the player.
Sortie: subclass of Case, corresponds to the exit class of the board.
Vide: subclass of Case, corresponds to cases that have no effect on the player or on a stone Operation: class that manages game parameters and launches the game.
Exploration: class that manages game parameters and launches the game
Game: class that manages the progress of a game round
Lire: class providing input functions
