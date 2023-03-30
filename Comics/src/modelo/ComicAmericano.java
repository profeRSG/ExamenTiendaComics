package modelo;

//Se consider que los comic americanos y estandar, son comics diferentes
//Por ello ambas clases heredan de una clase comun.
public class ComicAmericano extends Comic{
	public static double CTE=1.75;//Constante
	private int americanITB;
	
	//Constructor
	public ComicAmericano(String titulo, String subtitulo, String genero, double precio, int americanITB) {
		super(titulo, subtitulo, genero, precio);
		this.americanITB=americanITB;
	}

	
	
	public int getAmericanITB() {
		return americanITB;
	}



	public void setAmericanITB(int americanITB) {
		this.americanITB = americanITB;
	}



	@Override
	public double getNivelDeRelevancia() {
		return getPrecio()*CTE;
	}



	@Override
	protected String atributosExtras() {
		return "American ITB: "+americanITB+"\n";
	}

}
