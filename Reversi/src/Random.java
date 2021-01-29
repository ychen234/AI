
public class Random {
	public Board board;
	public String color;
	public static final String NO_PLAYER = " "; //Blank
	public static final String PLAYER_B = "X"; //Black piece
	public static final String PLAYER_W = "O"; //White piece
	
	
	public Random(String color) {
		this.color = color;
		this.board = new Board();
	}
	
	public Random(String[][] board, String color) {
		this.color = color;
		this.board = new Board(board);
	}
	
	public void setBoard(String[][] board) {
		this.board = new Board(board);
	}
	
	public int randomAction() {
		int[] list = board.actionList(color);
		int action;
		if(list[0]>0) {
			if (list[0] == 1) {
				action = list[1];
			}else {
				action = list[(int) ((Math.random())*list[0]) + 1];
			}
			board.put(action/4 + 1, action % 4 + 1 , color);
			return action;
		}
		return -1;
	}
	
	
	
}
