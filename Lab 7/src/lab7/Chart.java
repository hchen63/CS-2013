package lab7;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.Group;
 
public class Chart extends Application {
	Extractor e = new Extractor();
	
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Word Frequency");
        stage.setWidth(500);
        stage.setHeight(500);
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.<PieChart.Data>observableArrayList();
        for( int i=0; i < e.aList.size(); i++ ) {
            pieChartData.add(new PieChart.Data(e.getWord(i), e.frequencies.get(e.getWord(i))));
        }	

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Word Frequency");      
        
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
      launch(args);
    }
}