package petriNet;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

/**
 * Reprensents a transition in a PetriNet
 * 
 * @author Cheucle
 *
 */
public class Transition {
	/**
	 * List of all edges linked to the transition
	 */
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
	public void fire() {
		boolean triggerable = true;
		for (Edge edge : this.edges) {
			if (edge instanceof EdgeOut) {
				// Remaines true only if all edges are triggerable
				// Forced cast as EdgeOut as we only check OUT edges for trigger
				triggerable &= (((EdgeOut) edge).isTriggerable());
			}
		}
		if (triggerable) {
			// Triggers all edges
			for (Edge edge : this.edges) {
				edge.trigger();
			}
		}
	}

	/**
	 * Add an edge to the transition only if it does not already exist
	 * 
	 * @param edge Edge to link to transition
	 */
	public void addEdge(Edge edge) {
		if (!this.hasEdge(edge)) {
			this.edges.add(edge);
		} else {
			throw new InvalidParameterException("An edge with that type already exists between this place and transition");
		}
	}

	/**
	 * Remove the edge linked to the transition and the given place
	 * 
	 * @param place Linked place to remove the edge from
	 */
	public void removeEdgeFromPlace(Place place) {
		// Remove edge from list only if its place is the given parameter
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

	/**
	 * Tells if an edge of the same type (in or out) already exists to the same
	 * place
	 * 
	 * @param edge edge to check
	 * @return True if an edge of the same type (in or out) already exists, false
	 *         otherwise
	 */
	private boolean hasEdge(Edge edge) {
		for (Edge e : this.edges) {
			if (e.getPlace() == edge.getPlace()) {
				if (e instanceof EdgeIn) {
					return edge instanceof EdgeIn;
				} else {
					return edge instanceof EdgeOut;
				}
			}
		}
		return false;
	}
}
