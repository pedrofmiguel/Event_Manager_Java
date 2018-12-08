package classes;

public class Evento {
	private String responsavel;
	private String nome;
	private String tipoEvent;
	private String cursoo;
	private String Precoo;
	private String salaa;
	private String datadia;
	private String datames;
	private String dataano;
	private String hora;
	private String minutos;
	private String datalimdia;
	private String datalimmes;
	private String datalimano;
	
	
	public Evento(String responsavel, String nome, String tipoEvent, String cursoo, String precoo, String salaa,
			String datadia, String datames, String dataano, String hora, String minutos, String datalimdia,
			String datalimmes, String datalimano) {
		super();
		this.responsavel = responsavel;
		this.nome = nome;
		this.tipoEvent = tipoEvent;
		this.cursoo = cursoo;
		Precoo = precoo;
		this.salaa = salaa;
		this.datadia = datadia;
		this.datames = datames;
		this.dataano = dataano;
		this.hora = hora;
		this.minutos = minutos;
		this.datalimdia = datalimdia;
		this.datalimmes = datalimmes;
		this.datalimano = datalimano;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTipoEvent() {
		return tipoEvent;
	}


	public void setTipoEvent(String tipoEvent) {
		this.tipoEvent = tipoEvent;
	}


	public String getCursoo() {
		return cursoo;
	}


	public void setCursoo(String cursoo) {
		this.cursoo = cursoo;
	}


	public String getPrecoo() {
		return Precoo;
	}


	public void setPrecoo(String precoo) {
		Precoo = precoo;
	}


	public String getSalaa() {
		return salaa;
	}


	public void setSalaa(String salaa) {
		this.salaa = salaa;
	}


	public String getDatadia() {
		return datadia;
	}


	public void setDatadia(String datadia) {
		this.datadia = datadia;
	}


	public String getDatames() {
		return datames;
	}


	public void setDatames(String datames) {
		this.datames = datames;
	}


	public String getDataano() {
		return dataano;
	}


	public void setDataano(String dataano) {
		this.dataano = dataano;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getMinutos() {
		return minutos;
	}


	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}


	public String getDatalimdia() {
		return datalimdia;
	}


	public void setDatalimdia(String datalimdia) {
		this.datalimdia = datalimdia;
	}


	public String getDatalimmes() {
		return datalimmes;
	}


	public void setDatalimmes(String datalimmes) {
		this.datalimmes = datalimmes;
	}


	public String getDatalimano() {
		return datalimano;
	}


	public void setDatalimano(String datalimano) {
		this.datalimano = datalimano;
	}
	

	
	
	
}
