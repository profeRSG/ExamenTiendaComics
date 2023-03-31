package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.ComicAmericano;
import modelo.ComicEstandar;

class ComicAmericanoTest {

	@Test
	void testNivelDeRelevancia17() {
		ComicAmericano comic=new ComicAmericano("Spiderman", "Amazing", "Superheroes", 10.0, 124);
		assertEquals(comic.getNivelDeRelevancia(), 17.5);
	}
	
	@Test
	void testNivelDeRelevancia35() {
		ComicAmericano comic=new ComicAmericano("The mirror", "The hell", "Terror", 20.5, 124123);
		assertEquals(comic.getNivelDeRelevancia(), 35.875);
	}
	

}
