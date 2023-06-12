package presentation;


import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

import data.PistaRemoteDataSource;
import domain.models.*;
import domain.useCase.*;



public class Main {
	
	public static void main(String[] args) throws SQLException {

//		Partido partido = new Partido();
//		partido.setId(76);
//		partido.setHora(Time.valueOf("15:00:00"));
//		partido.setPista(new SearchPistaUseCase().execute(1));
//		partido.setEquipo1(new SearchEquipoUseCase().execute(3));
//		partido.setEquipo2(new SearchEquipoUseCase().execute(1));
//		partido.setArbitro(new Arbitro(1, Categoria.Senior));
//		partido.setResultado("5-0");

		AddPartidoUseCase addPartidoUseCase = new AddPartidoUseCase();
		//addPartidoUseCase.execute(partido);
		System.out.println(new SearchPartidoUseCase().execute(76));

		DeletePartidoUseCase deletePartidoUseCase = new DeletePartidoUseCase();
		deletePartidoUseCase.execute(76);
	}

}
