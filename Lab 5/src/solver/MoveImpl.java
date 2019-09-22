package solver;

import java.util.Stack;

import tictactoeFX.Coordinate;
import tictactoeFX.Game;
import tictactoeFX.Game.Turn;

public class MoveImpl implements Move{
	SolverImpl s;
	Game g;
	Coordinate c;
	static String[][] board;

	@Override
	public int getRow() {
//		int row = g.oRowPush().peek();
		return c.getRow();
	}

	@Override
	public int getCol() {
		return c.getCol();
	}

	@Override
	public Turn getPlayer() {
		return g.getTurn();
	}

}