package petriNet;

/**
 * Describe an edge that has been triggered whereas the linked transition is not
 * triggerable.
 * Unchecked exception.
 * 
 * @author Cheucle
 *
 */
public class TransitionNotTriggerableException extends RuntimeException {

	private static final long serialVersionUID = -548610143447987471L;

	public TransitionNotTriggerableException(int edgeWeight, int placeTokens) {
		super("Not enought tokens in place to trigger edge. Place's tokens : " + placeTokens + ". Edge weight : "
				+ edgeWeight);
	}

}
