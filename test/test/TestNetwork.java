package test;

import petriNet.EdgeType;
import petriNet.PetriNet;
import petriNet.Place;
import petriNet.Transition;

public class TestNetwork {
	
	public static void test1() {
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
	
	public static void test2() {
		PetriNet petri = new PetriNet();
		Place placeIn = new Place(1);
		Place placeOut = new Place(0);
		Transition transi = new Transition();
		petri.add(placeIn);
		petri.add(placeOut);
		petri.add(transi);
		petri.add(placeIn, transi, 2, EdgeType.OUT);
		petri.add(placeOut, transi, 1, EdgeType.IN);
		
		petri.triggerTransition(transi);
		
		System.out.println(petri);

	}
	public static void test3() {
		PetriNet petri = new PetriNet();
		Place placeIn = new Place(0);
		Place placeOut = new Place(0);
		Transition transi = new Transition();
		petri.add(placeIn);
		petri.add(placeOut);
		petri.add(transi);
		petri.add(placeIn, transi, 2, EdgeType.ZERO);
		petri.add(placeOut, transi, 2, EdgeType.IN);
		
		petri.triggerTransition(transi);
		
		System.out.println(petri);

	}
	public static void test4() {
		PetriNet petri = new PetriNet();
		Place placeIn = new Place(1);
		Place placeOut = new Place(0);
		Transition transi = new Transition();
		petri.add(placeIn);
		petri.add(placeOut);
		petri.add(transi);
		petri.add(placeIn, transi, 2, EdgeType.ZERO);
		petri.add(placeOut, transi, 2, EdgeType.IN);
		
		petri.triggerTransition(transi);
		
		System.out.println(petri);

	}
	
	public static void test5() {
		PetriNet petri = new PetriNet();
		Place placeIn = new Place(0);
		Place placeOut = new Place(0);
		Transition transi = new Transition();
		petri.add(placeIn);
		petri.add(placeOut);
		petri.add(transi);
		petri.add(placeIn, transi, 2, EdgeType.EMPTY);
		petri.add(placeOut, transi, 2, EdgeType.IN);
		
		petri.triggerTransition(transi);
		
		System.out.println(petri);

	}
	public static void test6() {
		PetriNet petri = new PetriNet();
		Place placeIn = new Place(5);
		Place placeOut = new Place(0);
		Transition transi = new Transition();
		petri.add(placeIn);
		petri.add(placeOut);
		petri.add(transi);
		petri.add(placeIn, transi, 2, EdgeType.EMPTY);
		petri.add(placeOut, transi, 2, EdgeType.IN);
		
		petri.triggerTransition(transi);
		System.out.println(petri);

	}
	
	public static void main(String[] args) {
		System.out.println("test 1 :");
		test1(); //Expected : 1 2 2
		System.out.println("test 2 :");
		test2(); //Expected : 1 0
		System.out.println("test 3 :");
		test3(); //Expected : 0 2 
		System.out.println("test 4 :");
		test4();// Expected : 1 0 
		System.out.println("test 5 :");
		test5();// Expected : 0 0 
		System.out.println("test 6 :");
		test6();// Expected : 0 2 
	}
}
