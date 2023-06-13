package domain.useCase;

import java.sql.SQLException;

import data.ArbitroRemoteDataSource;
import domain.models.Arbitro;


public class SearchArbitroUseCase {
	ArbitroRemoteDataSource conexion;
	
	public SearchArbitroUseCase() throws SQLException {
		
		conexion = ArbitroRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public Arbitro execute(int id) throws SQLException {
		Arbitro arbitro = null;
		arbitro=conexion.searchArbitro(id);
		return arbitro;
	}

}
