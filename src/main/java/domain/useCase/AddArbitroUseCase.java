package domain.useCase;

import java.sql.SQLException;

import data.ArbitroRemoteDataSource;
import domain.models.Arbitro;

public class AddArbitroUseCase {
ArbitroRemoteDataSource conexion;
	
	public AddArbitroUseCase() throws SQLException {
		
		conexion = ArbitroRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public void execute(Arbitro arbitro) {
		try {
			conexion.insertarArbitro(arbitro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
