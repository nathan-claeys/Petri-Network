package petriNet;

/** An abstract class to represent every type of edges
 * @author Claeys
 * 
 */
public abstract class Edge {
	private int weight;
	private Place place;
	
		
	/** Building an edge linked to a place
	 * @param weight
	 * @param place Place to link
	 */
	public Edge(int weight, Place place) {
		this.weight = weight;
		this.place = place;
	}

	/**
	 * This method will be used to trigger every edge from the transition associated
	 */
	abstract void trigger();

	Place getPlace() {
		return this.place;
	};
	
	int getWeight() {
		return this.weight;
	};

}
