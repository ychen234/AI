public class Random2 {
	public Board2 board;
	public String color;
	public static final String NO_PLAYER = " "; //Blank
	public static final String PLAYER_B = "X"; //Black piece
	public static final String PLAYER_W = "O"; //White piece
	
	
	public Random2(String color) {
		this.color = color;
		this.board = new Board2();
	}
	
	public Random2(String[][] board, String color) {
		this.color = color;
		this.board = new Board2(board);
	}
	
	public void setBoard(String[][] board) {
		this.board = new Board2(board);
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
			board.put(action/8 + 1, action % 8 + 1 , color);
			return action;
		}
		return -1;
	}
	

	
	
}