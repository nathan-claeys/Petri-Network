package petriNet;

import java.security.InvalidParameterException;

/**
 * This is an abstract Class to describe the theoretical shape of an edge : a
 * weight and a place associated a trigger method and some getters
 * 
 * @author Claeys
 */
public abstract class Edge {
	/**
	 * Weight of the edge. Represent the quantity of tokens to add/remove to/from
	 * place.
	 */
	
	private int weight;
	/**
	 * Linked place of the edge. The edge can point to the place, or point out of
	 * the place.
	 */
	private Place place;

	/**
	 * Building an edge linked to a place
	 * 
	 * @param weight
	 * @param place  Place to link
	 */
	public Edge(int weight, Place place) {
		if (weight <= 0) {
			throw new InvalidParameterException("Edge weight must be positive");
		}
		this.weight = weight;
		this.place = place;
	}

	/**
	 * Building an edge linked to a place. Weight is 1 by default.
	 * 
	 * @param place Place to link
	 */
	public Edge(Place place) {
		this(1, place);
	}

	/**
	 * Triggers the edge
	 * 
	 * @throws TransitionNotTriggerableException if the edge is trigger whereas it
	 *                                           is not triggerable
	 */
	abstract void trigger() throws TransitionNotTriggerableException;

	/**
	 * Return the associated place
	 * 
	 * @return Place
	 */
	public Place getPlace() {
		return this.place;
	};

	/**
	 * Return the weight of the edge
	 * 
	 * @return weight
	 */
	public int getWeight() {
		return this.weight;
	}

}
