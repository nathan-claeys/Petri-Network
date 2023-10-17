package petriNet;


/**
 * @author natha
 *This class represent edge that goes inside a place
 */
public class EdgeIn extends Edge {
	private int weight;
	private Place place;

	public EdgeIn(int weight, Place place) {
		super(weight,place);
	}

	/**
	 *Every time the edgeIn is triggered, it will give
	 *it's associated place it weight in tokens
	 */
	@Override
	public void trigger() {
		this.place.add(this.weight);		
	}
}
