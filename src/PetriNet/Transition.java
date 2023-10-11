package PetriNet;

import java.util.List;

public class Transition {
	private List<Edge> edges;

	public Transition(List<Edge> edges) {
		this.edges = edges;
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
		for (Edge edge:this.edges) {
			if (edge.getPlace()==place) {
				this.edges.remove(edge);
				return;
			}
		}
	}

}
