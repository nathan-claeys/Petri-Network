package petriNet;

import java.util.LinkedList;
import java.util.List;

/**
 * Reprensents a transition in a PetriNet
 * 
 * @author Cheucle
 *
 */
public class Transition {
	private List<Edge> edges;

	/**
	 * Transition creation from a pre-build edges list
	 * 
	 * @param edges List of edges
	 */
	public Transition(List<Edge> edges) {
		this.edges = edges;
	}

	/**
	 * Empty transition creation
	 * 
	 */
	public Transition() {
		this(new LinkedList<Edge>());
	}

	/**
	 * Trigger a transition. Will update all linked places
	 * 
	 * @throws TransitionNotTriggerableException
	 * 
	 */
	public void fire() throws TransitionNotTriggerableException {
		boolean triggerable = true;
		for (Edge edge : this.edges) {
			if (edge instanceof EdgeOut) {
				triggerable &= (((EdgeOut) edge).isTriggerable());
			}
		}
		if (triggerable) {
			for (Edge edge : this.edges) {
				edge.trigger();
			}
		}
	}

	/**
	 * Add an edge to the transition
	 * 
	 * @param edge Edge to link to transition
	 */
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	/**
	 * Remove the edge linked to the transition and the given place
	 * 
	 * @param place Linked place to remove the edge from
	 */
	public void removeEdgeFromPlace(Place place) {
		this.edges.removeIf(edge -> (edge.getPlace() == place));
	}

	/**
	 * Get all linked edges
	 * 
	 * @return List of edges linked to transition
	 */
	public List<Edge> getEdges() {
		return edges;
	}

}
