package petriNet;

/**
 * Reprensents an edge that goes towards the transition
 * 
 * @author Claeys
 *
 */
public class EdgeOut extends Edge {

	/**
	 * OUT edge creation from linked place and weight
	 * 
	 * @param weight
	 * @param place
	 */
	public EdgeOut(int weight, Place place) {
		super(weight, place);
	}

	/**
	 * OUT edge creation from linked place and weight. Default weight is 1
	 * 
	 * @param place
	 */
	public EdgeOut(Place place) {
		this(1, place);
	}
	
	/**
	 * Returns if the edge is triggerable, ie if its place has more tokens than the
	 * weight
	 * 
	 * @return is edge triggerable
	 */
	public boolean isTriggerable() {
		return (this.getPlace().getCountTokens() >= this.getWeight());
	}

	/**
	 * Triggers the edge, removing the weight of the edge from place's tokens
	 * 
	 * @throws TransitionNotTriggerableException if the edge is trigger whereas it
	 *                                           is not triggerable
	 */
	@Override
	public void trigger() throws TransitionNotTriggerableException {
		if (!this.isTriggerable()) {
			throw new TransitionNotTriggerableException(this.getWeight(), this.getPlace().getCountTokens());
		}
		this.getPlace().remove(this.getWeight());

	}

}
