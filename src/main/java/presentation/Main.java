package presentation;


import java.sql.SQLException;
import java.time.LocalDate;

import data.PistaRemoteDataSource;
import domain.models.*;
import domain.useCase.*;



public class Main {
	
	public static void main(String[] args) throws SQLException {
		Pista pista = new Pista(domain.models.Pista.Ubicacion.Derecha);
		AddPistaUseCase addPistaUseCase = new AddPistaUseCase();
		addPistaUseCase.execute(pista);

//		AddJugadorUseCase addJugador = new AddJugadorUseCase();
//		DeleteJugadorUseCase deleteJugador = new DeleteJugadorUseCase();
//		SearchJugadorUseCase searchJugador = new SearchJugadorUseCase();
//
//		AddEquipoUseCase addEquipo = new AddEquipoUseCase();
//		DeleteEquipoUseCase deleteEquipo = new DeleteEquipoUseCase();
//		SearchEquipoUseCase searchEquipo= new SearchEquipoUseCase();
//
//		Equipo equipo1 = new Equipo(1, "Yepes", Categoria.Senior);
//
//		Equipo equipo2 = new Equipo(2, "Dioce", Categoria.Senior);
//
//		addEquipo.execute(equipo1);
//		addEquipo.execute(equipo2);
//
//		System.out.println(searchEquipo.execute(1));
//
//		deleteEquipo.execute(2);
//
//
//
//		Jugador jugador = new Jugador();
//		jugador.setId(14);
//		jugador.setNombre("Carlos");
//		jugador.setApellidos("Jimenez Rodrigez");
//		jugador.setEquipo(equipo1);
//		jugador.setFechaNacimiento(LocalDate.of(2000, 1, 1));
//
//		addJugador.execute(jugador);
//
//		System.out.println(searchJugador.execute(14).toString());
//
//		deleteJugador.execute(1);
//
//		jugador.setFechaNacimiento(LocalDate.of(2000, 5, 5));
//
//		System.out.println(jugador);
//
//		Arbitro arbitro = new Arbitro(1, Categoria.Senior);



		
		
	}

}
