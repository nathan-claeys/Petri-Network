package petriNet;

/**
 * Represents a specific OUT edge, only activated if the linked place is empty
 * 
 * @author Claeys
 *
 */
public class EdgeZero extends EdgeOut {

	/**
	 * ZERO edge creation from the place. Doesn't have a weight
	 * 
	 * @param place
	 */
	public EdgeZero(Place place) {
		super(0, place);
	}

	/**
	 * Returns if the edge is triggerable. This edge is only triggerable when not
	 * empty
	 */
	public boolean isTriggerable() {
		return this.getPlace().isEmpty();
	}

	/**
	 * Triggers the edge. Do nothing.
	 */
	public void trigger() {
	}

}
