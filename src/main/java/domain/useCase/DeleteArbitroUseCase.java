package domain.useCase;

import java.sql.SQLException;

import data.ArbitroRemoteDataSource;


public class DeleteArbitroUseCase {
			
		ArbitroRemoteDataSource conexion;
		
		public DeleteArbitroUseCase() throws SQLException {
			
			conexion = ArbitroRemoteDataSource.getInstance("torneo_baloncesto","root","");
			
		}
		
		public void execute(int id) throws SQLException {
			conexion.deleteArbitro(id);
		}

	}
