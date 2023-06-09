package domain.models;

public class Persona {
	
	protected int id;
	
	protected String nombre;
	
	protected String apellidos;
	
	protected Categoria categoria;
	
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Para jugador
	public Persona(int id, String nombre, String apellidos) {
		this.id=id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		
	}

	//este es para arbitro
	public Persona(int id, String nombre, String apellidos, Categoria categoria) {
		this.id=id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.categoria=categoria;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", categoria=" + categoria
				+ "]";
	}

	

}
