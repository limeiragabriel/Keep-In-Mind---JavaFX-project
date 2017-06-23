package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SidebarView {
	
	private static String location = "Sidebar.fxml";
	private static BorderPane sidebarLayout;

	public static void showView(BorderPane baseLayout, Stage primaryStage) throws IOException {
		
		loadLayout();
		baseLayout.setLeft(sidebarLayout);
		
	}
	
	private static void loadLayout() throws IOException{
		
		sidebarLayout = ResourcesLoader.loadFXML(sidebarLayout, location);
		
	}
	public static void loadToMain() throws IOException{
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource(location));
		loader.load();
		
	}


}
