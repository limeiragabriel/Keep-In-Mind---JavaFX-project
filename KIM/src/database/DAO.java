package database;

import java.sql.SQLException;
import java.util.ArrayList;

import application.Tarefa;

public class DAO {
	
	public void setUsuarioDAO(String usuario, String senha) throws SQLException {

		Conexao.pstmt = Conexao.con.prepareStatement("INSERT INTO usuario (usuario,senha) values (?,?)");
		Conexao.pstmt.setString(1,usuario);
		Conexao.pstmt.setString(2,senha);
		Conexao.pstmt.executeUpdate();
		Conexao.pstmt.close();
		
	}
	
	public String getUserSenha(String usuario) throws SQLException {
		
		String senha = null;
		
		Conexao.rs = Conexao.stmt.executeQuery("select * from usuario where usuario = '" + usuario + "'");
		Conexao.rs.next();
		senha = Conexao.rs.getString("senha");
		Conexao.rs.close();
		
		return senha;
	}
	
	public void setTarefaDAO(String nome, String descricao, String usuario_idFK) throws SQLException {
		
		Conexao.pstmt = Conexao.con.prepareStatement("INSERT INTO tarefa (nome, descricao, estado, usuario_idFK) values (?,?,?,?)");
		
		Conexao.pstmt.setString(1, nome);
		Conexao.pstmt.setString(2, descricao);
		Conexao.pstmt.setString(3, Tarefa.PENDENTE);
		Conexao.pstmt.setString(4, usuario_idFK);
		Conexao.pstmt.executeUpdate();
		Conexao.pstmt.close();

	}
	
	public void editEstadoDAO(String estado, int id) throws SQLException {
		
		Conexao.pstmt = Conexao.con.prepareStatement("UPDATE banco.tarefa SET estado = '" + estado + "' WHERE id = '" + id + "'");
		Conexao.pstmt.executeUpdate();
		Conexao.pstmt.close();
	}
	
	public void deleteTarefaDAO(int id) throws SQLException {
		
		Conexao.pstmt = Conexao.con.prepareStatement("DELETE FROM banco.tarefa WHERE id = '" + id + "'");
		Conexao.pstmt.executeUpdate();
		Conexao.pstmt.close();
	}
	
	public ArrayList<Tarefa> getTarefaDAO(String usuario_idFK) throws SQLException {
		
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		
		Conexao.rs = Conexao.stmt.executeQuery("select * from tarefa where usuario_idFK = '" + usuario_idFK + "'");
		
		while(Conexao.rs.next()) {
			
			int id = Conexao.rs.getInt("id");
			String nome = Conexao.rs.getString("nome");
			String descricao = Conexao.rs.getString("descricao");
			String estado = Conexao.rs.getString("estado");
			
			Tarefa tarefaAtual = new Tarefa(id, nome, descricao, estado);
			tarefas.add(tarefaAtual);
		}
		
		return tarefas;
	}
	
	
}
