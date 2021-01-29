
public class Board {
	public String[][] board1;
	public static final String NO_PLAYER = " "; //Blank
	public static final String PLAYER_B = "X"; //Black piece
	public static final String PLAYER_W = "O"; //White piece
	public int white = 2; //count for white pieces
	public int black = 2;// count for black pieces
	public int total = 4;//total pieces on the board
	public Point[] legalSpace;
	
	public Board() {
		board1 = new String[6][6];
		for (int i=1;i<5;i++ ) {
			for (int j=1;j<5;j++) {
				board1[i][j] = " ";
			}
			board1[2][2] = PLAYER_W;
			board1[3][3] = PLAYER_W;
			board1[2][3] = PLAYER_B;
			board1[3][2] = PLAYER_B;
		}
		board1[0][0] = " ";
		board1[0][5] = " ";	
		board1[5][0] = " ";
		board1[5][5] = " ";	
		board1[0][1] = "a";
		board1[0][2] = "b";
		board1[0][3] = "c";
		board1[0][4] = "d";
		board1[5][1] = "a";
		board1[5][2] = "b";
		board1[5][3] = "c";
		board1[5][4] = "d";
		board1[1][0] = "1";
		board1[2][0] = "2";
		board1[3][0] = "3";
		board1[4][0] = "4";
		board1[1][5] = "1";
		board1[2][5] = "2";
		board1[3][5] = "3";
		board1[4][5] = "4";
		
		for (int i=1;i<5;i++ ) {
			for (int j=1;j<5;j++) {
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
	
	public Board(String[][] b) {// method for AI to copy board
		board1 = new String[6][6];
		for (int i=0;i<6;i++ ) {
			for (int j=0;j<6;j++) {
				board1[i][j] = b[i][j];
			}
			
		}
	
		for (int i=1;i<5;i++ ) {
			for (int j=1;j<5;j++) {
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
	
	public Board(Board b) {
		board1 = new String[6][6];
		for (int i=0;i<6;i++ ) {
			for (int j=0;j<6;j++) {
				board1[i][j] = b.board1[i][j];
			}
		}
		
		white = b.white;
		black = b.black;
		total = b.total;
		
	}
	
	public void printBoard() {
		for (int i = 0; i<6; i++) {
			for (int j=0;j<6;j++) {
			System.out.print(board1[i][j]);
			}
			System.out.println("");
		}
	}
	public static String[][] initiateBoard() {
		String[][] board = new String[6][6];
		for (int i=1;i<5;i++ ) {
			for (int j=1;j<5;j++) {
				board[i][j] = NO_PLAYER;
			}
		}
		board[0][0] = " ";
		board[0][5] = " ";	
		board[5][0] = " ";
		board[5][5] = " ";	
		board[2][2] = PLAYER_W;
		board[3][3] = PLAYER_W;
		board[2][3] = PLAYER_B;
		board[3][2] = PLAYER_B;
		board[0][1] = "a";
		board[0][2] = "b";
		board[0][3] = "c";
		board[0][4] = "d";
		board[5][1] = "a";
		board[5][2] = "b";
		board[5][3] = "c";
		board[5][4] = "d";
		board[1][0] = "1";
		board[2][0] = "2";
		board[3][0] = "3";
		board[4][0] = "4";
		board[1][5] = "1";
		board[2][5] = "2";
		board[3][5] = "3";
		board[4][5] = "4";
		
		return board;
	}
	
	public static String[][] nextState(String[][] b, int action, String player){
		Board b1 = new Board(b);
		b1.put(action / 4 + 1, action % 4 + 1, player);
		return b1.getBoard();
	}
	
	public void put(int i, int j, String player) {
		if ((i<1) || (i>4) || (j>4) || (j<1)) {
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
			if ((new_j < 1)||(new_i < 1)||(new_i > 4)||(new_j >4)) continue;
			if ((board1[new_i][new_j]).equals(NO_PLAYER)) continue;
			if ((board1[new_i][new_j]).equals(player)) continue;
			while ((board1[new_i][new_j]).equals(opponent(player))) {
				new_i += ix;
				new_j += jy;
				count++;
				if ((new_j < 1)||(new_i < 1)||(new_i > 4)||(new_j >4))break;
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
		if ((i<1) || (i>4) || (j>4) || (j<1)) {
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

			if ((new_j < 1)||(new_i < 1)||(new_i > 4)||(new_j >4)) continue;
			if ((board1[new_i][new_j]).equals(NO_PLAYER)) continue;
			if ((board1[new_i][new_j]).equals(player)) continue;
			while ((board1[new_i][new_j]).equals(opponent(player))) {
				new_i += ix;
				new_j += jy;

				if ((new_j < 1)||(new_i < 1)||(new_i > 4)||(new_j >4))break;
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
		String[][] newboard= new String[6][6];
		for (int i=0;i<6;i++ ) {
			for (int j=0;j<6;j++) {
				newboard[i][j] = board1[i][j];
			}
		}
		return newboard;
	}
	
	public static int[] nextAction(String[][] board, String player){
		Board b = new Board(board);
		return b.actionList(player);
	}
	
	public void printActionList(String[][] board, String player) {
		Board b = new Board(board);
		int[] list1 = b.actionList(player);
		Point[] list2 = new Point[list1.length-1];
		for (int i = 0 ; i <list2.length; i++) {
			list2[i] = new Point(list1[i+1]/4 +1, list1[i+1]%4 + 1);
		}
		
		for (int i = 0 ; i <list2.length; i++) {
			if(list2[i].getC().equals("a") || list2[i].getC().equals("b") || list2[i].getC().equals("c") || list2[i].getC().equals("d")) {
				if(i!=0 && (list2[i].getC().equals("a")) && (list2[i].getA()==1)) {
					break;
				}else {
					System.out.print(list2[i] + " ");
				}
			}
		}
	}
	
	public int[] actionList(String player){
		int[] nextstate = new int[17];
		for (int i=0;i<17;i++ ) {
				nextstate[i] = 0;
			}	
		
		for (int i=1;i<5;i++ ) {
			for (int j=1;j<5;j++) {
				if (isLegalState(i,j, player)) {
					nextstate[0]++;
					int order = nextstate[0];
					nextstate[order] = (i-1)*4 + j-1;
				}
				
			}
		}
		
		return nextstate;
	}
	
	public static int getTotal(String[][] board){
		int total = 0;
		for (int i=1;i<5;i++ ) {
			for (int j=1;j<5;j++) {
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
		
		for (int i=1;i<5;i++ ) {
			for (int j=1;j<5;j++) {
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
		
		for (int i=1;i<5;i++ ) {
			for (int j=1;j<5;j++) {
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
		Board b = new Board(board);
		if (Board.getTotal(board) == 16) return true;
		int[] whiteAction;
		int[] blackAction;
		whiteAction = b.actionList(PLAYER_W);
		blackAction = b.actionList(PLAYER_B);
		
		if (whiteAction[0] > 0) return false;
		if (blackAction[0] > 0) return false;
		
		return true;
	}

	}

