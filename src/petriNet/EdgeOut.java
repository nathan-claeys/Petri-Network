package petriNet;

import org.junit.jupiter.api.Test;

/**
 * @author natha
 *
 */
public class EdgeOut extends Edge {
	private int weight;
	private Place place;

	public EdgeOut(int weight, Place place) {
		super(weight,place);
	}

	/**
	 * this method will be used by the transition to know if the 
	 * edge is triggerable.
	 * @return place.count()>=weight
	 */
	public boolean isTriggerable() {
		
		return (this.place.count()>=this.weight);
	}

	/**
	 *If this function is used, it means that the associated place
	 *has the right amount of tokens. So we just remove the weight to the place.
	 */
	@Override
	public void trigger() {
		this.place.remove(this.weight);
		
	}
	

}
