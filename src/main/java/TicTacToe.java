package ttt;

public class TicTacToe {

	private String board;

	public TicTacToe() {
		board = "123456789";
	}

	public void printBoard() {
		for(int i=0; i<3; i++) {
			System.out.print(board.charAt(i*3) + " "
					   	   + board.charAt(i*3+1) +" "
					   	   + board.charAt(i*3+2)+ "\n");
		}
	}

	public boolean validateInput(int pos) {
		if(pos > 9 || pos < 1 || !board.contains(Integer.toString(pos)))
			return false;

		return true;
	}

	public void askForInput() {
		System.out.print("Please enter a number between 1 and 9\n");
	}

	public void updateBoard(int pos) {
		board = board.replaceAll(String.valueOf(pos), "X");
	}


	public static void main(String[] args) {
		System.out.println("Synergy welcomes you to TicTacToe!");
	}
}
