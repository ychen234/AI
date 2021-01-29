CSC 242 Project1

Collaborators (NetID):
	Yaozhong Huang (yhuang94)
	Qianqian Gu (qgu3)
	Yihe Chen (ychen234)

In this project, we write two seperate board for 4*4 board and 8*8 board;
To run the game on a 4*4 board, please run Reversi1.java
To run the game on a 8*8 board, please run Reversi2.java


Point.java is used for read human player's move.

FOR 4*4 BOARD:
	We include three different types of AI agent:
 		1. play ramdomly
		2. use minimax only
		3. use minimax with alpha-beta pruning and no depth restriction
	
	Main method is contained in the Reversi1.java (Run this file to play the reversi game)

	Board.java contains the method for 4*4 board.
		All the rules of 4*4 board is inclued in Board.java, such as:
			- checking if the step is legal
			- changing the color of the pieces after placing a piece
			- print the board
			- get available & legal nextstep
			- check if the game is finished and check the winner
			......

	Random.java contains the algorithm for AI that plays randomly.
		-  This algorithm is used in Reversi1.java - mode1() method

	SimpleMinimax.java contains the algorithm for AI that uses minimax algorithm when playing.
		-  We assign the utility of each state as the number of the piece of AI player on the board when the game ends.
		-  This algorithm is used in Reversi1.java - mode2() method
	ABpruning.java contains the algorithm for AI that uses minimax algorithm with alpha-beta pruning.
		-  This algorithm is used in Reversi1.java - mode3() method
	
	Reversi1.java contains main method and methods for preparing a game. 


FOR 8*8 BOARD:
	Main method is contained in the Reversi2.java (Run this file to play the reversi game)

	We include three different types of AI agent:
 		1. play ramdomly
		2. use minimax with alpha-beta pruning and a depth cutoff of 7 
		3. use heuristic minimax with alpha-beta pruning and a depth cutoff of 6

		- To change the depth cut off, see Reversi2.java - line 202 for the second mode and Reversi2.java - line 365 for the third mode

	Board2.java contains the method for 8*8 board.
		All the rules of 8*8 board is inclued in Board.java, such as:
			- checking if the step is legal
			- changing the color of the pieces after placing a piece
			- print the board
			- get available & legal nextstep
			- check if the game is finished and check the winner
			......

	Random2.java contains the algorithm for AI that plays randomly.
		- This algorithm is used in Reversi2.java - mode1() method

	ABpruning2.java contains the algorithm for AI that uses minimax algorithm with alpha-beta pruning and a depth cutoff.

		- We assign the utility of each state as the number of the piece of AI player on the board when the game ends.
		
		- This algorithm is used in Reversi2.java - mode2() method
	
	HMinimaxWithPruning.java contains the algorithm for AI that uses heuristic minimax with alpha-beta pruning and a depth cutoff
		- We calculate the utility of each state as a weighted average of a evaluation of the neighbor of a move and a sum of heuristic utility of AI's hold;
		
		- The neighbor of AI's move is measured by calculated by checking the number of the moves you or your opponent can play up, down, left, right, up-left, up-right, down-left, down right after your move minus the number of your opponent's
		
		- the heuristic utility is assigned as:
			row 1   { 99, -5, 8, 3, 3, 8, -5, 99}, 
			row 2   { -5, -49, 1, 1, 1, 1, -49, -5 }, 
			row 3   { 8, 1, 3, 2, 2, 3, 1, 8 }, 
			row 4  { 3 , 1, 2, 1, 1, 2, 1, 3 }, 
			row 5   { 3 , 1, 2, 1, 1, 2, 1, 3 }, 
			row 6   { 8, 1, 3, 2, 2, 3, 1, 8 }, 
			row 7  { -5 , -49, 1, 1, 1, 1, -49, -5 }, 
			row 8   { 99, -5, 8, 3, 3, 8, -5, 80 } };
		
		- We used weighted avarage for the final utility of a move, and it is calculated by
			6* evaluation of the neighbor of AI's move + 4 * sum of heuristic utility of the current situation
		
		- This algorithm is used in Reversi2.java - mode 3 method
	
	Reversi2.java contains main method and methods for preparing a game. 
		

