package application;

import java.sql.SQLException;
import java.util.ArrayList;

import database.Conexao;

public class Facade {
	private User user;
	private Login login;
	private Rendimento rend;
	
	public Facade() {
		Conexao.getConnection();
		this.user = new User();
		this.login = new Login();
		this.rend = new Rendimento();
	}
	
	public boolean criarUser(String usuario, String senha){
		return user.criarUser(usuario,senha);
	}
	
	public boolean logar(String usuario, String senha){
		return login.logar(usuario,senha);
	}
	
	public String getUsuario() {
		return login.getUsuario();
	}
	
	public boolean criarTarefa(String nome, String descricao){
		return user.criarTarefa(nome, descricao, login.getUsuario());
	}
	
	public ArrayList<Tarefa> obterTarefas(){
		return user.obterTarefas(login.getUsuario());
	}
	
	public float calcularCoeficiente() throws SQLException {
		return rend.calcularCoeficiente(login.getUsuario());
	}
	
	public int calcularNivel() throws SQLException {
		return rend.calcularNivel(login.getUsuario());
	}
}
