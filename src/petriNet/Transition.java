package petriNet;

import java.util.LinkedList;
import java.util.List;

public class Transition {
	private List<Edge> edges;

	public Transition(List<Edge> edges) {
		this.edges = edges;
	}
	
	public Transition() {
		this(new LinkedList<Edge>());
	}
	
	public void fire() {
		boolean triggerable = true;
		for (Edge edge : this.edges) {
			if (edge instanceof EdgeOut) {
				triggerable &= (((EdgeOut)edge).isTriggerable());
			}
		}
		if (triggerable) {
			for (Edge edge : this.edges) {
				edge.trigger();
			}
		}
	}
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}
	
	public void removeEdgeFromPlace(Place place) {
		this.edges.removeIf(edge -> (edge.getPlace() == place));
	}

}
