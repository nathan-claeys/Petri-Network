package unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import petriNet.Edge;
import petriNet.EdgeType;
import petriNet.PetriNet;
import petriNet.Place;
import petriNet.Transition;

public class TestPetriNet {
	
	@Test
	void testConstructor() {
		PetriNet petriNet = new PetriNet();
		assertTrue(petriNet instanceof PetriNet);
	}

	@Test 
	void testAddCaseDefaultType(){
		PetriNet petriNet = new PetriNet();
		Place place = new Place(1);
		Transition transition = new Transition();
		petriNet.add(place);
		petriNet.add(transition);
		assertThrows(NullPointerException.class,()->petriNet.add(place, transition, 1,null));
	}
	
	@Test
	void testToStringAndAddPlaceAndAddTransitionAndAddEdgeIn() {
		PetriNet petriNet = new PetriNet();
		Place place = new Place(1);
		Transition transition = new Transition();
		petriNet.add(place);
		petriNet.add(transition);
		petriNet.add(place, transition, 1, EdgeType.IN);
		Edge edge = transition.getEdges().get(0);
		String result = String.format("RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n", 1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 1);
		result += "=====================\nEtat des arcs :\n";
		result += String.format("  Arcs de la transition %d\n", 1);
		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1, 1, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
		assertEquals(petriNet.toString(),result);
	}
	
	@Test
	void testAddEdgeOut() {
		PetriNet petriNet = new PetriNet();
		Place place = new Place(1);
		Transition transition = new Transition();
		petriNet.add(place);
		petriNet.add(transition);
		petriNet.add(place, transition, 1, EdgeType.OUT);
		Edge edge = transition.getEdges().get(0);
		String result = String.format("RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n", 1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 1);
		result += "=====================\nEtat des arcs :\n";
		result += String.format("  Arcs de la transition %d\n", 1);
		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1, 1, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
		assertEquals(petriNet.toString(),result);
	}
	
	@Test
	void testAddEdgeEmpty() {
		PetriNet petriNet = new PetriNet();
		Place place = new Place(1);
		Transition transition = new Transition();
		petriNet.add(place);
		petriNet.add(transition);
		petriNet.add(place, transition, 1, EdgeType.EMPTY);
		Edge edge = transition.getEdges().get(0);
		String result = String.format("RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n", 1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 1);
		result += "=====================\nEtat des arcs :\n";
		result += String.format("  Arcs de la transition %d\n", 1);
		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1, 1, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
		assertEquals(petriNet.toString(),result);
	}
	
	@Test
	void testAddEdgeZero() {
		PetriNet petriNet = new PetriNet();
		Place place = new Place(1);
		Transition transition = new Transition();
		petriNet.add(place);
		petriNet.add(transition);
		petriNet.add(place, transition, 1, EdgeType.ZERO);
		Edge edge = transition.getEdges().get(0);
		String result = String.format("RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n", 1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 1);
		result += "=====================\nEtat des arcs :\n";
		result += String.format("  Arcs de la transition %d\n", 1);
		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1, 1, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
		assertEquals(petriNet.toString(),result);
	}
	
	@Test
	void testfire() {
		PetriNet petriNet = new PetriNet();
		Place place = new Place(1);
		Transition transition = new Transition();
		petriNet.add(place);
		petriNet.add(transition);
		petriNet.add(place, transition, 1, EdgeType.IN);
		Edge edge = transition.getEdges().get(0);
		petriNet.triggerTransition(transition);
		String result = String.format("RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n", 1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 2);
		result += "=====================\nEtat des arcs :\n";
		result += String.format("  Arcs de la transition %d\n", 1);
		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1, 1, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
		assertEquals(petriNet.toString(),result);
		//case note fireable 
		PetriNet petriNet2 = new PetriNet();
		Place place2 = new Place(1);
		Transition transition2 = new Transition();
		petriNet2.add(place2);
		petriNet2.add(transition2);
		petriNet2.add(place2, transition2, 2, EdgeType.OUT);
		Edge edge2 = transition2.getEdges().get(0);
		petriNet2.triggerTransition(transition2);
		String result2 = String.format("RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n", 1, 1);
		result2 += String.format("Place %d : %d cailloux\n", 1, 1);
		result2 += "=====================\nEtat des arcs :\n";
		result2 += String.format("  Arcs de la transition %d\n", 1);
		result2 += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1, 2, edge2.getClass().getName(), 1);
		result2 += "FIN DU RAPPORT\n----------------------------------------------\n";
		assertEquals(petriNet2.toString(),result2);
		
	}
	
	@Test
	void testRemoves() {
		PetriNet petriNet = new PetriNet();
		Place place = new Place(1);
		Transition transition = new Transition();
		petriNet.add(place);
		petriNet.add(transition);
		petriNet.add(place, transition, 1, EdgeType.IN);
		petriNet.remove(transition);
		petriNet.remove(place);
		// The edge is automatically removed
		String result = String.format("RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n", 0, 0);
		result += "=====================\nEtat des arcs :\n";
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
		assertEquals(petriNet.toString(),result);
	}

}
