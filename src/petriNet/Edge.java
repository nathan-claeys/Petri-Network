package petriNet;

/**
 * @author natha
 *An interface to represent every type of edges 
 */
public abstract class Edge {
	private int weight;
	private Place place;
	
		
	public Edge(int weight, Place place) {
		super();
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
