package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginView{
	
	private static String location = "Login.fxml";
	private static BorderPane loginLayout;
	private static BorderPane popUpLoginError;
	private static String locationLoginError = "PopUpLogin.fxml";
	private static BorderPane popUpRegisterError;
	private static String locationRegisterError = "PopUpRegisterError.fxml";
	private static BorderPane popUpRegisterSuccess;
	private static String locationRegisterSuccess = "PopUpRegisterSuccess.fxml";
	
	public static void showView(BorderPane baseLayout, Stage primaryStage) throws IOException {
		loadLayout();
		baseLayout.setCenter(loginLayout);
		baseLayout.setLeft(null);
		
	}
	
	private static void loadLayout() throws IOException {
		loginLayout = ResourcesLoader.loadFXML(loginLayout, location);
		
	}
	
	public static void loadToMain() throws IOException{
		FXMLLoader loader = new FXMLLoader(Main.class.getResource(location));
		loader.load();
	}
	
	public static void showLoginErrorDialog(Stage primaryStage) throws IOException{
		popUpLoginError = ResourcesLoader.loadFXML(popUpLoginError, locationLoginError);
		PopUpView.setPopUp(primaryStage, popUpLoginError);
	}
	
	public static void showRegisterErrorDialog(Stage primaryStage) throws IOException{
		popUpRegisterError = ResourcesLoader.loadFXML(popUpRegisterError, locationRegisterError);
		PopUpView.setPopUp(primaryStage, popUpRegisterError);
	}
	
	public static void showRegisterSuccessDialog(Stage primaryStage) throws IOException{
		popUpRegisterSuccess = ResourcesLoader.loadFXML(popUpRegisterSuccess, locationRegisterSuccess);
		PopUpView.setPopUp(primaryStage, popUpRegisterSuccess);
	}
	
}
