package tictactoeFX;

import java.util.Stack;

import solver.SolverImpl;
import solver.TicTacToeSolver;

public class Game {
	private TicTacToeSolver oPlayer;
	boolean victoryExists = false;
	static Stack<Integer> oRow = new Stack<Integer>(); 
	static Stack<Integer> oCol= new Stack<Integer>(); 
	static Stack<Integer> oRowPop= new Stack<Integer>(); 
	static Stack<Integer> oColPop= new Stack<Integer>(); 
	static Stack<Integer> xRow = new Stack<Integer>(); 
	static Stack<Integer> xCol= new Stack<Integer>(); 
	static Stack<Integer> xRowPop= new Stack<Integer>(); 
	static Stack<Integer> xColPop= new Stack<Integer>();

	public enum Turn {
		X, O
	};

	private Turn turn;
	
	private static Character[][] board;

	public Game() {
		oPlayer = new SolverImpl();
		turn = Turn.X;
		board = new Character[3][3];
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				board[row][col] = ' ';
	}

	public boolean makePlayerMove(int row, int col) {
		if (board[row][col] == ' ') {
			board[row][col] = 'X';
			xPush();
			turn = Turn.O;
			return true;
		}
		return false;
	}
	
	public void xPush() {
		xRow = xRowPush();
		xCol = xColPush();
	}
	
	public void oPush() {
		oRow = oRowPush();
		oCol = oColPush();
	}

	public Coordinate makeAutoMove() {
		Coordinate oSquare = oPlayer.getMove('O', turn, board);
		int row = oSquare.getRow();
		int col = oSquare.getCol();
		board[row][col] = 'O';
		oPush();
		if (!oPlayer.checkForVictory('O', board)) {
			turn = Turn.X;
		}
		return oSquare;
	}

	public static boolean boardFull() {
		for (int rowCounter = 0; rowCounter < board.length; rowCounter++)
			for (int colCounter = 0; colCounter < board[0].length; colCounter++)
				if (board[rowCounter][colCounter] == ' ')
					return false;
		return true;
	}

	public boolean gameOver() {
		if (oPlayer.checkForVictory('O', board) || oPlayer.checkForVictory('X', board)) {
			victoryExists = true;
			return true;
		}
		if (boardFull())
			return true;
		return false;

	}

	public boolean getVictoryExists() {
		return victoryExists;
	}

	public Coordinate[] getVictoryCoords() {
		return oPlayer.getVictoryCoords();
	}

	public Turn getTurn() {
		return turn;
	}
	
	public static Stack<Integer> oRowPush() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == 'O') {
					Integer mRow = Integer.valueOf(row);				
					oRow.push(mRow);
					return  oRow;
				}
			}
		}
		return null;
	}
	
	public static Stack<Integer> oColPush() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == 'O') {
					Integer mCol = Integer.valueOf(col);
					oCol.push(mCol);
					return  oCol;
				}
			}
		}
		return null;
	}
	public static Stack<Integer> xRowPush() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == 'X') {
					Integer mRow = Integer.valueOf(row);				
					xRow.push(mRow);
					return  xRow;
				}
			}
		}
		return null;
	}
	
	public static Stack<Integer> xColPush() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == 'X') {
					Integer mCol = Integer.valueOf(col);
					xCol.push(mCol);
					return  xCol;
				}
			}
		}
		return null;
	}
	
	public static void undo() {
		int oR = oRow.peek();
		int oC = oCol.peek();
		int xR = xRow.peek();
		int xC = xCol.peek();
		board[oR][oC] = ' ';
		board[xR][xC] = ' ';
	}
	
	public static Stack<Integer> oRowPop() {
		Integer y = (Integer) oRow.pop(); 	
        oRowPop.push(y);
		return oRowPop;
	}
	
	public static Stack<Integer> oColPop() {
		 Integer y = (Integer) oCol.pop(); 
		 oColPop.push(y);
		return oColPop;
	}
	
	public static Stack<Integer> xRowPop() {
		Integer y = (Integer) xRow.pop(); 	  
        xRowPop.push(y);
		return xRowPop;
	}
	
	public static Stack<Integer> xColPop() {
		 Integer y = (Integer) xCol.pop();  
		 xColPop.push(y);
		return xColPop;
	}

	public static void redo() {
		int oR = oRowPop.peek();
		int oC = oColPop.peek();
		int xR = xRowPop.peek();
		int xC = xColPop.peek();
		board[oR][oC] = 'O';
		board[xR][xC] = 'X';
	}
	
	public static boolean isEmpty() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				while(board[row][col] != ' ') {						
					return false;
				}
			}
		}
		return true;
	}
}
