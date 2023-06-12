package domain.models;
	
public class Pista {
	public enum Ubicacion{Izquierda, Derecha}
	
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
		this.ubicacion=ubicacion;
		this.nombre = nombrePista();

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
		String nombreFinal = "";

		if (ubicacion==Ubicacion.Derecha) {
			nombreFinal = id + "D";
		} else {
			nombreFinal = id + "I";
		}

		return nombreFinal;
	}


}
