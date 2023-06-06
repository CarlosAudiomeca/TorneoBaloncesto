package TrabajoFinal.TorneoBaloncesto;

public class Pista {
	
	protected enum ubicacion{Izquierda, Derecha}
	
	private int id;
	
	private String nombre;
	
	private ubicacion ubicacion;
	
	
	public Pista() {
		// TODO Auto-generated constructor stub
	}

	public Pista(int id, String nombre,ubicacion ubicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion=ubicacion;
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

	public ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Pista [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

}
