package petriNet;

/** Reprensents an edge that goes towards the transition
 * @author Claeys
 *
 */
public class EdgeOut extends Edge {
	private int weight;
	private Place place;

	/** OUT edge creation from linked place and weight
	 * @param weight
	 * @param place
	 */
	public EdgeOut(int weight, Place place) {
		super(weight,place);
	}

	/** Return if the edge is triggerable, ie if its place has more tokens than the weight
	 * @return is edge triggerable
	 */
	public boolean isTriggerable() {
		
		return (this.place.count()>=this.weight);
	}

	/** Trigger the edge, removing the weight of the edge from place's tokens
	 */
	@Override
	public void trigger() {
		this.place.remove(this.weight);
		
	}
	

}
