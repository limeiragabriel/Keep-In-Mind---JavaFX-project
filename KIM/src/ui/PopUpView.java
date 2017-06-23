package ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpView {
	
	public static void setPopUp(Stage primaryStage, BorderPane popUp){
		
		final Stage dialog = new Stage();
		dialog.setResizable(false);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        Scene dialogScene = new Scene(popUp);
        dialog.setScene(dialogScene);
        dialog.show();
	}
	
}
