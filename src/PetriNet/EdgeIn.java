package PetriNet;

/**
 * @author natha
 *
 */
public class EdgeIn implements Edge {
	private int weight;
	private Place place;

	public EdgeIn(int weight, Place place) {
		super();
		this.weight = weight;
		this.place = place;
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
