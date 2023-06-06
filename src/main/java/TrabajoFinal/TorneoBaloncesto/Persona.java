package TrabajoFinal.TorneoBaloncesto;

public class Persona {
	
	private String nombre;
	
	private String apellidos;
	
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
