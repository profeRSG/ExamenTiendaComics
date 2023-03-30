package gestion;

import modelo.Comic;
import modelo.ComicAmericano;
import modelo.ComicEstandar;

public class Main {
	//ATRIBUTOS ESTATICOS
	public static final int TAM_MAX=100;//Numero maximo
	//de comics en el sistema
	private static Comic[] comicsTienda=new Comic[TAM_MAX];//Array donde se almacena los
	//comics de la tienda;
	private static int index=0;//Indice que nos indica por donde
	//estamos añadiendo comics. Es decir, donde debemos insertar el
	//proximo comic en comicsTienda.


	/**
	 * Metodo para iniciar el programa
	 * @param args
	 */
	public static void main(String[] args) {
		boolean salir=false;
		//Creamos el menu principal del programa
		while(!salir) {
			int eleccion= menuPrincipal();//Variable para almacenar la opcion elegida por el usuario
			switch (eleccion) {//En funcion de la opcion elegida por el usuario
			case 1->darAltaComic();
			case 2->filtrarPorGenero();
			case 3->listarComicsNivelPorDebajoMedia();
			case 4-> salir=true;
			}
		}
	}


	private static void listarComicsNivelPorDebajoMedia() {
		double media=obtenerMediaNivelRelevancia();//Obtenemos el valor medio
		filtrarPorNiveleRelevancia(media);//Mostramos los comic con un nivel de relevancia menor al pasado como parametro
	}

	private static void filtrarPorNiveleRelevancia(double media) {
		for(int i=0;i<index;i++) { //Recorremos todos los comics
			if(comicsTienda[i].getNivelDeRelevancia()<media){//Si el nivel es menor a la media			
				System.out.println(comicsTienda[i].getFormatoUsuario("***************************************"));//Se muestra el comic por pantalla
			}
		}
	}


	private static double obtenerMediaNivelRelevancia() {
		double sumatorioNivelRelevancia=0;//Es un double, para hacer una operacion con decimales
		double contador=0;//REalmente no es necesario, porque se tiene el index, pero
		//lo hago de estar forma para practicar la forma tradicional de obtener la media
		for(int i=0;i<index;i++) { //Recorremos todos los comics
			contador++;
			sumatorioNivelRelevancia+=comicsTienda[i].getNivelDeRelevancia();//Sumamos
			//el nivel de relevancia. Si el comic es americamo, llamara a su metodo
			//y si es estandar, pues llamara a su metodo, ya que la vinculacion
			//es dinamica
		}
		return sumatorioNivelRelevancia/contador;//Dividimos para obtener la media
	}

	//Metodo que solicta un genero al usuario
	// y muestra llos comics de diocho genero
	private static void filtrarPorGenero() {
		//Se le solicita al usuario el genero
		String genero=MenuUsuario.elegirString("Indica el género");
		boolean hayAlgunComic=false;
		for(int i=0;i<index;i++) { //Recorremos todos los comics
			if(comicsTienda[i].getGenero().equals(genero)){//Si el genero es el mismo
				//que el que estamos buscando
				hayAlgunComic=true;//Hay algun comic con el mismo genero
				System.out.println(comicsTienda[i].getFormatoUsuario("*****************************************"));//Se muestra el comic por pantalla

			}
		}
		if(!hayAlgunComic) {//Si no hay ningun comic
			System.out.println("No hay ningún comic de dicho género en el sistema");
		}
	}

	private static void darAltaComic() {
		String titulo, subtitulo, genero;
		int americanITB;
		double precio;
		Comic comicNuevo;
		int eleccion=menuTipoComicAElegir();//El usuario elige el tipo de comic

		//Pedimos los atributos comics de todos los comics
		titulo=MenuUsuario.elegirString("¿Cuál es el titulo?");
		subtitulo=MenuUsuario.elegirString("¿Cuál es el subtitulo?");
		precio=MenuUsuario.elegirDouble("¿Cuál es su precio");
		genero=MenuUsuario.elegirString("¿Cuál es su genero");
		if(eleccion==2){//Si se ha elegido el comic americano
			americanITB=MenuUsuario.elegirInt("Cual es su amercian ITB");
			//Pedimos el atributo propio de los comics americanos.
			comicNuevo=new ComicAmericano(titulo, subtitulo, genero, precio, americanITB);//Creamos el comic
			//con los datos aportados por el usuario
		}
		else {//Si se la elegido la opcion 1
			comicNuevo=new ComicEstandar(titulo, subtitulo, genero, precio);//Creamo el comic estandar
		}
		addComic(comicNuevo);//Se a�ade el comic en el array del sistema.
	}

	private static int menuTipoComicAElegir() {
		int eleccion=0;//Variable para almacenar la opcion elegida por el usuario
		MenuUsuario menuTipoComic=new MenuUsuario("¿Qué tipo de cómic quiere dar de alta?"); //Creamos el menu
		menuTipoComic.addOpcion("Estandar");//A�adimos las opciones al menu
		menuTipoComic.addOpcion("Americano");
		eleccion=menuTipoComic.elegirOpcion();//El usuario elige la opcion
		return eleccion;
	}

	private static void addComic(Comic comicNuevo) {
		if(index<=TAM_MAX){//Comprobamos que aun no hemos llegado al maximo de comics
			//Index reprenseta el lugar donde vamos a guardar el proximo comic. Cuando
			//este supere el tamaño de la array, quiere decir que ya no se pueden guardar mas comics
			comicsTienda[index]=comicNuevo;//Añadimos el comic en la posicion que nos indica index;
			index++;//Incrementanos index para que se añada en la siguiente posicion de la array
			System.out.println(comicNuevo.getFormatoUsuario("Comic dado satisfactoriamente de alta"));
		}
		else {//En este caso no se pueden añadir mas comics
			System.out.println("No se pueden a�adir mas comics");//Avisamos al usuario
		}
	}

	//Metodo utilizado para mostrar el menu principal del programa
	private static int menuPrincipal() {
		//Creamos el menu principal del programa
		MenuUsuario menuPrincipal=new MenuUsuario("¿Que desea realizar?");
		int eleccion;//Variable para almacenar la opcion elegida por el usuario
		menuPrincipal.addOpcion("Dar de alta un comic");
		menuPrincipal.addOpcion("Listar los comics de un genero");
		menuPrincipal.addOpcion("Listar los comics cuyo nivel de relevancia est� por debajo de la media");
		menuPrincipal.addOpcion("salir");//No se pide, pero lo hemos a�adido
		eleccion=menuPrincipal.elegirOpcion();
		return eleccion;
	}



	public static Comic[] getComicsTienda() {
		return comicsTienda;
	}

	public static void setComicsTienda(Comic[] comicsTienda) {
		Main.comicsTienda = comicsTienda;
	}


}
