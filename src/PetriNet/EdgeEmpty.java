package PetriNet;

/**
 * @author natha
 *
 */
public class EdgeEmpty extends EdgeOut {

	public EdgeEmpty(int weight, Place place) {
		super(weight, place);
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
