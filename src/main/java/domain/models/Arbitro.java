package domain.models;

public class Arbitro extends Persona{
	
	private int id;
	
	private Categoria categoria;
	
	
	public Arbitro() {
		// TODO Auto-generated constructor stub
	}

	public Arbitro(int id, Categoria categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Arbitro [id=" + id + ", categoria=" + categoria + "]";
	}
	
	

}
