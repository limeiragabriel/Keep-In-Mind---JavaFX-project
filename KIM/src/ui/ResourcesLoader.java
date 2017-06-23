package ui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class ResourcesLoader {
	
	public static BorderPane loadFXML(BorderPane layout, String location) throws IOException{
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(location));
		layout = loader.load();
		return layout;
	
	}
	
	
}
