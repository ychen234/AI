public class HMinimaxWithPruning{
	private int depth;
	private boolean max;
	private Board2 board;
	private int alpha;
	private int beta;
	private int row;
	private int column;
	private String[][] b1;
	private String color;
	private String player;
	private int[][] values = { 
		    {99, -5, 8, 3, 3, 8, -5, 99 }, 
		    {-5, -49, 1, 1, 1, 1, -49, -5 }, 
		    {8, 1, 3, 2, 2, 3, 1, 8 }, 
		    {3, 1, 2, 1, 1, 2, 1, 3 }, 
		    {3, 1, 2, 1, 1, 2, 1, 3 }, 
		    {8, 1, 3, 2, 2, 3, 1, 8 }, 
		    {-5,-49, 1, 1, 1, 1, -49, -5 }, 
		    {99, -5, 8, 3, 3, 8, -5, 99 } };

	
	public HMinimaxWithPruning(Board2 board, int depth, int alpha, int beta, String color, boolean max, String player){
		this.board = board;
		this.depth = depth;
		this.alpha = alpha;
		this.beta = beta;
		this.max = max;
		this.color = color;
		this.b1 = board.getBoard();
		this.player = player;
	}
	
	public int alphabeta(){
		if(depth == 0 || Board2.getTotal(b1) == 64){
			int score1 = 0;
			for (int i = 1; i < 9; i++) {
				for (int j = 1; j<9; j++){
					if (b1[i][j].equals(player)) {
						score1 += values[i-1][j-1];
					}else if (b1[i][j].equals(Board2.opponent(player))) {
						score1 -= values[i-1][j-1];
					}
				}
			}
			int score2 = evaluateSituation(b1);
			int score = 4 * score1 + 6 * score2; // calculating using weighted value 
			return score; 
		}
		else if(max){
			int value = -1000;
			int[] actionList = Board2.nextAction(this.b1, color);
			Board2[] children = new Board2[actionList[0]];
			int a = 0;

			for(int i = 1; i < 9; i++){
				for(int j = 1; j < 9; j++){
					if(board.isLegalState(i, j, color)){
						Board2 childBoard = new Board2(board); 
						children[a] = childBoard;
						children[a].put(i, j, color);
						HMinimaxWithPruning child = new HMinimaxWithPruning(children[a], this.depth - 1, this.alpha, this.beta, Board2.opponent(this.color), false, player);
						int childmax = child.alphabeta();
						a++;
						if(childmax > value){
							value = childmax;
							
						}
						if(value >= alpha){
							alpha = value;
							this.row = i;
							this.column = j;
						}
						if(alpha > beta){
							i = 10;
							j = 10;
						}
					}
				}
			}
			return value;
		}
		else{
			int value = 1000;
			int[] actionList = Board2.nextAction(this.b1, color);
			Board2[] children = new Board2[actionList[0]];
			int a = 0;
			for(int i = 1; i <9 ; i++){
				for(int j = 1; j<9; j++){
					if(board.isLegalState(i, j, color)){
						Board2 childBoard = new Board2(this.board); 
						children[a] = childBoard;
						children[a].put(i, j, color);
						HMinimaxWithPruning child = new HMinimaxWithPruning(children[a], this.depth - 1, this.alpha, this.beta, Board.opponent(this.color), true, player);
						int childmin = child.alphabeta();
						a++;
						if(childmin < value){
							value = childmin;
						}
						if(value < beta){
							beta = value;
						}
						if(alpha > beta){
							i = 10;
							j = 10;
						}
					}
				}
			}
			return value;
		}
	}
	
	public int getA(){
		return this.row;
	}
	public int getB(){
		return this.column;
	}
	
	 public int evaluateSituation(String[][] board) { //method for evaluate the neighbor of my placement of piece;
	    int availablePoint = 0;	//calculated by checking the number of moves you or your opponent can play up, down, left, right, up-left, up-right, down-left, down right 
	    						//after your move minus the number of your opponent's
	    							
	    for (int i = 1; i < 9; i++)
	      for (int j = 1; j < 9; j++) {
	        boolean canPut = false;
	        if (board[i][j].equals(player)){
	          if ((i > 1) && (board[(i - 1)][j].equals(" "))) {
	            canPut = true;
	          }else if ((i < 8) && (board[(i + 1)][j].equals(" "))) {
	            canPut = true;
	          }else if ((j > 1) && (board[i][(j - 1)].equals(" "))) {
	            canPut = true;
	          }else if ((j < 8) && (board[i][(j + 1)].equals(" "))) {
	            canPut = true;
	          }else   if ((i > 1) && (j > 1) && (board[(i - 1)][j - 1].equals(" "))) {
		        canPut = true;
		      }else if ((i < 8) && (j < 8) && (board[(i + 1)][j +1].equals(" "))) {
		        canPut = true;
		      }else if ((i < 8) && (j > 0) && (board[i+1][(j - 1)].equals(" "))) {
		        canPut = true;
		      }else if ((i > 1) && (j < 7) && (board[i][(j + 1)].equals(" "))) {
		        canPut = true;
		      }
	          if (canPut) {
	            availablePoint--;
	          }
	        } else {
		          if (!(board[i][j].equals(Board2.opponent(player)))) {
		            continue;
		          }
		          if ((i > 1) && (board[(i - 1)][j].equals(" "))) {
			            canPut = true;
			          }else if ((i < 8) && (board[(i + 1)][j].equals(" "))) {
			            canPut = true;
			          }else if ((j > 1) && (board[i][(j - 1)].equals(" "))) {
			            canPut = true;
			          }else if ((j < 8) && (board[i][(j + 1)].equals(" "))) {
			            canPut = true;
			          }else   if ((i > 1) && (j > 1) && (board[(i - 1)][j - 1].equals(" "))) {
				        canPut = true;
				      }else if ((i < 8) && (j < 8) && (board[(i + 1)][j +1].equals(" "))) {
				        canPut = true;
				      }else if ((i < 8) && (j > 0) && (board[i+1][(j - 1)].equals(" "))) {
				        canPut = true;
				      }else if ((i > 1) && (j < 7) && (board[i][(j + 1)].equals(" "))) {
				        canPut = true;
				      }
			          if (canPut) {
			            availablePoint++;
			          }
		        }
		      }
		    	return availablePoint;
		  }
	
	
}
	
