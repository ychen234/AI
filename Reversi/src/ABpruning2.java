
public class ABpruning2{
	private Board2 board;
	private String[][] b1;
	private String color;
	private String player;
	private boolean maximizer;
	private int alpha;
	private int beta;
	private int row;
	private int column;
	private int depth;
	
	public ABpruning2(Board2 board, int depth, int alpha, int beta, String color, boolean maximizer, String player){
		this.board = board;
		this.depth = depth;
		this.alpha = alpha;
		this.beta = beta;
		this.maximizer = maximizer;
		this.color = color;
		this.b1 = board.getBoard();
		this.player = player;
	}
	
	public int alphabetapruning(){
		if(depth == 0 || Board2.getTotal(b1) == 64){
			return this.board.getScore(this.player, b1); 
		}
		else if(maximizer){
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
						ABpruning2 child = new ABpruning2(children[a], this.depth - 1, this.alpha, this.beta, Board2.opponent(this.color), false, player);
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
						ABpruning2 child = new ABpruning2(children[a], this.depth - 1, this.alpha, this.beta, Board.opponent(this.color), true, player);
						int childmin = child.alphabetapruning();
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
	
	
}
	
