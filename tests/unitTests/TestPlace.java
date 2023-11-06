package unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;
import petriNet.Place;

public class TestPlace {
	
	@Test
	void testConstructor() {
		assertThrows(InvalidParameterException.class, () -> {new Place(-1);});
		Place place = new Place(2);
		assertEquals(2,place.getCountTokens());
	}
	
	@Test
	void testGetCountTokens() {
		Place place = new Place(3);
		assertEquals(3,place.getCountTokens());
	}

	@Test
	void testIsEmpty() {
		Place place0 = new Place(0);
		assertTrue(place0.isEmpty());
		Place place1 = new Place(1);
		assertFalse(place1.isEmpty());
	}
	
	@Test 
	void testAddTokens() {
		Place place = new Place(0);
		place.add(2);
		assertEquals(2,place.getCountTokens());//CAJ0
		assertThrows(InvalidParameterException.class,()->{place.add(-2);}); //CAJ1
	}

	@Test
	void testRemoveTokens(){
		Place place = new Place(3);
		place.remove(2);
		assertEquals(1,place.getCountTokens());//CEJ2
		assertThrows(InvalidParameterException.class,()->{place.remove(-2);});//CEJ0
		assertThrows(InvalidParameterException.class,()->{place.remove(4);});//CEJ1
}
}
