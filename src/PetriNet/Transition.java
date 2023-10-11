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
				triggerable &= (((EdgeOut)edge).isTriggeable());
			}
		}
		if (triggerable) {
			for (Edge edge : this.edges) {
				edge.trigger();
			}
		}
	}

}
