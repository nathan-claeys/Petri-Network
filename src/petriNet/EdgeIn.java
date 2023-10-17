package petriNet;


/** Represents edge that goes inside a place
 * @author Claeys
 * 
 */
public class EdgeIn extends Edge {
	private int weight;
	private Place place;

	/** IN edge creation from linked place and weight
	 * @param weight
	 * @param place
	 */
	public EdgeIn(int weight, Place place) {
		super(weight,place);
	}

	/**
	 * Trigger the edge, giving it's associated place its weight in tokens
	 */
	@Override
	public void trigger() {
		this.place.add(this.weight);		
	}
}
