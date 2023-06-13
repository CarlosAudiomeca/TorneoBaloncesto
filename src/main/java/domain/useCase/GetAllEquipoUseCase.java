package domain.useCase;

import java.sql.SQLException;
import java.util.List;

import data.EquipoRemoteDataSource;
import domain.models.Equipo;

public class GetAllEquipoUseCase {
	EquipoRemoteDataSource conexion;
	
	public GetAllEquipoUseCase() throws SQLException{
		conexion = EquipoRemoteDataSource.getInstance("torneo_baloncesto","root","");
	
		// TODO Auto-generated constructor stub
	}
		
	public List<Equipo> execute() {
		List<Equipo> equipos = null;
			try {
				equipos =conexion.obtenerEquipos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return equipos;
	}
 		
	
}
