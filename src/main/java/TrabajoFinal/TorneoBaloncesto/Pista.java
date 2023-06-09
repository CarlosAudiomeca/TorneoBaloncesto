package TrabajoFinal.TorneoBaloncesto;
	enum Ubicacion{Izquierda, Derecha}
public class Pista {
	
	private static int contador=0;
	
	
	
	private int id;
	
	private String nombre;
	
	private Ubicacion ubicacion;
	
	
	public Pista() {
		contador++;
		this.id=contador;
	}

	public Pista(Ubicacion ubicacion) {
		contador++;
		this.id = contador;
		this.nombre = nombrePista();
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
		this.nombre = nombrePista();
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
		this.nombre = nombrePista();
	}

	@Override
	public String toString() {
		return "Pista [id=" + id + ", nombre=" + nombre + "]";
	}
	
	public String nombrePista() {
		String nombreFinal="";
		
		if(ubicacion==Ubicacion.Derecha) {
			nombreFinal=id+"d";
		}else {
			nombreFinal=id+"i";
		}
		
			
		
		return nombreFinal;
	}

}
