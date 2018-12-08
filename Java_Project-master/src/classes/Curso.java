package classes;

public class Curso {
	private String nome;

	
	@Override
	public String toString() {
		return  nome ;
	}

	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}