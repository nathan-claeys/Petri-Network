package petriNet;


/** This is an abstract Class to describe the theoretical shape of an edge : a weight and a place associated 
 * a trigger method and some getters 
 * @author Claeys
 */
public abstract class Edge {
	protected int weight;
	protected Place place;
	
		
	/** Building an edge linked to a place
	 * @param weight
	 * @param place Place to link
	 */
	public Edge(int weight, Place place) {
		this.weight = weight;
		this.place = place;
	}

	/**
	 * Trigger every edge from the transition associated
	 */
	abstract void trigger();
	

	/**
	 * Return the associated place
	 * @return Place
	 */
	public Place getPlace() {
		return this.place;
	};
	
	
	
	/**
	 * Return the weight of the edge
	 * @return weight
	 */
	public int getWeight() {
		return this.weight;
	}

}
