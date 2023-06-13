package presentation;


import java.sql.SQLException;
import java.sql.Time;

import data.ArbitroRemoteDataSource;
import data.EquipoRemoteDataSource;
import data.PartidoRemoteDataSource;
import data.PistaRemoteDataSource;
import domain.models.*;
import domain.models.Pista.Ubicacion;
import domain.useCase.*;



public class Main {
	
	public static void main(String[] args) throws SQLException {
		ArbitroRemoteDataSource arbitroRemoteDataSource = ArbitroRemoteDataSource.getInstance("torneo_baloncesto","root","");
		PartidoRemoteDataSource partidoRemoteDataSource = PartidoRemoteDataSource.getInstance("torneo_baloncesto","root","");
		PistaRemoteDataSource pistaRemoteDataSource = PistaRemoteDataSource.getInstance("torneo_baloncesto","root","");
		EquipoRemoteDataSource equipoRemoteDataSource = EquipoRemoteDataSource.getInstance("torneo_baloncesto","root","");
		
		SearchEquipoUseCase searchEquipoUseCase = new SearchEquipoUseCase();
		System.out.println(searchEquipoUseCase.execute(1).toString());
		System.out.println(searchEquipoUseCase.execute(2).toString());
		
		Arbitro arbitro = new Arbitro(1, Categoria.Infantil);
		
		DeletePartidoUseCase deletePartidoUseCase = new DeletePartidoUseCase();
		deletePartidoUseCase.execute(76);
		
		DeleteArbitroUseCase deleteArbitroUseCase = new DeleteArbitroUseCase();
		deleteArbitroUseCase.execute(1);
		
		AddArbitroUseCase addArbitroUseCase = new AddArbitroUseCase();
		addArbitroUseCase.execute(arbitro);
		
		
		
		Pista pista = new Pista(Ubicacion.Derecha);
		DeletePistaUseCase deletePistaUseCase= new DeletePistaUseCase();
		deletePistaUseCase.execute(1);
		
		AddPistaUseCase addPistaUseCase = new AddPistaUseCase();
		addPistaUseCase.execute(pista);
		
		SearchArbitroUseCase searchArbitroUseCase = new SearchArbitroUseCase();
		System.out.println(searchArbitroUseCase.execute(1).toString());
		

		Partido partido = new Partido();
		partido.setId(76);
		partido.setHora(Time.valueOf("15:00:00"));
		partido.setPista(new SearchPistaUseCase().execute(1));
		partido.setEquipo1(searchEquipoUseCase.execute(2));
		partido.setEquipo2(searchEquipoUseCase.execute(1));
		partido.setArbitro(arbitro);
		partido.setResultado("5-0");

		
		
		AddPartidoUseCase addPartidoUseCase = new AddPartidoUseCase();
		addPartidoUseCase.execute(partido);
		System.out.println(new SearchPartidoUseCase().execute(76));
		
		SearchPartidoUseCase searchPartidoUseCase = new SearchPartidoUseCase();
		searchPartidoUseCase.execute(76);
		
		arbitroRemoteDataSource.cerrarConexion();
		pistaRemoteDataSource.cerrarConexion();
		partidoRemoteDataSource.cerrarConexion();
		equipoRemoteDataSource.cerrarConexion();

		//DeletePartidoUseCase deletePartidoUseCase = new DeletePartidoUseCase();
		//deletePartidoUseCase.execute(76);
	}

}
