package domain.useCase;

import java.sql.SQLException;

import data.JugadorRemoteDataSource;
import domain.models.Jugador;

public class SearchJugadorUseCase {
	
JugadorRemoteDataSource conexion;
	
	public SearchJugadorUseCase() throws SQLException {
		
		conexion = JugadorRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public Jugador execute(int id) throws SQLException {
		Jugador jugador = null;
		jugador=conexion.searchJugador(id);
		return jugador;
	}

}
