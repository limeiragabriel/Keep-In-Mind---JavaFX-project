package ui;

import java.io.IOException;
import java.sql.SQLException;

import com.sun.javafx.geom.Rectangle;

import application.Tarefa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NoteObj {
	
	private Pane note;
	public int id;
	Button deleteBtn;
	Separator linhaCima;
	Text tituloNota;
	Text textoNota;
	
	public void addNewNote(VBox box, String titulo, String texto) throws IOException{
		
		Button deleteBtn = new Button("Delete");
		deleteBtn.setLayoutX(590);
		deleteBtn.setLayoutY(3);
		
		Button marcaFeitaBtn = new Button(" Done ");
		marcaFeitaBtn.setLayoutX(590);
		marcaFeitaBtn.setLayoutY(30);
		
		Button marcaCanceladaBtn = new Button("Cancel");
		marcaCanceladaBtn.setLayoutX(590);
		marcaCanceladaBtn.setLayoutY(57);
		
		Separator linhaCima = new Separator();
		linhaCima.setLayoutX(0);
		linhaCima.setPrefWidth(684);
		
		Text tituloNota = new Text();
		tituloNota.setText(titulo);
		tituloNota.setWrappingWidth(575);
		tituloNota.setLayoutX(10);
		tituloNota.setLayoutY(25);
		
		Text textoNota = new Text();
		textoNota.setText(texto);
		textoNota.setWrappingWidth(575);
		textoNota.setLayoutX(10);
		textoNota.setLayoutY(50);
		
		note = new Pane();
		note.setPrefWidth(684);
		note.getChildren().addAll(tituloNota,textoNota,linhaCima,deleteBtn,marcaFeitaBtn,marcaCanceladaBtn);
		
		Text texto1 = new Text("Deletada");
		Text texto2 = new Text("Feita");
		Text texto3 = new Text("Cancelada");
		
		ImageView cor = new ImageView();
		cor.setLayoutX(0);
		cor.setLayoutY(0);
		
		deleteBtn.setOnAction(e -> {

			note.getChildren().clear();
			
			texto1.setLayoutY(10);
			cor.setImage(new Image("@/../images/vermelho.png"));
			
			note.getChildren().addAll(cor,texto1);
			
			for(Tarefa tarefa : Controle.obterTarefas() ){
				
				if(tarefa.getId() == this.id){
						try {
							tarefa.deleteTarefa();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		
		marcaFeitaBtn.setOnAction(e -> {
			
			note.getChildren().clear();
			
			texto2.setLayoutY(10);
			cor.setImage(new Image("@/../images/verde.png"));
			
			note.getChildren().addAll(cor,texto2);
			
			for(Tarefa tarefa : Controle.obterTarefas() ){
				
				if(tarefa.getId() == this.id && !tarefa.getEstado().equals(tarefa.FEITA)){
						try {
							tarefa.setEstado(tarefa.FEITA);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		
		marcaCanceladaBtn.setOnAction(e -> {

			note.getChildren().clear();

			texto3.setLayoutY(10);
			cor.setImage(new Image("@/../images/azul.png"));
			
			note.getChildren().addAll(cor,texto3);
			
			for(Tarefa tarefa : Controle.obterTarefas() ){
				
				if(tarefa.getId() == this.id){
						try {
							tarefa.setEstado(tarefa.EXPIRADA);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		
		box.getChildren().add(note);
		
	}
	
}
