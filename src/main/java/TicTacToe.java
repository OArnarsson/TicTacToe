package ttt;

import java.util.Random;

public class TicTacToe {

	private String board;

	//Initializes the game board.
	public TicTacToe() {
		board = "123456789";
	}

	//Prints out the game board.
	public void printBoard() {
		for(int i=0; i<3; i++) {
			System.out.print(board.charAt(i*3) + " "
					   	   + board.charAt(i*3+1) +" "
					   	   + board.charAt(i*3+2)+ "\n");
		}
		System.out.print("\n");
	}

	//Makes sure no invalid inputs get into the updateBoard function.
	public boolean validateInput(int pos) {
		if(pos > 9 || pos < 1 || !board.contains(Integer.toString(pos)))
			return false;
		return true;
	}

	//Prints out message to user.
	public void askForInput() {
		System.out.print("Please enter a number between 1 and 9\n");
	}

	//Updates the game board with given character.
	public void updateBoard(int pos, char mark) {
		board = board.replaceAll(String.valueOf(pos), String.valueOf(mark));
	}

	//Inserts 'X' for manually chosen integer.
	public boolean humanPlayer(int pos) {
			if(validateInput(pos)) {
				updateBoard(pos, 'X');
				return true;
			}
			return false;
	}

	//Picks a random input between 1-9.
	public int randomInput() {
		Random rand = new Random();
		return (rand.nextInt(9));
	}

	//Inserts 'O' for automatically chosen integer.
	public void computerPlayer() {
			int pos = randomInput();
			while(!validateInput(pos)) {
				pos = randomInput();
			}

			System.out.println("Computer picked: " + pos);
			updateBoard(pos, 'O');
	}

	//Checks to see if the game has already been won.
	public boolean gameOver() {
		for(int i=0; i<3; i++) {
			//Vertical check
			if(board.charAt(i * 3) == board.charAt(i * 3 + 1) && board.charAt(i * 3 + 1) == board.charAt(i * 3 + 2))
				return true;

			//Horziontal check
			if(board.charAt(i) == board.charAt(i + 3) && board.charAt(i + 3) == board.charAt(i + 6))
				return true;
		}

		//Crosschecks
		if(board.charAt(0) == board.charAt(4) && board.charAt(4) == board.charAt(8))
			return true;
		if(board.charAt(2) == board.charAt(4) && board.charAt(4) == board.charAt(6))
			return true;

		return false;
	}

	//Seperates each integer in the string
	public String[] split(String input){
  		return input.split(" ");
	}



	public static void main(String[] args) {
		System.out.println("Synergy welcomes you to TicTacToe!\n");
	}
}
