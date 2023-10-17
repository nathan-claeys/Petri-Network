package petriNet;


/** This is an abstract Class to describe the theoretical shape of an edge : a weight and a place associated 
 * a trigger method and some getters 
 * @author Claeys
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
	

	/**
	 * This method return the associated place, it is used to find the right edge to delete from
	 * the petriNet class
	 * @return Place
	 */
	Place getPlace() {
		return this.place;
	};
	
	
	
	/**
	 * Return the weight of the edge, is used in petriNet toString method
	 * @return weight
	 */
	int getWeight() {
		return this.weight;
	}

}
