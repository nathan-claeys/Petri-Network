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
	 *
	 */
	public boolean isTriggerable() {
		return (!this.place.isEmpty());
	}

}
