
public class ABpruning{
	private Board board;
	private int alpha;
	private int beta;
	private int row;
	private int column;	
	private int depth;
	private boolean max;
	private String[][] b1;
	private String color;
	private String player;

	
	public ABpruning(Board board, int depth, int alpha, int beta, String color, boolean max, String player){
		this.board = board;
		this.depth = depth;
		this.alpha = alpha;
		this.beta = beta;
		this.max = max;
		this.color = color;
		this.b1 = board.getBoard();
		this.player = player;
	}
	
	public int alphabetapruning(){
		if(depth == 0 || Board.getTotal(b1) == 16){
			return this.board.getScore(this.player, b1); 
		}
		else if(max){
			int value = -1000;
			int[] actionList = Board.nextAction(this.b1, color);
			Board[] children = new Board[actionList[0]];
			int a = 0;
			for(int i = 1; i < 5; i++){
				for(int j = 1; j < 5; j++){
					if(board.isLegalState(i, j, color)){
						Board childBoard = new Board(board); 
						children[a] = childBoard;
						children[a].put(i, j, color);
						ABpruning child = new ABpruning(children[a], this.depth - 1, this.alpha, this.beta, Board.opponent(this.color), false, player);
						int childmax = child.alphabetapruning();
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
								i = 6;
								j = 6;
							}
					}
				}
			}
			return value;
		}
		else{
			int value = 1000;
			int[] actionList = Board.nextAction(this.b1, color);
			Board[] children = new Board[actionList[0]];
			int a = 0;
			
			for(int i = 1; i <5 ; i++){
				for(int j = 1; j<5; j++){
					if(board.isLegalState(i, j, color)){
						Board childBoard = new Board(this.board); 
						children[a] = childBoard;
						children[a].put(i, j, color);
						ABpruning child = new ABpruning(children[a], this.depth - 1, this.alpha, this.beta, Board.opponent(this.color), true, player);
						int childmin = child.alphabetapruning();
						a++;
							if(childmin < value){
								value = childmin;
							}
							if(value < beta){
								beta = value;
							}
							if(alpha > beta){
								i = 6;
								j = 6;
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
	
	
}
	
	
