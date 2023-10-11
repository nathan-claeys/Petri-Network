package petriNet;

import java.util.LinkedList;
import java.util.List;

public class PetriNet implements PetriNetwork {

	private List<Transition> listTransitions;
	private List<Place> listPlaces;
	
	public PetriNet() {
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
		Edge edge = null;
		switch (type) {
		case IN:
			edge = new EdgeIn(weight, place);
			break;

		case OUT:
			edge = new EdgeOut(weight, place);
			break;

		case ZERO:
			edge = new EdgeZero(weight, place);
			break;
			
		case EMPTY:
			edge = new EdgeEmpty(weight, place);
			break;			
		}
		
		transition.addEdge(edge);		
	}

	@Override
	public void remove(Place place) {
		this.listPlaces.remove(place);
		this.listTransitions.forEach(transition -> this.remove(place, transition));
	}

	@Override
	public void remove(Transition transition) {
		this.listTransitions.remove(transition);
	}

	@Override
	public void remove(Place place, Transition transition) {
		transition.removeEdgeFromPlace(place);
	}

}
