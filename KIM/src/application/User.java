package application;

import java.sql.SQLException;
import java.util.ArrayList;

import database.DAO;

public class User {
	
	DAO dao = new DAO();
	
	public boolean criarUser(String usuario, String senha){
		 try{
			 dao.setUsuarioDAO(usuario,senha);
			 return true;
		 }
		 catch(SQLException e){
			return false;
		 }
	}
	
	public boolean criarTarefa(String nome, String descricao, String usuario_idFK){
		 try{
			 dao.setTarefaDAO(nome, descricao, usuario_idFK);
			 return true;
		 }
		 catch(SQLException e){
			return false;
		 }
	}
	
	public ArrayList<Tarefa> obterTarefas(String usuario_idFK){
		 try{
			return dao.getTarefaDAO(usuario_idFK);
		 }
		 catch(SQLException e){
			 return null;
		 }
	}
	
}
