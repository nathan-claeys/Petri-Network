package petriNet;

/**
 * Describe an edge that has been triggered whereas the linked transition is not
 * triggerable.
 * Unchecked exception.
 * 
 * @author Cheucle
 *
 */
@SuppressWarnings("serial")
public class TransitionNotTriggerableException extends RuntimeException {

	public TransitionNotTriggerableException(int edgeWeight, int placeTokens) {
		super("Not enought tokens in place to trigger edge. Place's tokens : " + placeTokens + ". Edge weight : "
				+ edgeWeight);
	}

}
