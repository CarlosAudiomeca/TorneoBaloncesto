package domain.useCase;

import java.sql.SQLException;

import data.EquipoRemoteDataSource;
import domain.models.Equipo;

public class AddEquipoUseCase {

		EquipoRemoteDataSource conexion;
	
	public AddEquipoUseCase() throws SQLException {
		
		conexion = EquipoRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public void execute(Equipo equipo) {
		try {
			conexion.insertarEquipo(equipo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
