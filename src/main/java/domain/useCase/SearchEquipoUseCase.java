package domain.useCase;

import java.sql.SQLException;

import data.EquipoRemoteDataSource;
import domain.models.Equipo;

public class SearchEquipoUseCase {
	
	EquipoRemoteDataSource conexion;
	
	public SearchEquipoUseCase() throws SQLException {
		
		conexion = EquipoRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public Equipo execute(int id) throws SQLException {
		Equipo equipo = null;
		equipo=conexion.searchEquipo(id);
		return equipo;
	}

}
