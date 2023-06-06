package TrabajoFinal.TorneoBaloncesto;

import java.time.LocalDate;

public class Jugador extends Persona{
	
	private int id;
	
	private LocalDate fechaNacimiento;
	
	private Equipo equipo;
	
	private Categoria categoria;
	
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(int id, LocalDate fechaNacimiento, Equipo equipo, Categoria categoria) {
		super();
		this.id = id;
		this.fechaNacimiento = fechaNacimiento;
		this.equipo = equipo;
		this.categoria= categoria;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", fechaNacimiento=" + fechaNacimiento + ", equipo=" + equipo + "]";
	}
	
	

}
