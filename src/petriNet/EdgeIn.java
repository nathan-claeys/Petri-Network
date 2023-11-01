package petriNet;

/**
 * Represents edge that goes inside a place. It will add its weight in tokens to
 * the place associated
 * 
 * @author Claeys
 * 
 */
public class EdgeIn extends Edge {

	/**
	 * IN edge creation from linked place and weight
	 * 
	 * @param weight
	 * @param place
	 */
	public EdgeIn(int weight, Place place) {
		super(weight, place);
	}
	
	/**
	 * IN edge creation from linked place and weight. Default weight is 1.
	 * 
	 * @param place
	 */
	public EdgeIn(Place place) {
		this(1, place);
	}

	/**
	 * Triggers the edge, giving it's associated place its weight in tokens
	 */
	@Override
	public void trigger() {
		this.getPlace().add(this.getWeight());
	}
}
