package presentation;


import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import domain.models.*;
import domain.models.Pista.Ubicacion;
import domain.useCase.*;



public class Main {
	//CARLOS
	static Scanner entrada= new Scanner(System.in);
	
	
	public static void main(String[] args) throws SQLException {
		Scanner entrada2= new Scanner(System.in);
		int opcion;
		boolean salir=false;
		
		
		do {
			System.out.println("");
			System.out.println("MENU TORNEO DE BALONCESTO");
			System.out.println("");
			System.out.println("1.    Pista");
			System.out.println("2.    Arbitro");
			System.out.println("3.    Jugador");
			System.out.println("4.    Equipo");
			System.out.println("5.    Partido");
			System.out.println("6.    Imprimir PDF");
			System.out.println("7.    Salir");
			System.out.println("Introduce el numero de la opcion deseada");
			opcion=entrada2.nextInt();
			
			switch (opcion) {
			case 1:
				seleccionPista();
				break;
			case 2:
				seleccionArbitro();
				break;
			case 3:
				seleccionarJugador();
				break;
			case 4:
				selccionarEquipo();
				break;
			case 5:
				seleccionPartido();
				break;
			case 6:
				System.out.println("La aplicaion esta en constante desarrollo, esta funcionalidad estara disponible más adelante.");
				break;
			case 7:
				salir=true;
				System.out.println("Gracias por ejecutarme");
				break;
			default:
				System.out.println("Introduce una opcion valida");
				break;
			}
		} while (salir!=true);
		
		
		entrada2.close();
	}



	private static void seleccionPista() throws SQLException {
		int opcion;
		int id;
		
		System.out.println("MENU PISTA");
		System.out.println("");
		System.out.println("1.    Añadir Pista");
		System.out.println("2.    Borrar Pista");
		System.out.println("3.    Buscar Pista");
		opcion=entrada.nextInt();
		switch (opcion) {
		case 1:
			AddPistaUseCase addPistaUseCase = new AddPistaUseCase();
			addPistaUseCase.execute(crearPista());
			break;
		case 2:
			System.out.println("Introduce el id de la pista");
			id = entrada.nextInt();
			DeletePistaUseCase deletePistaUseCase = new DeletePistaUseCase();
			deletePistaUseCase.execute(id);
			break;
		case 3:
			System.out.println("Introduce el id de la pista");
			id = entrada.nextInt();
			SearchPistaUseCase searchPistaUseCase = new SearchPistaUseCase();
			System.out.println(searchPistaUseCase.execute(id).toString());
			break;
		default:
			System.out.println("Introduce una opcion valida");
			break;
		}
	}
	private static Pista crearPista() {
		Pista pista = new Pista();
		System.out.println("Introduce la ubicacion de la pista. 			Izquierda/Derecha");
		String ubicacion=entrada.next();
		Ubicacion sitio = Ubicacion.valueOf(ubicacion);
		pista.setUbicacion(sitio);
		return pista;
	}
	
	//PABLO
	
	private static void seleccionArbitro() throws SQLException {
		System.out.println("1.Añadir arbitro \n"
 		+ "2.Eliminar arbitro \n"
 		+ "3.Buscar arbitro");
		int opcion = entrada.nextInt();
		switch (opcion) {
			case 1:
				System.out.println("Dame el id del arbitro");
				int id = entrada.nextInt();
				System.out.println("Dame el nombre del arbitro");
				String nombre = entrada.next();
				System.out.println("Dame los apellidos del arbitro");
				String apellido = entrada.next();
				System.out.println("Dame la categoria del arbitro");
				System.out.println("Categorias: Infantil, Cadete, Juvenil y Senior");
				String cate= entrada.next().toLowerCase();
				Categoria categoria = null;
				boolean categoriaBuena = true;
				do {
					if(cate.equals("infantil")){
						categoria=Categoria.Infantil;
					} else if (cate.equals("cadete")) {
						categoria=Categoria.Cadete;
					} else if (cate.equals("juvenil")){
						categoria=Categoria.Juvenil;
					} else if (cate.equals("senior")) {
						categoria=Categoria.Senior;
					} else {
						System.out.println("Esa categoria no existe ");
						categoriaBuena = false;
					}
				} while (!categoriaBuena);
				AddArbitroUseCase arbitroUseCase = new AddArbitroUseCase();
				Arbitro arbitro = new Arbitro();
				arbitro.setId(id);
				arbitro.setNombre(nombre);
				arbitro.setApellidos(apellido);
				arbitro.setCategoria(categoria);
				arbitroUseCase.execute(arbitro);
				System.out.println("Arbitro añadido con exito");
				break;
			case 2:
				System.out.println("Dame el id del arbitro que quieres eliminar");
				id = entrada.nextInt();
				DeleteArbitroUseCase deleteArbitroUseCase = new DeleteArbitroUseCase();
				deleteArbitroUseCase.execute(id);
				System.out.println("Arbitro eliminado con exito");
				break;
			case 3:
				System.out.println("Dame el id del arbitro que quieres buscar");
				id = entrada.nextInt();
				SearchArbitroUseCase searchArbitroUseCase = new SearchArbitroUseCase();
				Arbitro arbitroBuscado = new Arbitro();
				arbitroBuscado=searchArbitroUseCase.execute(id);
				System.out.println(arbitroBuscado);
			}
	}
	private static void seleccionarJugador() throws SQLException {
		System.out.println("1.Añadir jugador \n"
				+ "2.Eliminar jugador \n"
				+ "3.Buscar jugador");
		int opcion = entrada.nextInt();
		switch (opcion) {
		case 1:
			System.out.println("Dame el id del jugador");
			int id = entrada.nextInt();
			System.out.println("Dame el nombre del jugador");
			String nombre = entrada.next();
			System.out.println("Dame los apellidos del jugador");
			String apellido = entrada.next();
			System.out.println("Dame la fecha de nacimiento del jugador (dd/MM/yyyy)");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String fecha = entrada.nextLine();
			LocalDate fechaNac = LocalDate.parse(fecha,formatter);
			AddJugadorUseCase jugadorUseCase = new AddJugadorUseCase();
			Jugador jugador = new Jugador();
			jugador.setId(id);
			jugador.setNombre(nombre);
			jugador.setApellidos(apellido);
			jugador.setFechaNacimiento(fechaNac);
			jugador.setEquipo(null);
			jugadorUseCase.execute(jugador);
			System.out.println("Jugador añadido con exito");
			break;
		case 2:
			System.out.println("Dame el id del jugador que quieres eliminar");
			id = entrada.nextInt();
			DeleteJugadorUseCase deleteJugadorUseCase = new DeleteJugadorUseCase();
			deleteJugadorUseCase.execute(id);
			System.out.println("Jugador eliminado con exito");
			break;
		case 3:
 
			System.out.println("Dame el id del juagdor que quieres buscar");
			id = entrada.nextInt();
			SearchJugadorUseCase searchJugadorUseCase = new SearchJugadorUseCase();
			Jugador jugadorBuscado = new Jugador();
			jugadorBuscado=searchJugadorUseCase.execute(id);
			System.out.println(jugadorBuscado);
 
		}
 }		
	
	
	//IBRA
	
	private static void selccionarEquipo() throws SQLException {
				int opcion=0;
				System.out.println("1-Añadir un Equipo\n2-Buscar un Equipo\n3-Ver todos los Equipos\n4-Borrar un Equipo\n5-Añadir jugadores a un Equipo");
				opcion=entrada.nextInt();
				switch (opcion) {
					
				case 1:
					System.out.print("Introduzca el id del equipo: ");
					int id = entrada.nextInt();
					entrada.nextLine();
					System.out.print("Introduzca el nombre del equipo: ");
					String nombre = entrada.nextLine();
					System.out.print("Introduzca la Categoria: ");
					System.out.println("Categorias: Infantil, Cadete, Juvenil y Senior.");
					String cat = entrada.nextLine().toLowerCase();
					Categoria categoria = null;
					boolean categoriaCorrecta=true;
					do {
						if (cat.equals("infantil")) {
							categoria=Categoria.Infantil;
						} else if (cat.equals("cadete")){
							categoria=Categoria.Cadete;
						} else if (cat.equals("juvenil")) {
							categoria=Categoria.Juvenil;		
						} else if (cat.equals("senior")) {
							categoria=Categoria.Senior;
						} else {
							System.out.println("Error, no has introducido una categoria correcta");
							categoriaCorrecta=false;
						}
					}while (!categoriaCorrecta);
					
					AddEquipoUseCase addEquipoUseCase = new AddEquipoUseCase();
					addEquipoUseCase.execute(new Equipo(id,nombre,categoria));
					System.out.println("Equipo insertado correctamente");
					break;
				case 2:
					entrada.nextLine();
					System.out.println("Introduzca el id del equipo a buscar: ");
					id = entrada.nextInt();
					SearchEquipoUseCase searchEquipoUseCase = new SearchEquipoUseCase();
					Equipo equipoBuscado = new Equipo();
					equipoBuscado=searchEquipoUseCase.execute(id);
					System.out.println(equipoBuscado);
					break;
				case 3:
					GetAllEquipoUseCase getAllEquipoUseCase = new GetAllEquipoUseCase();
					List<Equipo> equipos = getAllEquipoUseCase.execute();;
					for (Equipo e: equipos) {
						System.out.println(e);
					}
					break;
				case 4:
					entrada.nextLine();
					System.out.print("Introduzca el id del equipo a borrar: ");
					id = entrada.nextInt();
					DeleteEquipoUseCase deleteEquipoUseCase = new DeleteEquipoUseCase();
					deleteEquipoUseCase.execute(id);
					System.out.println("Se ha borrado correctamente");
					break;
				default:
					break;
				}			
		
		}
	
	//UNAI
	
	private static void seleccionPartido() throws SQLException {
		System.out.println("Seleccionaste la clase Partido, indica que quieres hacer \n"
                +"1. Si quieres añadir un partido. \n"
                +"2. Si quieres borrar un partido. \n"
                +"3. Si quieres buscar un partido.");
        int eleccion= entrada.nextInt();
            switch (eleccion) {
                case 1:
                    añadirPartido();
                    break;
                case 2:
                    borrarPartido();
                    break;                    
                case 3:
                    System.out.println("Para buscar un partido tienes que poner el id");                
                    SearchPartidoUseCase searchPartidoUseCase = new SearchPartidoUseCase();
                    System.out.println(searchPartidoUseCase.execute(entrada.nextInt()).toString());;
            default:
                break;
            }
	}
	private static void añadirPartido() throws SQLException{
        SearchArbitroUseCase searchArbitroUseCase = new SearchArbitroUseCase();
        SearchEquipoUseCase searchEquipoUseCase = new SearchEquipoUseCase();        
        Partido partido = new Partido();
        System.out.println("Introduce un id para el partido");
        partido.setId(entrada.nextInt());
        System.out.println("Introduce una fecha, el formato debe ir HH:MM:SS");
        partido.setHora(Time.valueOf(entrada.next()));
        System.out.println("Introduce el id de la pista");
        partido.setPista(new SearchPistaUseCase().execute(entrada.nextInt()));
        System.out.println("Introduce el id del equipo 1");
        partido.setEquipo1(searchEquipoUseCase.execute(entrada.nextInt()));
        System.out.println("Introduce el id del equipo 2");
        partido.setEquipo2(searchEquipoUseCase.execute(entrada.nextInt()));
        System.out.println("Introduce el id del arbitro");
        partido.setArbitro(searchArbitroUseCase.execute(entrada.nextInt()));
        System.out.println("Introduce el resultado del examen formato P-S");
        partido.setResultado(entrada.next());
        AddPartidoUseCase addPartidoUseCase = new AddPartidoUseCase();
        addPartidoUseCase.execute(partido);
        System.out.println("Se ha creado el partido correctamente");

    }
	private static void borrarPartido() throws SQLException {
        System.out.println("Para borrar un partido tienes que poner el id");        
        DeletePartidoUseCase deletePartidoUseCase = new DeletePartidoUseCase();
        deletePartidoUseCase.execute(entrada.nextInt());        
        System.out.println("Se ha borrado el partido correctamente");
    }
}
