package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import petriNet.Edge;
import petriNet.EdgeIn;
import petriNet.EdgeOut;
import petriNet.EdgeType;
import petriNet.PetriNet;
import petriNet.Place;
import petriNet.Transition;

public class TestActivate {

    //RI
	@Test 
    void testActivateAloneTransition (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        petriNet.add(transition);
        String before = petriNet.toString(); 
        petriNet.triggerTransition(transition);
        assertEquals(before,petriNet.toString());
    }

    //RD0
	@Test
    void testActivateTransitionWithOneEmptyPlaceAndAnEdgeOut (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        Place place = new Place(0);
        petriNet.add(transition);
        petriNet.add(place);
        petriNet.add(place, transition, 1, EdgeType.OUT);
        EdgeOut edge = (EdgeOut) transition.getEdges().get(0);
        String result = String.format(
				"RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n",
				1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 0);
		result += "=====================\nEtat des arcs :\n";
		// Transitions information
		result += String.format("  Arcs de la transition %d\n", 1);


		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1,
						edge.getWeight(), edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
        petriNet.triggerTransition(transition);
        assertEquals(result,petriNet.toString());
    }

    //RD1
    @Test 
    void testActivateTransitionWithOnePlaceWith2tokenAndAnEdgeOut (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        Place place = new Place(2);
        petriNet.add(transition);
        petriNet.add(place);
        petriNet.add(place, transition, 1, EdgeType.OUT);
        EdgeOut edge = (EdgeOut) transition.getEdges().get(0);
        String result = String.format(
				"RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n",
				1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 1);
		result += "=====================\nEtat des arcs :\n";
		// Transitions information
		result += String.format("  Arcs de la transition %d\n", 1);


		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1,
						1, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
        petriNet.triggerTransition(transition);
        assertEquals(result,petriNet.toString());
    }

    //RD2
    @Test 
    void testActivateTransitionWithOnePlaceWith5tokenAndAnEdgeOutOfWeight3 (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        Place place = new Place(5);
        petriNet.add(transition);
        petriNet.add(place);
        petriNet.add(place, transition, 3, EdgeType.OUT);
        EdgeOut edge = (EdgeOut) transition.getEdges().get(0);
        String result = String.format(
				"RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n",
				1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 2);
		result += "=====================\nEtat des arcs :\n";
		// Transitions information
		result += String.format("  Arcs de la transition %d\n", 1);


		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1,
						3, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
        petriNet.triggerTransition(transition);
        assertEquals(result,petriNet.toString());
    }

    //RD3
    @Test
    void testActivateTransitionWithOnePlaceWith2tokenAndAnEdgeOutOfWeight3 (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        Place place = new Place(2);
        petriNet.add(transition);
        petriNet.add(place);
        petriNet.add(place, transition, 3, EdgeType.OUT);
        String result = petriNet.toString();
        petriNet.triggerTransition(transition);
        assertEquals(result,petriNet.toString());
    }

    //RG0
    @Test
    void testActivateTransitionWithOneEmptyPlacetokenAndAnEdgeIn (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        Place place = new Place(0);
        petriNet.add(transition);
        petriNet.add(place);
        petriNet.add(place, transition, 1, EdgeType.IN);
        EdgeIn edge = (EdgeIn) transition.getEdges().get(0);
        String result = String.format(
				"RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n",
				1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 1);
		result += "=====================\nEtat des arcs :\n";
		// Transitions information
		result += String.format("  Arcs de la transition %d\n", 1);


		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1,
						1, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
        petriNet.triggerTransition(transition);
        assertEquals(result,petriNet.toString());
    }

    //RG1
    @Test
    void testActivateTransitionWithOnePlaceWith2tokenAndAnEdgeIn (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        Place place = new Place(2);
        petriNet.add(transition);
        petriNet.add(place);
        petriNet.add(place, transition, 1, EdgeType.IN);
        EdgeIn edge = (EdgeIn) transition.getEdges().get(0);
        String result = String.format(
				"RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n",
				1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 3);
		result += "=====================\nEtat des arcs :\n";
		// Transitions information
		result += String.format("  Arcs de la transition %d\n", 1);


		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1,
						1, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
        petriNet.triggerTransition(transition);
        assertEquals(result,petriNet.toString());
    }

    //RG2
    @Test
    void testActivateTransitionWithOnePlaceWith1tokenAndAnEdgeInOfWeight3 (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        Place place = new Place(1);
        petriNet.add(transition);
        petriNet.add(place);
        petriNet.add(place, transition, 3, EdgeType.IN);
        EdgeIn edge = (EdgeIn) transition.getEdges().get(0);
        String result = String.format(
				"RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n",
				1, 1);
		result += String.format("Place %d : %d cailloux\n", 1, 4);
		result += "=====================\nEtat des arcs :\n";
		// Transitions information
		result += String.format("  Arcs de la transition %d\n", 1);


		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1,
						3, edge.getClass().getName(), 1);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
        petriNet.triggerTransition(transition);
        assertEquals(result,petriNet.toString());
    }

    //RM0
    @Test
    void testActivateTransitionWithEdgesInAndOutAndTwoPlacesWith0And2Token (){
        Transition transition = new Transition();
        PetriNet petriNet = new PetriNet();
        Place place1 = new Place(0);
        Place place2 = new Place(2);
        petriNet.add(transition);
        petriNet.add(place1);
        petriNet.add(place2);
        petriNet.add(place1, transition, 1, EdgeType.OUT);
        petriNet.add(place2, transition, 1, EdgeType.IN);
        EdgeIn edgeIn = (EdgeIn) transition.getEdges().get(1);
        EdgeOut edgeOut = (EdgeOut) transition.getEdges().get(0);
        String result = String.format(
				"RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n",
				1, 2);
		result += String.format("Place %d : %d cailloux\n", 1, 0);
        result += String.format("Place %d : %d cailloux\n", 2, 2);
		result += "=====================\nEtat des arcs :\n";
		// Transitions information
		result += String.format("  Arcs de la transition %d\n", 1);


		result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 1,
						1, edgeOut.getClass().getName(), 1);
                        result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", 2,
						1, edgeIn.getClass().getName(), 2);
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
        petriNet.triggerTransition(transition);
        assertEquals(result,petriNet.toString());
    }
}
