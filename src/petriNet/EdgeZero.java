package petriNet;

/**
 * @author natha
 *
 */
public class EdgeZero extends EdgeOut {

	public EdgeZero(Place place) {
		super(0, place);
	}
	
	/**
	 *This edge is triggerable when the place is empty
	 *@return place.isEmpty()
	 */
	public boolean isTriggerable() {
		return super.getPlace().isEmpty();
	}
	
	/**
	 *this function has no utility, we cannot remove token 
	 *from an empty place
	 */
	public void trigger() {
	}

}