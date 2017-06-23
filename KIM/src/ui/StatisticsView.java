package ui;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatisticsView{
	
	private static String location = "Statistics.fxml";
	private static BorderPane statisticsLayout;

	public static void showView(BorderPane baseLayout, Stage primaryStage) throws IOException {
		
		loadLayout();
		baseLayout.setCenter(statisticsLayout);
		
	}
	
	private static void loadLayout() throws IOException{
		
		statisticsLayout = ResourcesLoader.loadFXML(statisticsLayout, location);
		
	}
	public static void loadToMain() throws IOException{
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource(location));
		loader.load();
		
	}
	
	public static void showInfo(VBox box) throws SQLException{
		
		String coeffic;
		
		if(String.valueOf(Controle.calcularCoeficiente()).equals("NaN")){
			coeffic = "0.0 :(";
		}
		else{
			coeffic = String.valueOf(Controle.calcularCoeficiente());
		}
		
		Text coefficientText = new Text(coeffic);
		coefficientText.setLayoutX(0);
		coefficientText.setLayoutY(0);
		coefficientText.setScaleX(1);
		coefficientText.setScaleY(1);

		ImageView stars = new ImageView();
				
		int level = Controle.calcularNivel();
		
		if(level <= 1){
			stars.setImage(new Image("@/../images/oneStar.png"));
		}
		else if(level <= 2){
			stars.setImage(new Image("@/../images/twoStars.png"));
		}
		else if(level <= 3){
			stars.setImage(new Image("@/../images/threeStars.png"));
		}
		else if(level <= 4){
			stars.setImage(new Image("@/../images/fourStars.png"));
		}
		else{
			stars.setImage(new Image("@/../images/fiveStars.png"));
		}
	

		box.getChildren().addAll(coefficientText,stars);
		
	}

}
