package ttt;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

	//Holds the board information.
	public String board;

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
		System.out.print("___________________________________________________________________\n");
	}

	//Makes sure no invalid inputs get into the updateBoard function.
	public boolean validateInput(int pos) {
		if(pos > 9 || pos < 1) {
			inputOutOfRange();
			return false;
		}

		if(!board.contains(String.valueOf(pos))) {
			inputInvalid();
			return false;
		}

		return true;
	}

	//Prints out message to user.
	public void askForInput() {
		System.out.print("Please enter a number between 1 and 9.\n");
	}

	//Prints out message to user.
	public void inputOutOfRange() {
		System.out.print("The number you entered was out of range.\n");
	}

	//Prints out message to user.
	public void inputInvalid() {
		System.out.print("The number you entered was not available.\n");
	}

	//Updates the game board with given character.
	public void updateBoard(int pos, char mark) {
		board = board.replaceAll(String.valueOf(pos), String.valueOf(mark));
	}

	//Inserts 'X' for manually chosen integer.
	public void humanPlayer(char mark) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		if(!validateInput(input)) {
			humanPlayer(mark);
		}
		else {
			System.out.println();
			if(mark == 'X')
				System.out.println("Player 1 put '" + mark + "' in cell #" + input);

			else
				System.out.println("Player 2 put '" + mark + "' in cell #" + input);

			updateBoard(input, mark);
		}

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

	public void play(){
		int counter = 0;

		printBoard();

		do {
			askForInput();
			humanPlayer('X');
			counter++;

			if(counter >= 9)
				break;

			printBoard();

			if(gameOver())
				break;

			humanPlayer('O');
			printBoard();
			counter++;
		} while(!gameOver() && counter != 9);

		if(counter == 9)
			System.out.println("It's a tie!");

		else if(counter % 2 == 0)
			System.out.println("Player 2 is the winner!");

		else
			System.out.println("Player 1 is the winner!");

			printBoard();
	}

	public static void main(String[] args) {

		TicTacToe TTT = new TicTacToe();
		TTT.play();

	}
}
