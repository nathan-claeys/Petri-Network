package petriNet;

/** Interface representing the Petri network. Can be implemented to build and modify the network.
 * @author Cheucle
 *
 */
public interface PetriNetwork {
	
	/** Trigger a transition
	 * @param transition Transition to trigger
	 */
	public void triggerTransition(Transition transition);
	
	/** Add a place to the network
	 * @param place
	 */
	public void add(Place place);
	
	/** Add a transition to the network
	 * @param transition
	 */
	public void add(Transition transition);
	
	/** Add an edge to the network
	 * @param place Connected place
	 * @param transition Connected transition
	 * @param weight Weight of the edge between the place and the transition
	 * @param type Type of edge (including if it is an In (towards place) or Out (towards transition) edge)
	 */
	public void add(Place place, Transition transition, int weight, EdgeType type);
	
	/** Remove a place from the network. Will also remove all edges linked to this place
	 * @param place Place to remove
	 */
	public void remove(Place place);
	
	/** Remove a transition from the network
	 * @param transition Transition to remove
	 */
	public void remove(Transition transition);
	
	/** Remove the edge from the network between a given place and transition.
	 * @param place Place linked to edge
	 * @param transition Transition linked to edge
	 */
	public void remove(Place place, Transition transition);

}
