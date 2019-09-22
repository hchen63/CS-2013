package gui;

import java.util.Stack;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.HBox;
import solver.MoveImpl;
import tictactoeFX.Game;
import tictactoeFX.Coordinate;

public class ButtonPane extends HBox{
	Button undo;
	Button redo;
	MoveImpl m;
	Character[][] board;
	TicTacToePane t;
	Coordinate c;

	
	
	public void setUpBtns() {
			undo = new Button("undo");
			redo = new Button("redo");

			setSpacing(8);
			setUpBtn();
			getChildren().addAll(undo, redo);
	}
	
	public void setUpBtn() {
		undo.setOnMouseClicked(new EventHandler<InputEvent>() {
			@Override
			public void handle(InputEvent arg0) {
				System.out.println("undo");
				
				if(Game.isEmpty()) {
					System.out.println("Can't undo");
				}
/*				else if(Game.boardFull()) {
					System.out.println(Game.xRowPush().peek());
					System.out.println(Game.xColPush().peek());
					int xR = Game.xRowPush().peek();
					int xC = Game.xColPush().peek();
					
					System.out.println("X row " + xR + " col " + xC);
					Game.undo();
					TicTacToePane.setLabel(xR, xC, " ");
				}
*/				else {
					System.out.println(Game.oRowPush());
					System.out.println(Game.oColPush());
					int oR = Game.oRowPush().peek();
					int oC = Game.oColPush().peek();
					
					System.out.println(Game.xRowPush().peek());
					System.out.println(Game.xColPush().peek());
					int xR = Game.xRowPush().peek();
					int xC = Game.xColPush().peek();

					System.out.println("O row " + oR + " col " + oC);
					System.out.println("X row " + xR + " col " + xC);
					Game.undo();
					TicTacToePane.setLabel(xR, xC, " ");
					TicTacToePane.setLabel(oR, oC, " ");
					
					
				}
			}	
		});
		redo.setOnMouseClicked(new EventHandler<InputEvent>() {
			@Override
			public void handle(InputEvent arg0) {
				System.out.println("redo");
				if(Game.boardFull()) {
					System.out.println("Can't redo");
				}else {
					System.out.println("pop " + Game.oRowPop().peek());
					System.out.println("pop " + Game.oColPop().peek());
					int oR = Game.oRowPop().peek();
					int oC = Game.oColPop().peek();
					
					System.out.println("pop " + Game.xRowPop().peek());
					System.out.println("pop " + Game.xColPop().peek());
					int xR = Game.xRowPop().peek();
					int xC = Game.xColPop().peek();
					
					System.out.println("O row " + oR + " col " + oC);
					System.out.println("X row " + xR + " col " + xC);
					TicTacToePane.setLabel(oR, oC, "O");
					TicTacToePane.setLabel(xR, xC, "X");
				}
		}
		});
	
	

	}
}	
