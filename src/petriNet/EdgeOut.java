package petriNet;

/** Reprensents an edge that goes towards the transition
 * @author Claeys
 *
 */
public class EdgeOut extends Edge {

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
		
		return (super.place.count()>=super.weight);
	}

	/** Trigger the edge, removing the weight of the edge from place's tokens
	 */
	@Override
	public void trigger() {
		super.place.remove(super.weight);
		
	}
	

}
