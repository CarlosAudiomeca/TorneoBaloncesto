package domain.useCase;

import java.sql.SQLException;


import data.PistaRemoteDataSource;

import domain.models.Pista;

public class AddPistaUseCase {

		PistaRemoteDataSource conexion;
	
	public AddPistaUseCase() throws SQLException {
		
		conexion = PistaRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public void execute(Pista pista) {
		try {
			conexion.insertarPista(pista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
