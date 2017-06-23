package application;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DAO;

public class Rendimento {
	
	public float calcularCoeficiente(String usuario_idFK) throws SQLException {
		DAO dao = new DAO();
		ArrayList<Tarefa> tarefas = dao.getTarefaDAO(usuario_idFK);
		
		int feitas = 0;
		int expiradas = 0;
		
		for(Tarefa tarefa : tarefas) {
			
			switch(tarefa.getEstado()) {
				case Tarefa.FEITA:
					++feitas;
					break;
					
				case Tarefa.EXPIRADA:
					++expiradas;
					break;
			}
		}

		float total = feitas + expiradas;
		
		return ((feitas * 100.0f) / total);
	}
	
	public int calcularNivel(String usuario_idFK) throws SQLException {
		float coeficiente = calcularCoeficiente(usuario_idFK);
		
		if(coeficiente > 80) {
			return 5;
		} else if(coeficiente > 60) {
			return 4;
		} else if(coeficiente > 40) {
			return 3;
		} else if(coeficiente > 20) {
			return 2;
		} else {
			return 1;
		}
	}

}
