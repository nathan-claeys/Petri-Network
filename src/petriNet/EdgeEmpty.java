package petriNet;

/** Reprensents a specific OUT edge, only activated if the linked place is not empty
 * @author Claeys
 *
 */
public class EdgeEmpty extends EdgeOut {

	/** EMPTY edge creation from the place. Doesn't have a weight
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
	
	/** Trigger the edge.
	 * Remove all tokens from the place
	 */
	public void trigger() {
		super.getPlace().remove(super.getPlace().count());
	}

}
