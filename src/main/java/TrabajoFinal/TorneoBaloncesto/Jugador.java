package TrabajoFinal.TorneoBaloncesto;

import java.time.LocalDate;

public class Jugador extends Persona{
	
	
	
	private LocalDate fechaNacimiento;
	
	private Equipo equipo;
	
	
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	
	public Jugador(int id, String nombre, String apellidos, LocalDate fechaNacimiento, Equipo equipo) {
		super(id, nombre, apellidos);
		
		this.fechaNacimiento = fechaNacimiento;
		this.equipo = equipo;
		this.categoria = ponerCategoria();
	}

	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		this.categoria=ponerCategoria();
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	


	
	
	


	@Override
	public String toString() {
		return super.toString()+ " Jugador [fechaNacimiento=" + fechaNacimiento + ", equipo=" + equipo + "]";
		
		
	}


	public Categoria ponerCategoria() {
		if(fechaNacimiento.getYear()<2005) {
			return categoria.Senior;
		}else if(fechaNacimiento.getYear()<=2006) {
			return categoria.Juvenil;
		}else if(fechaNacimiento.getYear()<=2008) {
			return categoria.Cadete;
		}
		
		return categoria.Infantil;
		
	}
}
