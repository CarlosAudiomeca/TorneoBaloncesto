package presentation;


import java.sql.SQLException;
import java.time.LocalDate;

import domain.models.*;
import domain.useCase.*;



public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		AddJugadorUseCase addJugador = new AddJugadorUseCase();
		DeleteJugadorUseCase deleteJugador = new DeleteJugadorUseCase();
		SearchJugadorUseCase searchJugador = new SearchJugadorUseCase();
		
		AddEquipoUseCase addEquipo = new AddEquipoUseCase();
		DeleteEquipoUseCase deleteEquipo = new DeleteEquipoUseCase();
		SearchEquipoUseCase searchEquipo= new SearchEquipoUseCase();
		
		Equipo equipo1 = new Equipo(1, "Yepes", Categoria.Senior);
		
		Equipo equipo2 = new Equipo(2, "Dioce", Categoria.Senior);
		
		addEquipo.execute(equipo1);
		addEquipo.execute(equipo2);
		
		System.out.println(searchEquipo.execute(1));
		
		deleteEquipo.execute(2);
		
		
		
		Jugador jugador = new Jugador();
		jugador.setId(1);
		jugador.setNombre("Carlos");
		jugador.setApellidos("Jimenez Rodrigez");
		jugador.setEquipo(equipo1);
		jugador.setFechaNacimiento(LocalDate.of(2000, 1, 1));
		
		addJugador.execute(jugador);
		
		System.out.println(searchJugador.execute(1).toString());
		
		deleteJugador.execute(1);
		
//		jugador.setFechaNacimiento(LocalDate.of(2000, 5, 5));
//		
//		System.out.println(jugador);
//		
//		Arbitro arbitro = new Arbitro(1, Categoria.Senior);
//		
//		Pista pista = new Pista(domain.models.Pista.Ubicacion.Derecha);
//		
//		Partido partido = new Partido();
//		partido.setId(1);
//		partido.setPista(pista);
//		partido.setEquipo1(equipo1);
//		partido.setEquipo2(equipo2);
//		partido.setArbitro(arbitro);
//		partido.setResultado("100-99");
		
		
		
	}

}
