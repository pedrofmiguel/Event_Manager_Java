package classes;

public class Utilizador {
	private String nome;
	private String password;
    private int permissao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermissao() {
		return permissao;
	}
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	public Utilizador(String nome, String password, int permissao) {
		super();
		this.nome = nome;
		this.password = password;
		this.permissao = permissao;
	}

}
