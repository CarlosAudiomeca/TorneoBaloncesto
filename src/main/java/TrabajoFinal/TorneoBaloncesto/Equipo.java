package TrabajoFinal.TorneoBaloncesto;

public class Equipo {
	
	private int id;
	
	private String nombre;
	
	private Categoria categoria;
	
	
	public Equipo() {
		// TODO Auto-generated constructor stub
	}

	public Equipo(int id, String nombre, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + "]";
	}
	
	

}
