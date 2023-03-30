package modelo;

import java.time.LocalDate;

public abstract class Comic {

	//Atributos
	private int identificador;
	private static int numeroComics=0;//Atributo estatico utilizado para ir
	//incrementando el id de los comics.
	private String titulo;
	private String subtitulo;
	private LocalDate fecha;
	private String genero;
	private double precio;
	//nivel de relevancia es un atributo
	//derivado, por lo que no se tiene que poner aqui
	
	
	//Constructor
	public Comic(String titulo, String subtitulo, String genero, double precio) {
		super();
		this.identificador = numeroComics;
		numeroComics++;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.fecha = LocalDate.now();//El fecha es la fecha actual de creacion.
		this.genero = genero;
		this.precio = precio;
	}
	
	
	//Getters y Setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdentificador() {
		return identificador;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
	 * Metodo abstracto que sirve para obtener el
	 * nivel de relevancia. Cada clase devolvera
	 * su nivel de relevancia.
	 * 
	 * @return nivel de relevancia
	 */
	public abstract double getNivelDeRelevancia();


	/**
	 * Metodo que devuelev con una cadena con el 
	 * texto con el que se le quiere presentar al usuario
	 * la informacion de un comic
	 * El metodo utilia un metodo abstracto el cual
	 * cada clase hija implementara con la
	 * informacion extra que tenga que aportar al usuario
	 * 
	 * @return cadena de texto con la que se le quiere presentar al usuario
	 * la informacion del usuario
	 */
	public  String getFormatoUsuario(String cabecera) {
		String mensaje="************"+cabecera+"*******\r\n"
		+ "Identificador:"+identificador+"\r\n"
		+ "Titulo: "+titulo+"\r\n"
		+ "Subtitulo: "+subtitulo+"\n"
		+ "Fecha: "+fecha+"\r\n"
		+ "Precio: "+precio+"\r\n"
		+ "Genero: "+genero+"\r\n"
		+ atributosExtras()
		+ "*************************************************************\r\n"
		+ "";
		return mensaje;
	}


	/**
	 * Metodo abstracto con el que las clases hijas puede añadir informacion
	 * extra para mostrar al usuario en el metodo FormatoUsuario
	 * @return Cadena con informacioon extra del comic
	 */
	protected abstract String atributosExtras();
	
	
}
