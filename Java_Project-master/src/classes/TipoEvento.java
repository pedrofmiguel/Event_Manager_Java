package classes;

public class TipoEvento 
{
	private String evento;
	
	@Override
	public String toString() {
		return  evento ;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	public TipoEvento(String evento) {
		super();
		this.evento = evento;
	}

	
	



	
}
