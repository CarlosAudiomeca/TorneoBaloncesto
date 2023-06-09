package domain.models;

import java.util.ArrayList;

public class Equipo {
	
	private int id;
	
	private String nombre;
	
	private Categoria categoria;
	
	private ArrayList<Jugador> jugadores;
	
	public Equipo() {
		jugadores = new ArrayList<>();
	}

	public Equipo(int id, String nombre, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		jugadores = new ArrayList<>();
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

	public void addJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	public void eraseJugador(int id) {
		for (Jugador jugador : jugadores) {
			if(jugador.getId()==id) {
				jugadores.remove(jugador);
			}
		}
	}
	
	public void searchJugador(int id) {
		for (Jugador jugador : jugadores) {
			if(jugador.getId()==id) {
				System.out.println(jugador);
				
			}
		}
	}
	
	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + "]";
	}
	
	

}
