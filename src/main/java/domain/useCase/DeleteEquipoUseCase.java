package domain.useCase;

import java.sql.SQLException;

import data.EquipoRemoteDataSource;

public class DeleteEquipoUseCase {
	
	EquipoRemoteDataSource conexion;
	
	public DeleteEquipoUseCase() throws SQLException {
		
		conexion = EquipoRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public void execute(int id) throws SQLException {
		conexion.deleteEquipo(id);
	}

}
