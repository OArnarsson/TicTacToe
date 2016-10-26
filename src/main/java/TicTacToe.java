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

	public void askForInput() {
		System.out.print("Please enter a number between 1 and 9\n");
	}

	public static void main(String[] args) {

		System.out.println("Synergy welcomes you to TicTacToe!");
	}
}
