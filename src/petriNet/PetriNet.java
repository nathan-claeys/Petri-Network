package petriNet;

import java.util.LinkedList;
import java.util.List;

/** An implementation of a Petri network
 * @author Cheucle
 *
 */
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
			edge = new EdgeZero(place);
			break;
			
		case EMPTY:
			edge = new EdgeEmpty(place);
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

	/** Show the current state of the network. Print the details of transitions (source, target, weight) and places (current token count)
	 *
	 */
	public String toString() {
		String result = String.format("RAPPORT DE L'ETAT DU RESEAU\nNombre de transitions : %d \nNombre de places : %d\n\n=====================\nEtat des places :\n", this.listTransitions.size(), this.listPlaces.size());
		int index = 1;
		for (Place place : listPlaces) {
			result += String.format("Place %d : %d cailloux\n", index++, place.count());
		}
		result += "=====================\nEtat des arcs :\n";
		index = 1;
		for (Transition transition : listTransitions) {
			result += String.format("  Arcs de la transition %d\n", index++);
			
			int edgeindex = 1;
			for (Edge edge : transition.getEdges()) {
				result += String.format("    Arc %d - Poids : %d , Type : %s, Cible : Place %d\n", edgeindex++, edge.getWeight(), edge.getClass().getName(), this.listPlaces.indexOf(edge.getPlace())+1);
			}
		}
		result += "FIN DU RAPPORT\n----------------------------------------------\n";
		return result;
	}
	
}
