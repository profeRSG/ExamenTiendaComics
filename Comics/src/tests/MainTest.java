package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gestion.Main;
import modelo.ComicAmericano;
import modelo.ComicEstandar;

class MainTest {
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//Creamos 4 comics de prueba
		ComicEstandar comic1=new ComicEstandar("Mortadelo y filemon", "La gran busqueda", "Humor", 12.0);
		ComicAmericano comic2=new ComicAmericano("Spiderman", "Amazing", "Superheroes", 10.0, 124);
		ComicEstandar comic3=new ComicEstandar("Mafalda", "un nuevo mundo", "Humor", 6);
		ComicAmericano comic4=new ComicAmericano("The mirror", "The hell", "Terror", 20.5, 124123);
		//La gestora del programa es el Main. Añadimos los comics creados en la gestora.
		Main.addComic(comic1);
		Main.addComic(comic2);
		Main.addComic(comic3);
		Main.addComic(comic4);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * Test implementado para probar si se calcula correctamente el nivel
	 * de relevancia de todos los comics de la tienda.
	 */
	void testMediaNivelRelevancia() {
		assertEquals(20.09375,Main.obtenerMediaNivelRelevancia());
	}

}
