package TrabajoFinal.TorneoBaloncesto;


import java.io.ObjectInputStream.GetField;
import java.time.LocalDate;



public class Main {
	
	public static void main(String[] args) {
		
		
		Equipo equipo1 = new Equipo(1, "Yepes", Categoria.Senior);
		
		Equipo equipo2 = new Equipo(2, "Dioce", Categoria.Senior);
		
		Jugador jugador = new Jugador();
		jugador.setId(1);
		jugador.setNombre("Carlos");
		jugador.setApellidos("Jimenez Rodrigez");
		jugador.setEquipo(equipo1);
		
		jugador.setFechaNacimiento(LocalDate.of(2000, 5, 5));
		
		System.out.println(jugador);
		
		Arbitro arbitro = new Arbitro(1, Categoria.Senior);
		
		Pista pista = new Pista(Ubicacion.Derecha);
		
		Partido partido = new Partido();
		partido.setId(1);
		partido.setPista(pista);
		partido.setEquipo1(equipo1);
		partido.setEquipo2(equipo2);
		partido.setArbitro(arbitro);
		partido.setResultado("100-99");
		
		
		
	}

}
