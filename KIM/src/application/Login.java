package application;

import java.sql.SQLException;

import database.DAO;

public class Login {
	DAO dao = new DAO();
	private String usuario = null;
	
	public boolean logar(String usuario, String senha) {

		try {
			if (dao.getUserSenha(usuario).equals(senha)) {
				this.usuario = usuario;
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		catch(NullPointerException e){
			return false;
		}
	}

	public String getUsuario() {
		return usuario;
	}

	
}
