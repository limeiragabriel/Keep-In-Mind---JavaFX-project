package ui;

import java.sql.SQLException;
import java.util.ArrayList;

import application.Facade;
import application.Tarefa;

public class Controle {
	
	public static Facade controle = new Facade();
	
	public static boolean criarUsuario(String usuario, String senha){
		return controle.criarUser(usuario, senha);
	}
	
	public static boolean logar(String usuario, String senha){
		return controle.logar(usuario, senha);
	}
	
	public static String getUsuario(){
		return controle.getUsuario();
	}
	
	public static boolean criarTarefa(String nome, String descricao){
		return controle.criarTarefa(nome, descricao);
	}
	
	public static ArrayList<Tarefa> obterTarefas(){
		return controle.obterTarefas();
	}
	
	public static float calcularCoeficiente() throws SQLException {
		return controle.calcularCoeficiente();
	}
	
	public static int calcularNivel() throws SQLException{
		return controle.calcularNivel();
	} 
	
}
