package application;
	
import gui.TicTacToePane;
import gui.ButtonPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tictactoeFX.Game;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TicTacToePane t = new TicTacToePane();
			ButtonPane b = new ButtonPane();
			
			VBox root = new VBox(10);
			root.setPadding(new Insets(10, 10, 10, 10));
			root.getChildren().addAll(t,b);
			
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add("application/application.css");
			primaryStage.setTitle("TicTacToe");
			primaryStage.setScene(scene);
			primaryStage.show();
			b.setUpBtns();
			t.startGame();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}