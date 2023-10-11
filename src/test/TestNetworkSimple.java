package test;

import java.util.LinkedList;

import petriNet.Edge;
import petriNet.EdgeType;
import petriNet.PetriNet;
import petriNet.Place;
import petriNet.Transition;

public class TestNetworkSimple {

	public static void main(String[] args) {
		PetriNet petri = new PetriNet();
		Place placeIn = new Place(3);
		Place placeOut1 = new Place(1);
		Place placeOut2 = new Place(0);
		Transition transi = new Transition();
		petri.add(placeIn);
		petri.add(placeOut1);
		petri.add(placeOut2);
		petri.add(transi);
		petri.add(placeIn, transi, 2, EdgeType.OUT);
		petri.add(placeOut1, transi, 1, EdgeType.IN);
		petri.add(placeOut2, transi, 2, EdgeType.IN);
		
		petri.triggerTransition(transi);
		
		//petri.getListPlaces().forEach(place -> System.out.println(place.count()));
		System.out.println(petri);
	}

}
