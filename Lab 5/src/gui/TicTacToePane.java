package gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import tictactoeFX.Coordinate;
import tictactoeFX.Game;
import tictactoeFX.Game.Turn;

public class TicTacToePane extends GridPane {
	static Label[][] labels;
	Game g;
	Coordinate c;
	
	
	
	public void startGame() {
		setUpLabels();
		g = new Game();
	}
	
	private void setUpLabels() {
		labels = new Label[3][3];

		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++) {
				Label l = new Label();
				setUpLabel(l, row, col);				
				labels[row][col] = l;
				add(l, col, row);
			}
	}
	
	
	
	private void setUpLabel(Label l,int row, int col) {
		l.setPrefHeight(75);
		l.setPrefWidth(75);
		if (row < 2) {
			if (col > 0)
				l.getStyleClass().add("leftAndBottomBorder");
			else
				l.getStyleClass().add("bottomBorder");
		} else if (col > 0)
			l.getStyleClass().add("leftBorder");
		l.setOnMouseClicked(new EventHandler<InputEvent>() {
			@Override
			public void handle(InputEvent arg0) {
//				if(!g.gameOver()) g.push();
		
				if (!g.gameOver() && g.getTurn() == Turn.X) {					
					if(g.makePlayerMove(row, col)) {
						if(!g.isEmpty()) g.xPush();
						l.setText("X");
					}
					
				}
				if (!g.gameOver()&& g.getTurn() == Turn.O) {
					c = g.makeAutoMove();
					
					labels[c.getRow()][c.getCol()].setText("O");
					if(!g.isEmpty()) g.oPush();
				}
				if (g.gameOver()) {
					if (g.getVictoryExists()) {
						Coordinate[] victoryCoords = g.getVictoryCoords();
						for (Coordinate c : victoryCoords)
							labels[c.getRow()][c.getCol()].getStyleClass().add(
									"victory");
					}
				}
			}
		});
	}
	
	public static void setLabel(int row, int col, String txt) {
		labels[row][col].setText(txt);
	}
	
}