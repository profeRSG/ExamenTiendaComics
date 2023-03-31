package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.ComicEstandar;

class ComicEstandarTest {
	
	

	@Test
	void testNivelDeRelevancia18() {
		ComicEstandar comic=new ComicEstandar("Mortadelo y filemon", "La gran busqueda", "Humor", 12.0);
		assertEquals(comic.getNivelDeRelevancia(), 18);
	}
	
	@Test
	void testNivelDeRelevancia9() {
		ComicEstandar comic=new ComicEstandar("Mafalda", "un nuevo mundo", "Humor", 6);
		assertEquals(comic.getNivelDeRelevancia(), 9);
	}

}
