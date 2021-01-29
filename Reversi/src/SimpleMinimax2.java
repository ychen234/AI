
public class SimpleMinimax2 {
	
	private boolean maximize;
	private Board2 board;
	private int row;
	private int column;
	private String[][] b1;
	private String color;
	private String player;

	
	public SimpleMinimax2(Board2 board, String color, boolean maximize, String player){
		this.board = board;
		this.maximize = maximize;
		this.color = color;
		this.b1 = board.getBoard();
		this.player = player;
	}
	
	public int minimax(){
		if(Board.getTotal(b1) == 64){
			return this.board.getScore(this.player, b1); 
		}
		else if(maximize){
			int v = -1000;
			int[] actionList = Board2.nextAction(this.b1, color);
			Board2[] children = new Board2[actionList[0]];
			int a = 0;
			for(int i = 1; i < 9; i++){
				for(int j = 1; j < 9; j++){
					if(board.isLegalState(i, j, color)){
						Board2 childBoard = new Board2(board); 
						children[a] = childBoard;
						children[a].put(i, j, color);
						SimpleMinimax2 child = new SimpleMinimax2(children[a], Board2.opponent(this.color), false, player);
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
			int[] actionList = Board2.nextAction(this.b1, color);
			Board2[] children = new Board2[actionList[0]];
			int a = 0;
			for(int i = 1; i <9 ; i++){
				for(int j = 1; j<9; j++){
					if(board.isLegalState(i, j, color)){
						Board2 childBoard = new Board2(this.board); 
						children[a] = childBoard;
						children[a].put(i, j, color);
						SimpleMinimax2 child = new SimpleMinimax2(children[a], Board2.opponent(this.color), true, player);
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
