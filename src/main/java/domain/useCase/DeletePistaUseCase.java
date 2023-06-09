package domain.useCase;

import java.sql.SQLException;


import data.PistaRemoteDataSource;

public class DeletePistaUseCase {

PistaRemoteDataSource conexion;
	
	public DeletePistaUseCase() throws SQLException {
		
		conexion = PistaRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public void execute(int id) throws SQLException {
		conexion.deletePista(id);
	}
	
	
}
