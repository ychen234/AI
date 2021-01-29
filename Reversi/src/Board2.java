
public class Board2 {
	public String[][] board1;
	public static final String NO_PLAYER = " "; //Blank
	public static final String PLAYER_B = "X"; //Black piece
	public static final String PLAYER_W = "O"; //White piece
	public int white = 2; //count for white pieces
	public int black = 2;// count for black pieces
	public int total = 4;//total pieces on the board
	
	public Board2() {
		board1 = new String[10][10];
		for (int i=1;i<9;i++ ) {
			for (int j=1;j<9;j++) {
				board1[i][j] = " ";
			}
		}
		board1[4][4] = PLAYER_W;
		board1[5][5] = PLAYER_W;
		board1[4][5] = PLAYER_B;
		board1[5][4] = PLAYER_B;
		
		board1[0][0] = " ";
		board1[0][9] = " ";	
		board1[9][0] = " ";
		board1[9][9] = " ";	
		board1[0][1] = "a";
		board1[0][2] = "b";
		board1[0][3] = "c";
		board1[0][4] = "d";
		board1[0][5] = "e";
		board1[0][6] = "f";
		board1[0][7] = "g";
		board1[0][8] = "h";
		
		board1[9][1] = "a";
		board1[9][2] = "b";
		board1[9][3] = "c";
		board1[9][4] = "d";
		board1[9][5] = "e";
		board1[9][6] = "f";
		board1[9][7] = "g";
		board1[9][8] = "h";

		board1[1][0] = "1";
		board1[2][0] = "2";
		board1[3][0] = "3";
		board1[4][0] = "4";
		board1[5][0] = "5";
		board1[6][0] = "6";
		board1[7][0] = "7";
		board1[8][0] = "8";
		
		board1[1][9] = "1";
		board1[2][9] = "2";
		board1[3][9] = "3";
		board1[4][9] = "4";
		board1[5][9] = "5";
		board1[6][9] = "6";
		board1[7][9] = "7";
		board1[8][9] = "8";

	
		
		for (int i=1;i<9;i++ ) {
			for (int j=1;j<9;j++) {
				if(board1[i][j].equals(PLAYER_W)) {
					white++;
					total++;
				}else if (board1[i][j].equals(PLAYER_B)) {
					black++;
					total++;
				}
			}
		}
	}	
	
	public Board2(String[][] b) {// method for AI to copy board
		board1 = new String[10][10];
		for (int i=0;i<10;i++ ) {
			for (int j=0;j<10;j++) {
				board1[i][j] = b[i][j];
			}
			
		}
	
		for (int i=1;i<9;i++ ) {
			for (int j=1;j<9;j++) {
				if(board1[i][j].equals(PLAYER_W)) {
					white++;
					total++;
				}else if (board1[i][j].equals(PLAYER_B)) {
					black++;
					total++;
				}
			}
		}
		
	}
	
	public Board2(Board2 b) {
		board1 = new String[10][10];
		for (int i=0;i<10;i++ ) {
			for (int j=0;j<10;j++) {
				board1[i][j] = b.board1[i][j];
			}
		}
		
		white = b.white;
		black = b.black;
		total = b.total;
		
	}
	
	public void printBoard() {
		for (int i = 0; i<10; i++) {
			for (int j=0;j<10;j++) {
			System.out.print(board1[i][j]);
			}
			System.out.println("");
		}
	}
	public static String[][] initiateBoard() {
		String[][] board = new String[10][10];
		for (int i=1;i<9;i++ ) {
			for (int j=1;j<9;j++) {
				board[i][j] = NO_PLAYER;
			}
		}
		board[4][4] = PLAYER_W;
		board[5][5] = PLAYER_W;
		board[4][5] = PLAYER_B;
		board[5][4] = PLAYER_B;
		
		board[0][0] = " ";
		board[0][9] = " ";	
		board[9][0] = " ";
		board[9][9] = " ";	
		board[0][1] = "a";
		board[0][2] = "b";
		board[0][3] = "c";
		board[0][4] = "d";
		board[0][5] = "e";
		board[0][6] = "f";
		board[0][7] = "g";
		board[0][8] = "h";
		
		board[9][1] = "a";
		board[9][2] = "b";
		board[9][3] = "c";
		board[9][4] = "d";
		board[9][5] = "e";
		board[9][6] = "f";
		board[9][7] = "g";
		board[9][8] = "h";

		board[1][0] = "1";
		board[2][0] = "2";
		board[3][0] = "3";
		board[4][0] = "4";
		board[5][0] = "5";
		board[6][0] = "6";
		board[7][0] = "7";
		board[8][0] = "8";
		
		board[1][9] = "1";
		board[2][9] = "2";
		board[3][9] = "3";
		board[4][9] = "4";
		board[5][9] = "5";
		board[6][9] = "6";
		board[7][9] = "7";
		board[8][9] = "8";
		
		return board;
	}
	
	public static String[][] nextState(String[][] b, int action, String player){
		Board2 b1 = new Board2(b);
		b1.put(action / 8 + 1, action % 8 + 1, player);
		return b1.getBoard();
	}
	
	public void put(int i, int j, String player) {
		if ((i<1) || (i>8) || (j>8) || (j<1)) {
			System.out.println("You movement is out of bundle");
			return;
		}
		
		int ix = 0;// increase in a row
		int jy = 0;// increase in a column
		int count = 0;
		for(int a = 0 ; a<8; a++) {
			switch(a) {
			case 0: {
				ix=1; 
				jy=0;  // check down
			}
				break;
			case 1: {
				ix=0; 
				jy=1;  // check right
			}
				break;
			case 2: {
				ix=-1; 
				jy=0; // check up
			}
				break;
			case 3: {
				ix=0; 
				jy=-1;// check left
			}
				break;
			case 4: {
				ix=1; 
				jy=1; // check down-right
			}
				break;
			case 5: {
				ix=1;
				jy=-1; // check down-left
			}
				break;
			case 6: {
				ix=-1; 
				jy=1;  // check up-right
			}
				break;
			case 7: {
				ix=-1; 
				jy=-1; // check up-left
			}
				break;
			default:;
			}
			count = 0;
			int new_i = i+ix;
			int new_j = j+jy;
			count++;
			if ((new_j < 1)||(new_i < 1)||(new_i > 8)||(new_j >8)) continue;
			if ((board1[new_i][new_j]).equals(NO_PLAYER)) continue;
			if ((board1[new_i][new_j]).equals(player)) continue;
			while ((board1[new_i][new_j]).equals(opponent(player))) {
				new_i += ix;
				new_j += jy;
				count++;
				if ((new_j < 1)||(new_i < 1)||(new_i > 8)||(new_j >8))break;
				if ((board1[new_i][new_j]).equals(NO_PLAYER)) break;
				if((board1[new_i][new_j]).equals(player)) {
					for (int k=1; k<=count-1; k++) {
						board1[i + k*ix][j + k*jy] = player;
						if(player.equals(PLAYER_B)) {
							black++;
							white--;
						}else if(player.equals(PLAYER_W)) {
							white++;
							black--;
						}
					}
					board1[i][j] = player;
					break;
				}
			}
			
		}
		
		total++;
		if(player.equals(PLAYER_B)) {
			black++;
		}else if(player.equals(PLAYER_W)) {
			white++;
		}
		
	}
	
	public boolean isLegalState(int i, int j, String player ) {
		if ((i<1) || (i>8) || (j>8) || (j<1)) {
			return false;
		}
		
		if(!(board1[i][j].equals(NO_PLAYER))) {
			return false;
		}
		
		int ix = 0;// increase in a row
		int jy = 0;// increase in a column

		for(int a = 0 ; a<8; a++) {
			switch(a) {
			case 0: {
				ix=1; 
				jy=0;  // check down
			}
				break;
			case 1: {
				ix=0; 
				jy=1;  // check right
			}
				break;
			case 2: {
				ix=-1; 
				jy=0; // check up
			}
				break;
			case 3: {
				ix=0; 
				jy=-1;// check left
			}
				break;
			case 4: {
				ix=1; 
				jy=1; // check down-right
			}
				break;
			case 5: {
				ix=1;
				jy=-1; // check down-left
			}
				break;
			case 6: {
				ix=-1; 
				jy=1;  // check up-right
			}
				break;
			case 7: {
				ix=-1; 
				jy=-1; // check up-left
			}
				break;
			default:;
			}

			int new_i = i+ix;
			int new_j = j+jy;

			if ((new_j < 1)||(new_i < 1)||(new_i > 8)||(new_j >8)) continue;
			if ((board1[new_i][new_j]).equals(NO_PLAYER)) continue;
			if ((board1[new_i][new_j]).equals(player)) continue;
			while ((board1[new_i][new_j]).equals(opponent(player))) {
				new_i += ix;
				new_j += jy;

				if ((new_j < 1)||(new_i < 1)||(new_i > 8)||(new_j >8))break;
				if ((board1[new_i][new_j]).equals(NO_PLAYER)) break;
				if((board1[new_i][new_j]).equals(player)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	public static String opponent(String player) {
		if(player.equals(PLAYER_B)) {
			return PLAYER_W;
		}else if (player.equals(PLAYER_W)) {
			return PLAYER_B;
		}else {
			return NO_PLAYER;
		}
	}
	
	public String[][] getBoard(){
		String[][] newboard= new String[10][10];
		for (int i=0;i<10;i++ ) {
			for (int j=0;j<10;j++) {
				newboard[i][j] = board1[i][j];
			}
		}
		return newboard;
	}
	
	public static int[] nextAction(String[][] board, String player){
		Board2 b = new Board2(board);
		return b.actionList(player);
	}
	
	public int[] actionList(String player){
		int[] nextstate = new int[65];
		for (int i=0;i<65;i++ ) {
				nextstate[i] = 0;
			}	
		
		for (int i=1;i<9;i++ ) {
			for (int j=1;j<9;j++) {
				if (isLegalState(i,j, player)) {
					nextstate[0]++;
					int order = nextstate[0];
					nextstate[order] = (i-1)*8 + j-1;
				}
				
			}
		}
		
		return nextstate;
	}
	
	public static int getTotal(String[][] board){
		int total = 0;
		for (int i=1;i<9;i++ ) {
			for (int j=1;j<9;j++) {
				if(!(board[i][j].equals(NO_PLAYER))) {
					total++;
				}
			}
		}
		return total;
	}
	
	public int getScore(String player, String[][] board){
		int w = 0; 
		int b = 0;
		
		for (int i=1;i<9;i++ ) {
			for (int j=1;j<9;j++) {
				if(board[i][j].equals(PLAYER_W)) {
					w++;
				}else if(board[i][j].equals(PLAYER_B)) {
					b++;
				}
			}
		}
			
		if (player.equals("O")) {
			return w;
		}else {
			return b;
		}
	}
	
	public static String isWinner(String[][] board) {
		int w = 0; 
		int b = 0;
		
		for (int i=1;i<9;i++ ) {
			for (int j=1;j<9;j++) {
				if(board[i][j].equals(PLAYER_W)) {
					w++;
				}else if(board[i][j].equals(PLAYER_B)) {
					b++;
				}
			}
		}
		
		if(b>w) {
			return PLAYER_B;
		}else if (b<w) {
			return PLAYER_W;
		}
		return NO_PLAYER;
	}
	
	public static boolean isFinished(String[][] board) {
		Board2 b = new Board2(board);
		if (Board2.getTotal(board) == 64) return true;
		int[] whiteAction;
		int[] blackAction;
		whiteAction = b.actionList(PLAYER_W);
		blackAction = b.actionList(PLAYER_B);
		
		if (whiteAction[0] > 0) return false;
		if (blackAction[0] > 0) return false;
		
		return true;
	}
	public void printActionList(String[][] board, String player) {
		Board2 b = new Board2(board);
		int[] list1 = b.actionList(player);
		Point[] list2 = new Point[list1.length-1];
		for (int i = 0 ; i <list2.length; i++) {
			list2[i] = new Point(list1[i+1]/8 +1, list1[i+1]%8 + 1);
		}
		
		for (int i = 0 ; i <list2.length; i++) {
			if(list2[i].getC().equals("a") || list2[i].getC().equals("b") || list2[i].getC().equals("c") || list2[i].getC().equals("d") || list2[i].getC().equals("e") || list2[i].getC().equals("f") || list2[i].getC().equals("g") || list2[i].getC().equals("h")) {
				if(i!=0 && (list2[i].getC().equals("a")) && (list2[i].getA()==1)) {
					break;
				}else {
					System.out.print(list2[i] + " ");
				}
			}
		}
	}
	}

