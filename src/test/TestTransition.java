package test;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import petriNet.Edge;
import petriNet.EdgeIn;
import petriNet.EdgeOut;
import petriNet.Place;
import petriNet.Transition;

public class TestTransition {
	
	@Test
	void testConstructorWithParameter(){
		Place place = new Place(2);
		EdgeIn edge = new EdgeIn(3,place);
		LinkedList<Edge> list= new LinkedList<Edge>();
		list.add(edge);
		Transition transition = new Transition(list);
		assertEquals(list,transition.getEdges());
		
	}
	
	@Test
	void testConstructorWithNoParameter(){
		LinkedList<Edge> list = new LinkedList<Edge>();
		Transition transition = new Transition();
		assertEquals(list,transition.getEdges());
		
	}
	
	@Test
	void testGetEdges() {
		Place place = new Place(1);
		EdgeIn edge = new EdgeIn(2,place);
		LinkedList<Edge> list= new LinkedList<Edge>();
		list.add(edge);
		Transition transition = new Transition(list);
		assertEquals(list,transition.getEdges());
	}
	
	@Test
	void testAddEdge() {
		Place place = new Place(2);
		EdgeIn edge = new EdgeIn(3,place);
		LinkedList<Edge> list= new LinkedList<Edge>();
		list.add(edge);
		Transition transition = new Transition();
		transition.addEdge(edge);
		assertEquals(transition.getEdges(),list);
	}
	
	@Test
	void testRemoveEdgeFromPlace() {
		Place place1 = new Place(2);
		EdgeIn edge1 = new EdgeIn(3,place1);
		Place place2 = new Place(3);
		EdgeOut edge2 = new EdgeOut(2,place2);
		LinkedList<Edge> list= new LinkedList<Edge>();
		list.add(edge2);
		Transition transition = new Transition();
		transition.addEdge(edge1);
		transition.addEdge(edge2);
		transition.removeEdgeFromPlace(place1);
		assertEquals(transition.getEdges(),list);
	}
	
	@Test
	void testFire () {
		Place place1 = new Place(2);
		EdgeIn edge1 = new EdgeIn(3,place1);
		Place place2 = new Place(1);
		EdgeOut edge2 = new EdgeOut(2,place2);
		LinkedList<Edge> list= new LinkedList<Edge>();
		list.add(edge2);
		list.add(edge1);
		Transition transition = new Transition(list);
		transition.fire();
		assertEquals(place2.getCountTokens(),1);
		place2.add(1);
		transition.fire();
		assertEquals(place2.getCountTokens(),0);
		
		
	}

}
