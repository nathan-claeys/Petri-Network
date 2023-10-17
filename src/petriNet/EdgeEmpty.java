package petriNet;

/** Represents a specific OUT edge, only activated if the linked place is not empty and removes 
 * all tokens from it
 * @author Claeys
 *
 */
public class EdgeEmpty extends EdgeOut {

	/** EMPTY edge creation from the place. Doesn't have a weight because we don't need it to trigger 
	 * the associated place
	 * @param place
	 */
	public EdgeEmpty(Place place) {
		super(0, place);
	}
	
	/** Returns if the edge is triggerable.
	 * This edge is only triggerable when not empty
	 */
	public boolean isTriggerable() {
		return (!super.getPlace().isEmpty());
	}
	
	/** Triggers the edge.
	 * Removes all tokens from the place
	 */
	public void trigger() {
		super.getPlace().remove(super.getPlace().getCountTokens());
	}

}
