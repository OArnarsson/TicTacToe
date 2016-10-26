package ttt;

import java.util.Random;
import java.util.Arrays;

public class TicTacToe {

	//Holds the board information.
	public Board board;

	//Initializes the game board.
	public TicTacToe() {
		board = new Board();
	}

	//Prints out the game board.
	public void printBoard() {
		for(int i=0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board.cells[i][j].getValue() == "")
					System.out.print(" ");

				System.out.print(board.cells[i][j].getValue() + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	//Updates the game board with given character.
	public void updateBoard(int row, int col, String mark) {
		board.cells[row][col].setValue(mark);
	}

	//Inserts 'X' for manually chosen integer.
	public boolean humanPlayer(int pos) {
			if(board.updateCell(convertToRow(pos), convertToCol(pos), true)) {
				return true;
			}
			return false;
	}

	public int convertToRow(int input) {
		return ((input-1)/3);
	}

	public int convertToCol(int input) {
		return ((input-1)%3);
	}

	//Picks a random input between 1-9.
	public int randomInput() {
		Random rand = new Random();
		return (rand.nextInt(9));
	}

	//Inserts 'O' for automatically chosen integer.
	public void computerPlayer() {
			int pos = randomInput();
			while(!board.updateCell(convertToRow(pos), convertToCol(pos), false)) {
				pos = randomInput();
			}

			System.out.println("Computer picked: " + pos);
	}

	//Checks to see if the game has already been won.
	public boolean gameOver() {
		return board.gameOver();
	}

	//Seperates each integer in the string
	public String[] split(String input){
  		return input.split(" ");
	}

	public void play(String input){
		int counter = 0;
		boolean validPlayer = false;
		boolean validComputer = false;
		String[] inputInts = split(input);

		printBoard();

		do {
			while(!validPlayer) {
				for(int i = 0; i < inputInts.length; i++) {
					validPlayer = humanPlayer(Integer.parseInt(inputInts[i]));

					if(validPlayer)
						break;
				}
			}
			counter++;
			printBoard();

			if(gameOver())
				break;

			computerPlayer();
			printBoard();
			counter++;
			validPlayer = false;
			validComputer = false;
		} while(!gameOver() && counter < 9);

		if(counter >= 9 && !gameOver())
			System.out.println("It's a tie!");

		if(counter%2 == 0)
			System.out.println("Oh man, the computer beat you!");

		else
			System.out.println("Wow, you beat the random computer.. great.");
	}

	public static void main(String[] args) {
		System.out.println("Synergy welcomes you to TicTacToe!\n");

		TicTacToe TTT = new TicTacToe();
		TTT.play("1 2 3 4 5 5 6 7 8 9");
	}
}
