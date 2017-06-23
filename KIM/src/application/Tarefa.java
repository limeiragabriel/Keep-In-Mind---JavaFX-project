package application;
import java.sql.SQLException;
import java.util.Date;

import database.DAO;

public class Tarefa {
	private String nome;
	private String descricao;
	private String estado;
	private int id;
	
	public static final String FEITA = "feita";
	public static final String PENDENTE = "pendente";
	public static final String EXPIRADA = "expirada";

	public Tarefa(int id, String nome, String descricao, String estado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;

	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) throws SQLException {
		DAO dao = new DAO();
		dao.editEstadoDAO(estado, this.id);
	}
	
	public void deleteTarefa() throws SQLException {
		DAO dao = new DAO();
		dao.deleteTarefaDAO(this.id);
	}
	
	public int getId() {
		return this.id;
	}
	
}
