package ui;

import java.io.IOException;
import java.util.ResourceBundle.Control;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NotesView{
	
	private static String location = "Notes.fxml";
	private static BorderPane notesLayout;
	private static BorderPane addNoteLayout;
	private static String addocation = "AddNote.fxml";
	private static Pane note;
	private static String noteLocation = "NoteObject.fxml";
	private static BorderPane noteError;
	private static String errorlocation = "PopUpError.fxml";
	
	public static void showView(BorderPane baseLayout, Stage primaryStage) throws IOException {
		
		loadLayout();
		baseLayout.setCenter(notesLayout);
		
	}
	
	private static void loadLayout() throws IOException{
		
		notesLayout = ResourcesLoader.loadFXML(notesLayout, location);
		
	}
	
	public static void loadToMain() throws IOException{
		FXMLLoader loader = new FXMLLoader(Main.class.getResource(location));
		loader.load();
	}
	
	public static void showNotesErrorDialog(Stage primaryStage) throws IOException{
		noteError = ResourcesLoader.loadFXML(noteError, errorlocation);
		PopUpView.setPopUp(primaryStage, noteError);
	}
	
}
