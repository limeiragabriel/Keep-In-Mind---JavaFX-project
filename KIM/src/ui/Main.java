package ui;


import java.io.IOException;
import java.sql.SQLException;

import application.Tarefa;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	private static Stage primaryStage;
	private static BorderPane baseLayout = new BorderPane();
	
	public boolean canLogin = false;
	public boolean canRegister = false;
	// ============== inputs from login page ==============================
	@FXML TextField userName;
	@FXML PasswordField password;
	// ============== inputs from addNotes page ===========================
	@FXML TextField titleInput;
	@FXML TextArea textInput;
	// ============== notes page components ===============================
	@FXML VBox noteBox;
	// ================= statistics page components ========================
	@FXML VBox coefVBox;
	
	// =============== start the system ===================================
	@Override
	public void start(Stage primaryStage) throws IOException{
		
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Keep In Mind");
		primaryStage.setResizable(false);
		Scene scene = new Scene(baseLayout);
		primaryStage.setScene(scene);
		
		showLogin();

		primaryStage.show();
		
	}
	
	
	public void enterSys() throws IOException{
		
		LoginView.loadToMain();
		
		if(Controle.logar(userName.getText(), password.getText())){
			canLogin = true;
		}
		
		if (canLogin){
			NotesView.showView(baseLayout, primaryStage);
			showSidebar();
		}
		else{
			LoginView.showLoginErrorDialog(primaryStage);
		}
	}
	
	public void register() throws IOException{
		
		if(Controle.criarUsuario(userName.getText(), password.getText())){
			canRegister = true;
		}
		
		if(canRegister){
			LoginView.showRegisterSuccessDialog(primaryStage);
		}
		else{
			LoginView.showRegisterErrorDialog(primaryStage);
		}
	}
	
	public void showLogin() throws IOException{

		LoginView.showView(baseLayout, primaryStage);
		canLogin = false;
		canRegister = false;
		
	}
	
	public void showSidebar() throws IOException{
		SidebarView.showView(baseLayout, primaryStage);
	}
	
	public void showNotes() throws IOException{
		NotesView.loadToMain();
		NotesView.showView(baseLayout, primaryStage);
		showSidebar();
		
	}
	
	public void showStatistics() throws IOException, SQLException{
		StatisticsView.loadToMain();
		StatisticsView.showView(baseLayout, primaryStage);
		showSidebar();
	}
	
	public void setNewNote() throws IOException{
		
		if(Controle.criarTarefa(titleInput.getText(), textInput.getText())){
			NoteObj nota = new NoteObj();
			nota.addNewNote(noteBox, titleInput.getText(),textInput.getText());
			titleInput.setText("");
			textInput.setText("");
		}
		else{
			NotesView.showNotesErrorDialog(primaryStage);
		}

	}
	
	public void refreshNotes() throws IOException, SQLException{
		
		noteBox.getChildren().clear();
		
		for(Tarefa tarefa : Controle.obterTarefas() ){
			
			NoteObj nota = new NoteObj();
			nota.id = tarefa.getId();
			
			if(!tarefa.getEstado().equals(tarefa.FEITA) && !tarefa.getEstado().equals(tarefa.EXPIRADA)){
				nota.addNewNote(noteBox, tarefa.getNome(),tarefa.getDescricao());
			}
			
		}
		
	}
	
	
	public void setInfoStatistics() throws SQLException{
		
		coefVBox.getChildren().clear();
		StatisticsView.showInfo(coefVBox);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
