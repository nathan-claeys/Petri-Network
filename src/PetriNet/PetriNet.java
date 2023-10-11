package PetriNet;

import java.util.LinkedList;
import java.util.List;

public class PetriNet implements PetriNetwork {

	private List<Edge> listEdges;
	private List<Transition> listTransitions;
	private List<Place> listPlaces;
	
	public PetriNet() {
		this.listEdges = new LinkedList<Edge>();
		this.listTransitions = new LinkedList<Transition>();
		this.listPlaces = new LinkedList<Place>();
	}

	@Override
	public void triggerTransition(Transition transition) {
		transition.fire();
		
	}

	@Override
	public void add(Place place) {
		this.listPlaces.add(place);
		
	}

	@Override
	public void add(Transition transition) {
		this.listTransitions.add(transition);
		
	}

	@Override
	public void add(Place place, Transition transition, int weight, EdgeType type) {
		this.listEdges.add(new Edge(place, transition, weight));
		
	}

	@Override
	public void remove(Place place) {
		this.listPlaces.remove(place);
		
	}

	@Override
	public void remove(Transition transition) {
		this.listTransitions.remove(transition);
		
	}

	@Override
	public void remove(Place place, Transition transition) {
		this.listEdges.remove(new Edge(place, transition, 0));
	}

}
