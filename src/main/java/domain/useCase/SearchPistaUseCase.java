package domain.useCase;

import java.sql.SQLException;


import data.PistaRemoteDataSource;

import domain.models.Pista;

public class SearchPistaUseCase {
	
	PistaRemoteDataSource conexion;
	
public SearchPistaUseCase() throws SQLException {
		
		conexion = PistaRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public Pista execute(int id) throws SQLException {
		Pista pista = null;
		pista=conexion.searchPista(id);
		return pista;
	}

}
