package ttt;

import java.util.Random;

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

	public void updateBoard(int pos, char mark) {
		board = board.replaceAll(String.valueOf(pos), String.valueOf(mark));
	}

	public boolean humanPlayer(int pos) {
			askForInput();
			if(validateInput(pos)) {
				updateBoard(pos, 'X');
				return true;
			}
			return false;
	}

	public int randomInput() {
		Random rand = new Random();
		return (rand.nextInt(9));
	}

	public boolean computerPlayer() {
			int pos = randomInput();
			if(validateInput(pos)) {
				updateBoard(pos, 'O');
				return true;
			}
			return false;
	}


	public static void main(String[] args) {
		TicTacToe TTT = new TicTacToe();
		System.out.println("Synergy welcomes you to TicTacToe!");

		TTT.printBoard();
	}
}
