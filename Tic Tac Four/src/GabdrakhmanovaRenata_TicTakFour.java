import java.util.*;

public class GabdrakhmanovaRenata_TicTakFour {
	/*
	 * Renata Gabdrakhmanova
	 * Pd 3
	 * 10/14/20
	 * 
	 * TicTacFour- 
	 * -contains a matrix of 2 different char values 'X' and 'O'. -There is no user input in this program
	 * -The functions should check if a player placed their piece in all 4 corners/ in every spot of the same row
	 * in every spot of the same column/ in same spot of the main diagonal(backward or forward)
	 * in every spot within the same quadrant(top-left, top-right, bottom-left, bottom-right.
	 * -Should check both pieces X and O, if X and O are both false or true then its a tie
	 * -If one of them is false the one that is true won
	 * 
	 */

	//calls the hasWon function to see in X or O won, then prints out if someone won or if its a tie 
	public static void main(String[] args) {

		char[][] board = { { 'X', 'O', 'X', 'O' }, 
				           { 'O', 'X', 'X', 'X' }, 
				           { 'X', 'O', 'O', 'X' },
				           { 'O', 'X', 'X', 'O' } };

		boolean Xwon;
		boolean Owon;

		char target = 'X';
		Xwon = hasWon(board, target);

		target = 'O';
		Owon = hasWon(board, target);

		if (Owon == true && Xwon == false)
			System.out.println("O won!");

		if (Owon == Xwon)
			System.out.println("It's a tie!");

		if (Xwon == true && Owon == false)
			System.out.println("X won!");

	}

	//calls other functions to check different places on the board. If the function returns true then one of the pieces won, if not then returns false
	public static boolean hasWon(char[][] board, char target) {

		if (checkCorners(board, target) == true)
			return true;

		for (int row = 0; row < board.length; row++) {//each time passes new row to check all the rows
			if (checkRow(board, row, target) == true)
				return true;
		}

		for (int col = 0; col < board.length; col++) {//each time passes new column to check all the columns
			if (checkCol(board, col, target) == true)
				return true;
		}

		if (checkForwardDiag(board, target) == true)
			return true;

		if (checkBackDiag(board, target) == true)
			return true;

		if (allQuads(board, target) == true)
			return true;

		return false;
	}

	//checks all the corners of the board if one of the corners is not the char we are looking for then return false, 
	//if all of the corners are the same char then return true
	public static boolean checkCorners(char[][] board, char target) {
		int len = board.length - 1;

		if (board[0][0] != target)
			return false;

		if (board[0][len] != target)
			return false;

		if (board[len][0] != target)
			return false;

		if (board[len][len] != target)
			return false;

		return true;
	}

	//Checks each row, row is passed from a for-loop from hasWon to see each row
	//looks at one specific row and checks the values in each of the columns of that row
	//if one of them is not the assigned target then return false
	//if the row contains all the same target then return true
	public static boolean checkRow(char[][] board, int row, char target) {

		for (int col = 0; col < board[row].length; col++) {
			if (board[row][col] != target)
				return false;
		}

		return true;
	}

	//checks each column of the board/ col is passed from hasWon
	//checks each instance in a specific column
	//if one of them is not the assigned target, then return false
	//if the column matches the target then return true
	public static boolean checkCol(char[][] board, int col, char target) {

		for (int row = 0; row < board.length; row++) {
			if (board[row][col] != target)
				return false;
		}

		return true;
	}

	//checks the main diagonal of the board, from top-left to bottom-right
	//looks at each row and has the column eaqual the same as row to check the middle
	//if on of the chars didn't equal target then return false 
	//otherwise return true
	public static boolean checkForwardDiag(char[][] board, char target) {

		for (int row = 0; row < board.length; row++) {
			if (board[row][row] != target)
				return false;
		}

		return true;
	}

	//checks the main diagonal of the board, from bottom-left to top-right
	//the row would increase from 0 each time
	//the column will decrease from the length of the board to the 0
	//if one of the characters is not target then return false, there is no diagonal line of the same target
	//if all of the characters are the same as target, return true
	public static boolean checkBackDiag(char[][] board, char target) {
		int col = board.length;

		for (int row = 0; row < board.length; row++) {
			col--;
			if (board[row][col] != target)
				return false;
		}

		return true;
	}

	// rowOff and colOff represent the offset for where to start looking within the
	// board
	// for example if rowOff = 0 and colOff=0 then this wille examine the
	// top-leftquadrant

	public static boolean checkQuad(char[][] board, int rowOff, int colOff, char target) {
		int half = board.length / 2;

		for (int row = 0; row < half; row++) {
			for (int col = 0; col < half; col++) {

				if (board[row + rowOff][col + colOff] != target)
					return false;
			}
		}
		return true;
	}

	//checks each quadrant on the board, if one of the quadrants has the same chars as target then return true
	//if it checked all of the quadrants and none of them was true, then return false
	//each time before the function is called passes a new rowOff and colOff, which are the staring positions of the quadrants
	public static boolean allQuads(char[][] board, char target) {
		int half = board.length / 2;
		int rowOff = 0;
		int colOff = 0;

		if (checkQuad(board, rowOff, colOff, target) == true) {
			return true;

		}

		colOff = half;
		if (checkQuad(board, rowOff, colOff, target) == true) {
			return true;

		}

		rowOff = half;
		if (checkQuad(board, rowOff, colOff, target) == true) {
			return true;

		}

		colOff = 0;
		if (checkQuad(board, rowOff, colOff, target) == true) {
			return true;

		}
		return false;

	}

}
