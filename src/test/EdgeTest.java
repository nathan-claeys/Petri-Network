package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import petriNet.EdgeIn;
import petriNet.EdgeOut;
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
	@Test
	public void testIsTriggerable() {
		Place place = new Place (4);
		EdgeOut edge = new EdgeOut(2,place);
		boolean res = edge.isTriggerable();
		assertTrue(res);	
	}
}
