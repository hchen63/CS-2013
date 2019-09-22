package solver;

import java.util.Random;

import tictactoeFX.Coordinate;
import tictactoeFX.Game;
import tictactoeFX.Game.Turn;

public class SolverImpl implements TicTacToeSolver {
	Coordinate[] victoryCoords;
	
	@Override
	public Coordinate getMove(char p, Turn turn, Character[][] board) {
		Character[][] newBoard;

		// if a one-move victory is available, choose the move
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				newBoard = copyBoard(board);
				if (newBoard[row][col] == ' ') {
					newBoard[row][col] = p;
					if (checkForVictory(p, newBoard))
						return new Coordinate(row, col);
				}
			}
		}

		if (p == 'O')
			p = 'X';
		else
			p = 'O';

		// if the enemy can win in one move, block the move
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				newBoard = copyBoard(board);
				if (newBoard[row][col] == ' ') {
					newBoard[row][col] = p;
					if (checkForVictory(p, newBoard))
						return new Coordinate(row, col);
				}
			}
		}

		// take the center square if available
		if (board[1][1] == ' ')
			return new Coordinate(1, 1);

		// random Corner Num
		Random rand = new Random();
		int minC = 0;
		int maxC = 1;	
		int randCorRow = (int) rand.nextInt((maxC - minC) + 1) + minC;
		int randCorCol = (int) rand.nextInt((maxC - minC) + 1) + minC;

		// take a corner if available
		int[] begEnd = { 0, 2 };
		
		if (board[begEnd[randCorRow]][begEnd[randCorCol]] == ' ')
			return new Coordinate(begEnd[randCorRow], begEnd[randCorCol]);
		
		while(board[begEnd[randCorRow]][begEnd[randCorCol]] != ' ') {
			randCorRow =  (int) rand.nextInt((maxC - minC) + 1) + minC;
			randCorCol =  (int) rand.nextInt((maxC - minC) + 1) + minC;
			if (board[begEnd[randCorRow]][begEnd[randCorCol]] == ' ')
				return new Coordinate(begEnd[randCorRow], begEnd[randCorCol]);
		}
		
		// random side number
		int minS = 0;
		int maxS = 2;	
		int randSideRow =  (int) rand.nextInt((maxS - minS) + 1) + minS;
		int randSideCol =  (int) rand.nextInt((maxS - minS) + 1) + minS;
		
		if (board[randSideRow][randSideCol] == ' ')
			return new Coordinate(randSideRow,randSideCol);
		
		while(board[randSideRow][randSideCol] != ' ') {
			randSideRow =  (int) rand.nextInt((maxS - minS) + 1) + minS;
			randSideCol =  (int) rand.nextInt((maxS - minS) + 1) + minS;
			if (board[randSideRow][randSideCol] == ' ')
				return new Coordinate(randSideRow,randSideCol);
		}
			
	// if board is full
		return null;
	}

	private Character[][] copyBoard(Character[][] board) {
		int numRows = board.length;
		int numCols = board[0].length;
		Character[][] newBoard = new Character[numRows][numCols];
		for (int row = 0; row < numRows; row++)
			for (int col = 0; col < numCols; col++)
				newBoard[row][col] = new Character(board[row][col]);
		return newBoard;
	}
	
	private boolean checkForRowVictory(char p, Character[][] board) {
		for (int row = 0; row < 3; row++)
			if (board[row][0] == p && board[row][1] == p && board[row][2] == p) {
				victoryCoords = new Coordinate[] { new Coordinate(row, 0),
						new Coordinate(row, 1), new Coordinate(row, 2) };
				return true;
			}
		return false;
	}

	private boolean checkForColVictory(char p, Character[][] board) {

		for (int col = 0; col < 3; col++)
			if (board[0][col] == p && board[1][col] == p && board[2][col] == p) {
				victoryCoords = new Coordinate[]{new Coordinate(0, col), new Coordinate(1, col), new Coordinate(2, col)};

				return true;
			}
		return false;
	}

	private boolean checkForDiagonalVictory(char p, Character[][] board) {
		if (board[1][1] != p)
			return false;
		if (board[0][0] == p && board[2][2] == p){
			victoryCoords = new Coordinate[] {new Coordinate(0, 0), new Coordinate(1, 1), new Coordinate(2, 2)};
			return true;
		}
		if(board[0][2] == p && board[2][0] == p) {
			victoryCoords = new Coordinate[] {new Coordinate(0, 2), new Coordinate(1, 1), new Coordinate(2, 0)};
			
			return true;
		}
		return false;
	}

	public boolean checkForVictory(char p, Character[][] board) {
		
		if (checkForRowVictory(p, board) || checkForColVictory(p, board)
				|| checkForDiagonalVictory(p, board))
			return true;
		return false;
	}

	@Override
	public Coordinate[] getVictoryCoords() {
		
		return victoryCoords;
	}
}
