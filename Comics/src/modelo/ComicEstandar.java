package modelo;

//Se consider que los comic americanos y estandar, son comics diferentes
//Por ello ambas clases heredan de una clase comun.
public class ComicEstandar extends Comic{
	public static double CTE=1.5;//Constante
	
	//Constructor
	public ComicEstandar(String titulo, String subtitulo, String genero, double precio) {
		super(titulo, subtitulo, genero, precio);
	}

	
	
	@Override
	public double getNivelDeRelevancia() {
		return getPrecio()*CTE;
	}



	@Override
	protected String atributosExtras() {
		return "";//DEvuelev una cadena vacia
	}

}
