package domain.models;

import java.sql.Time;

public class Partido {
	
	private int id;

	private Time hora;
	
	private Pista pista;
	
	private Equipo equipo1;
	
	private Equipo equipo2;
	
	private Arbitro arbitro;
	
	private String resultado;
	
	
	public Partido() {
		
	}

	public Partido(int id, Time hora, Pista pista, Equipo equipo1, Equipo equipo2, Arbitro arbitro, String resultado) {
		super();
		this.id = id;
		this.hora = hora;
		this.pista = pista;
		this.equipo1 = equipo1;
		if (coincidirCategoriaEquipos(equipo1, equipo2)==true) {
			this.equipo2=equipo2;
		}else {
			System.out.println("Los equipos no coinciden en categoria");
		}
		if (coincidirCategoriaArbitro(equipo1, arbitro)==true) {
			this.arbitro=arbitro;
		}else {
			System.out.println("Este arbitro no puede arbitrar este partido");
		}
		this.resultado = resultado;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		if (coincidirCategoriaEquipos(equipo1, equipo2)==true) {
			this.equipo2=equipo2;
		}else {
			System.out.println("Los equipos no coinciden en categoria");
		}
	}

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		if (coincidirCategoriaArbitro(equipo1, arbitro)==true) {
			this.arbitro=arbitro;
		}else {
			System.out.println("Este arbitro no puede arbitrar este partido");
		}
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", hora=" + hora + ", pista=" + pista + ", equipo1=" + equipo1 + ", equipo2="
				+ equipo2 + ", arbitro=" + arbitro + ", resultado=" + resultado + "]";
	}
	
	private boolean coincidirCategoriaEquipos(Equipo equipo, Equipo equipo2) {
		Boolean result=false;
		if (equipo.getCategoria()== equipo2.getCategoria()) {
			result=true;
		}
		
		return result;
	}
	
	private boolean coincidirCategoriaArbitro(Equipo equipo, Arbitro arbitro) {
		Boolean result=false;
		if (equipo.getCategoria()==arbitro.getCategoria()) {
			result=true;
		}
		
		return result;
	}
	
	
	
}
