package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import petriNet.EdgeIn;
import petriNet.Place;

public class EdgeTest {
	@Test
	public void testGetPlace() {
		Place place = null;
		EdgeIn edge = new EdgeIn(3,place);
		Place p2 = edge.getPlace();
		assertEquals(p2,place);
		
	}
	@Test
	public void testGetWeight() {
		Place place = null;
		EdgeIn edge = new EdgeIn(3,place);
		int w = edge.getWeight();
		assertEquals(w,3);
		
	}
}
