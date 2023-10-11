package petriNet;

/**
 * @author natha
 *
 */
public class EdgeEmpty extends EdgeOut {

	public EdgeEmpty(Place place) {
		super(0, place);
	}
	
	/**
	 *This edge is only triggerable when not empty
	 */
	public boolean isTriggerable() {
		return (!super.getPlace().isEmpty());
	}
	
	/**
	 *remove all tokens from the place
	 */
	public void trigger() {
		super.getPlace().remove(super.getPlace().count());
	}

}
