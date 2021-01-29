
public class SimpleMinimax {
	
	private boolean maximize;
	private Board board;
	private int row;
	private int column;
	private String[][] b1;
	private String color;
	private String player;

	
	public SimpleMinimax(Board board, String color, boolean maximize, String player){
		this.board = board;
		this.maximize = maximize;
		this.color = color;
		this.b1 = board.getBoard();
		this.player = player;
	}
	
	public int minimax(){
		if(Board.getTotal(b1) == 16){
			return this.board.getScore(this.player, b1); 
		}
		else if(maximize){
			int v = -1000;
			int[] actionList = Board.nextAction(this.b1, color);
			Board[] children = new Board[actionList[0]];
			int a = 0;
			for(int i = 1; i < 5; i++){
				for(int j = 1; j < 5; j++){
					if(board.isLegalState(i, j, color)){
						Board childBoard = new Board(board); 
						children[a] = childBoard;
						children[a].put(i, j, color);
						SimpleMinimax child = new SimpleMinimax(children[a], Board.opponent(this.color), false, player);
						int childmax = child.minimax();
						a++;
						if(childmax >= v){
							v = childmax;
							this.row = i;
							this.column = j;
						}
						
					}
				}
			}
			return v;
		}
		else{
			int v = 1000;
			int[] actionList = Board.nextAction(this.b1, color);
			Board[] children = new Board[actionList[0]];
			int a = 0;
			for(int i = 1; i <5 ; i++){
				for(int j = 1; j<5; j++){
					if(board.isLegalState(i, j, color)){
						Board childBoard = new Board(this.board); 
						children[a] = childBoard;
						children[a].put(i, j, color);
						SimpleMinimax child = new SimpleMinimax(children[a], Board.opponent(this.color), true, player);
						int childmin = child.minimax();
						a++;
						if(childmin < v){
							v = childmin;
						}
						
					}
				}
			}
			return v;
		}
	}
	
	public int getA(){
		return this.row;
	}
	public int getB(){
		return this.column;
	}
	
	
}
