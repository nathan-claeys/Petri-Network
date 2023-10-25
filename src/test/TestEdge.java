package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import petriNet.EdgeIn;
import petriNet.EdgeOut;
import petriNet.Place;
import petriNet.Transition;

public class TestEdge {
	
	//Tests for abstract Edge
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
	
	//Tests for EdgeIn
	
	@Test
    void testTrigger(){
        Place place = new Place(3);
        EdgeIn edge = new EdgeIn(2,place);
        edge.trigger();
        assertEquals(5,place.getCountTokens());
    }

    //Tests for EdgeOut

    @Test
    void testTrigger2(){
        Place place = new Place(3);
        EdgeOut edge = new EdgeOut(2,place);
        edge.trigger();
        assertEquals(1,place.getCountTokens());
        Place place2 = new Place(1);
        EdgeOut edge2 = new EdgeOut(2,place2);
        assertThrows(ExceptionInInitializerError.class,()->edge2.trigger());
    }

    @Test
    void testIsTriggerable2(){
        Place place = new Place(3);
        EdgeOut edge = new EdgeOut(4,place);
        assertTrue(edge.isTriggerable());
        place.add(1);
        assertTrue(edge.isTriggerable());
    }

    //Tests for EdgeEmpty

    

}
