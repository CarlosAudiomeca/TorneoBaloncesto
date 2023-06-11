package domain.useCase;

import java.sql.SQLException;

import data.*;
import domain.models.Jugador;

public class AddJugadorUseCase {
	
	JugadorRemoteDataSource conexion;
	
	public AddJugadorUseCase() throws SQLException {
		
		conexion = JugadorRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
	}
	
	public void execute(Jugador jugador) {
		try {
			conexion.insertarJugador(jugador);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
