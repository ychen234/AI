import java.util.Scanner;

public class Reversi2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please choose your game: ");
		System.out.println("1. 8*8 Reversi with an agent playing ramdomly");
		System.out.println("2. 8*8 Reversi with an agent that uses  MINIMAX with a-b pruning");
		System.out.println("3. 8*8 Reversi with an agent that uses  H-MINIMAX with a fixed depth cutoff and a-b pruning");
		System.out.print("Please enter your choice: ");
		int choiceBoard = s.nextInt();
		
		if (choiceBoard == 1) {
			mode1();
		}else if (choiceBoard == 2) {
			mode2();
		}else if (choiceBoard == 3) {
			mode3();
			}
		}

	
	public static void mode1() {
		Scanner s = new Scanner (System.in);
		System.out.println();
		System.out.println("You chose 8*8 Reversi with an agent playing ramdomly");
		Board2 b = new Board2();
		String[][] b1 = Board2.initiateBoard();
		b.printBoard();
		System.out.println("Please select your side (Black goes first) : ");
		System.out.println("1. Black (X)  2. White (O)");
		int choiceTurn = s.nextInt();
		
		
			if(choiceTurn == 1) {				
				b.printBoard();
				Random2 m1 = new Random2(b1, "O");
				int aiMove;
					while(true) {
						Point p;
						int[] list1 = b.actionList("X");
						if (list1[0]>0) {
						do {
							System.out.println("Now, it's your turn: [print (1 a) (without bracket) to play at row 1, column a]");	
							System.out.print("Here is the legal movement for you: ");
							b.printActionList(b1, "X");
							System.out.println();	
							
							p = new Point(s.nextInt(),s.next());
							
							if(!b.isLegalState(p.getA(), p.getB(), "X")) {
								System.out.println("Your move is illegal!");
							}
						}while(!(b.isLegalState(p.getA(), p.getB(), "X")));
						
						b.put(p.getA(), p.getB(), "X");
						b1 = b.board1;
						b.printBoard();
						
						if(Board2.isFinished(b1)) {
							System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
							if (Board2.isWinner(b1).equals("X")) {
								System.out.println("Congrats! You win!");
							}else if(Board2.isWinner(b1).equals("O")) {
								System.out.println("Sorry you lost!");
							}else {
								System.out.println("Draw!");
							}
							break;
							}
						}else {
							System.out.println("You cannot move!");
						
							if(Board2.isFinished(b1)) {
								System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
								if (Board2.isWinner(b1).equals("X")) {
									System.out.println("Congrats! You win!");
								}else if(Board2.isWinner(b1).equals("O")) {
									System.out.println("Sorry you lost!");
								}else {
									System.out.println("Draw!");
								}
								break;
							}
							
						}
	
						m1.setBoard(b1);
						aiMove = m1.randomAction();
						if (aiMove >=0 ) {
							b = new Board2(m1.board);								
							System.out.println("AI puts at: " + new Point(aiMove/8 + 1, aiMove % 8 + 1) );
						}else {								
							System.out.println("AI cannot move!");
							
						}
						b1 = b.board1;
						b.printBoard();
						
		
						if(Board2.isFinished(b1)) {
							System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
							if (Board2.isWinner(b1).equals("X")) {
								System.out.println("Congrats! You win!");
							}else if(Board2.isWinner(b1).equals("O")) {
								System.out.println("Sorry you lost!");
							}else {
								System.out.println("Draw!");
							}
							break;
						}
					}
		
				}else if(choiceTurn==2){
					b.printBoard();
					Random2 m1 = new Random2(b1, "X");
					int aiMove;
				while(true) {		
					m1.setBoard(b1);
					aiMove = m1.randomAction();
					m1.board.printBoard();

					if (aiMove >=0 ) {
						b = new Board2(m1.board);
						System.out.println("AI puts at: " + new Point(aiMove/8 + 1, aiMove % 8 + 1) );
					}else {
						System.out.println("AI cannot move!");
					}
		
					b.printBoard();
					b1 = b.board1;
		
					if(Board2.isFinished(b1)) {
						System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
						if (Board2.isWinner(b1).equals("O")) {
							System.out.println("Congrats! You win!");
						}else if(Board2.isWinner(b1).equals("X")) {
							System.out.println("Sorry you lost!");
						}else {
							System.out.println("Draw!");
						}
						break;
					}
					
					Point p;
					int[] list1 = b.actionList("O");
					if (list1[0]>0) {
					do {
						System.out.println("Now, it's your turn: [print (1 a) (without bracket) to play at row 1, column a]");	
						System.out.print("Here is the legal movement for you: ");
						b.printActionList(b1, "O");
						System.out.println();	
						
						p = new Point(s.nextInt(),s.next());
						if(!b.isLegalState(p.getA(), p.getB(), "O")) {
							System.out.println("Your move is illegal!");
						}
					}while(!(b.isLegalState(p.getA(), p.getB(), "O")));
					
					b.put(p.getA(), p.getB(), "O");
					b1 = b.board1;
					b.printBoard();
					
					if(Board2.isFinished(b1)) {
						System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
						if (Board2.isWinner(b1).equals("O")) {
							System.out.println("Congrats! You win!");
						}else if(Board2.isWinner(b1).equals("X")) {
							System.out.println("Sorry you lost!");
						}else {
							System.out.println("Draw!");
						}
						break;
					}
					}else {
						System.out.println("You cannot move!");
						if(Board2.isFinished(b1)) {
							System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
							if (Board2.isWinner(b1).equals("O")) {
								System.out.println("Congrats! You win!");
							}else if(Board2.isWinner(b1).equals("X")) {
								System.out.println("Sorry you lost!");
							}else {
								System.out.println("Draw!");
							}
							break;
						}
					}
				}

				}
	}
	
	public static void mode2() {
		Scanner s = new Scanner(System.in);
		Board2 b = new Board2();
		String[][] b1 = Board2.initiateBoard();
		b.printBoard();
		System.out.println("Please select your side (Black goes first) : ");
		System.out.println("1. Black  2. White ");
		int choiceTurn = s.nextInt();
		int depth = 7; //place for changing the depth cut off
		
		if(choiceTurn == 1) {				
			b.printBoard();
		while(true) {
			Point p;
			int[] list1 = b.actionList("X");
			if (list1[0]>0) {
			do {
				System.out.println("Now, it's your turn: [print (1 a) (without bracket) to play at row 1, column a]");	
				System.out.print("Here is the legal movement for you: ");
				b.printActionList(b1, "X");
				System.out.println();	
				
				p = new Point(s.nextInt(),s.next());
				
				if(!b.isLegalState(p.getA(), p.getB(), "X")) {
					System.out.println("Your move is illegal!");
				}
			}while(!(b.isLegalState(p.getA(), p.getB(), "X")));
			
			b.put(p.getA(), p.getB(), "X");
			b1 = b.board1;
			b.printBoard();
			
			if(Board2.isFinished(b1)) {
				System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
				if (Board2.isWinner(b1).equals("X")) {
					System.out.println("Congrats! You win!");
				}else if(Board2.isWinner(b1).equals("O")) {
					System.out.println("Sorry you lost!");
				}else {
					System.out.println("Draw!");
				}
				break;
			}
			}else {
				System.out.println("You cannot move!");
				
				if(Board2.isFinished(b1)) {
					System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
					if (Board2.isWinner(b1).equals("X")) {
						System.out.println("Congrats! You win!");
					}else if(Board2.isWinner(b1).equals("O")) {
						System.out.println("Sorry you lost!");
					}else {
						System.out.println("Draw!");
					}
					break;
				}
			}
			
			
			ABpruning2 a1 = new ABpruning2(b, depth,-1000,1000, "O", true, "O");
			int d = a1.alphabetapruning();
			boolean legal = b.isLegalState(a1.getA(), a1.getB(),"O");
			System.out.println("v = " + d);
			if(legal){
				b.put(a1.getA(), a1.getB(),"O");
				System.out.println("AI put at: (" + a1.getA() + " , " + a1.getB()+ " )");
				b.printBoard();
				b1=b.getBoard();
			}else {
				System.out.println("AI cannot move!");
			}

			if(Board2.isFinished(b1)) {
				System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
				if (Board2.isWinner(b1).equals("X")) {
					System.out.println("Congrats! You win!");
				}else if(Board2.isWinner(b1).equals("O")) {
					System.out.println("Sorry you lost!");
				}else {
					System.out.println("Draw!");
				}
				break;
			}
		}

	}else if(choiceTurn==2){
		while(true) {		
			ABpruning2 a1 = new ABpruning2(b, depth,-1000,1000, "X", true, "X");
			int d = a1.alphabetapruning();
			boolean legal = b.isLegalState(a1.getA(), a1.getB(),"X");
			System.out.println("v = " + d);
			if(legal){
				b.put(a1.getA(), a1.getB(),"X");
				System.out.println("AI put at: (" + a1.getA() + " , " + a1.getB()+ " )");
				b.printBoard();
				b1=b.getBoard();
			}else {
				System.out.println("AI cannot move!");
			}

			if(Board2.isFinished(b1)) {
				System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
				if (Board2.isWinner(b1).equals("O")) {
					System.out.println("Congrats! You win!");
				}else if(Board2.isWinner(b1).equals("X")) {
					System.out.println("Sorry you lost!");
				}else {
					System.out.println("Draw!");
				}
				break;
			}
			
			Point p;
			int[] list1 = b.actionList("O");
			if (list1[0]>0) {
			do {
				System.out.println("Now, it's your turn: [print (1 a) (without bracket) to play at row 1, column a]");	
				System.out.print("Here is the legal movement for you: ");
				b.printActionList(b1, "O");
				System.out.println();	
				
				p = new Point(s.nextInt(),s.next());
				
				if(!b.isLegalState(p.getA(), p.getB(), "O")) {
					System.out.println("Your move is illegal!");
				}
			}while(!(b.isLegalState(p.getA(), p.getB(), "O")));
			
			b.put(p.getA(), p.getB(), "O");
			b1 = b.board1;
			b.printBoard();
			
			if(Board2.isFinished(b1)) {
				System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
				if (Board2.isWinner(b1).equals("O")) {
					System.out.println("Congrats! You win!");
				}else if(Board2.isWinner(b1).equals("X")) {
					System.out.println("Sorry you lost!");
				}else {
					System.out.println("Draw!");
				}
				break;
			}
			}else {
				System.out.println("You cannot move!");
				if(Board2.isFinished(b1)) {
					System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
					if (Board2.isWinner(b1).equals("O")) {
						System.out.println("Congrats! You win!");
					}else if(Board2.isWinner(b1).equals("X")) {
						System.out.println("Sorry you lost!");
					}else {
						System.out.println("Draw!");
					}
					break;
				}
			}
		}
		}
	}
	
	public static void mode3() {
		Scanner s = new Scanner(System.in);
		Board2 b = new Board2();
		String[][] b1 = Board2.initiateBoard();
		b.printBoard();
		System.out.println("Please select your side (Black goes first) : ");
		System.out.println("1. Black  2. White ");
		int choiceTurn = s.nextInt();
		int depth = 6;
		
		if(choiceTurn == 1) {				
			b.printBoard();

		while(true) {
			Point p;
			int[] list1 = b.actionList("X");
			if (list1[0]>0) {
			do {
				System.out.println("Now, it's your turn: [print (1 a) (without bracket) to play at row 1, column a]");	
				System.out.print("Here is the legal movement for you: ");
				b.printActionList(b1, "X");
				System.out.println();	
				
				p = new Point(s.nextInt(),s.next());
				
				if(!b.isLegalState(p.getA(), p.getB(), "X")) {
					System.out.println("Your move is illegal!");
				}
			}while(!(b.isLegalState(p.getA(), p.getB(), "X")));
			
			b.put(p.getA(), p.getB(), "X");
			b1 = b.board1;
			b.printBoard();
			
			if(Board2.isFinished(b1)) {
				System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
				if (Board2.isWinner(b1).equals("X")) {
					System.out.println("Congrats! You win!");
				}else if(Board2.isWinner(b1).equals("O")) {
					System.out.println("Sorry you lost!");
				}else {
					System.out.println("Draw!");
				}
				break;
			}
			}else {
				System.out.println("You cannot move!");
				
				if(Board2.isFinished(b1)) {
					System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
					if (Board2.isWinner(b1).equals("X")) {
						System.out.println("Congrats! You win!");
					}else if(Board2.isWinner(b1).equals("O")) {
						System.out.println("Sorry you lost!");
					}else {
						System.out.println("Draw!");
					}
					break;
				}
			}
			
			
			HMinimaxWithPruning a1 = new HMinimaxWithPruning(b, depth,-1000,1000, "O", true, "O");
			int d = a1.alphabeta();
			boolean legal = b.isLegalState(a1.getA(), a1.getB(),"O");
			System.out.println("v = " + d);
			if(legal){
				b.put(a1.getA(), a1.getB(),"O");
				System.out.println("AI put at: (" + a1.getA() + " , " + a1.getB()+ " )");
				b.printBoard();
				b1=b.getBoard();
			}else {
				System.out.println("AI cannot move!");
			}			

			if(Board2.isFinished(b1)) {
				System.out.println("Your score : AI score = " + b.getScore("X", b1) + " : " + b.getScore("O", b1));
				if (Board2.isWinner(b1).equals("X")) {
					System.out.println("Congrats! You win!");
				}else if(Board2.isWinner(b1).equals("O")) {
					System.out.println("Sorry you lost!");
				}else {
					System.out.println("Draw!");
				}
				break;
			}
		}

	}else if(choiceTurn==2){

	while(true) {		
		HMinimaxWithPruning a1 = new HMinimaxWithPruning(b, depth,-1000,1000, "X", true, "X");
		int d = a1.alphabeta();
		boolean legal = b.isLegalState(a1.getA(), a1.getB(),"X");
		System.out.println("v = " + d);
		if(legal){
			b.put(a1.getA(), a1.getB(),"X");
			System.out.println("AI put at: (" + a1.getA() + " , " + a1.getB()+ " )");
			b.printBoard();
			b1=b.getBoard();
		}else {
			System.out.println("AI cannot move!");
		}

		if(Board2.isFinished(b1)) {
			System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
			if (Board2.isWinner(b1).equals("O")) {
				System.out.println("Congrats! You win!");
			}else if(Board2.isWinner(b1).equals("X")) {
				System.out.println("Sorry you lost!");
			}else {
				System.out.println("Draw!");
			}
			break;
		}
		
		Point p;
		int[] list1 = b.actionList("O");
		if (list1[0]>0) {
		do {
			System.out.println("Now, it's your turn: [print (1 a) (without bracket) to play at row 1, column a]");	
			System.out.print("Here is the legal movement for you: ");
			b.printActionList(b1, "O");
			System.out.println();	
			
			p = new Point(s.nextInt(),s.next());
			
			if(!b.isLegalState(p.getA(), p.getB(), "O")) {
				System.out.println("Your move is illegal!");
			}
		}while(!(b.isLegalState(p.getA(), p.getB(), "O")));
		
		b.put(p.getA(), p.getB(), "O");
		b1 = b.board1;
		b.printBoard();
		
		if(Board2.isFinished(b1)) {
			System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
			if (Board2.isWinner(b1).equals("O")) {
				System.out.println("Congrats! You win!");
			}else if(Board2.isWinner(b1).equals("X")) {
				System.out.println("Sorry you lost!");
			}else {
				System.out.println("Draw!");
			}
			break;
		}
		}else {
			System.out.println("You cannot move!");
			if(Board2.isFinished(b1)) {
				System.out.println("Your score : AI score = " + b.getScore("O", b1) + " : " + b.getScore("X", b1));
				if (Board2.isWinner(b1).equals("O")) {
					System.out.println("Congrats! You win!");
				}else if(Board2.isWinner(b1).equals("X")) {
					System.out.println("Sorry you lost!");
				}else {
					System.out.println("Draw!");
				}
				break;
			}
		}
	}
	}
	}
}
	
	
	
