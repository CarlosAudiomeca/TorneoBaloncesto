package domain.useCase;

import java.sql.SQLException;

import data.JugadorRemoteDataSource;

public class DeleteJugadorUseCase {
	
JugadorRemoteDataSource conexion;
	
	public DeleteJugadorUseCase() throws SQLException {
		
		conexion = JugadorRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public void execute(int id) throws SQLException {
		conexion.deleteJugador(id);
	}

}
