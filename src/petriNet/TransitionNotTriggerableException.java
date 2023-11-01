package petriNet;

public class TransitionNotTriggerableException extends Exception {
	
	public TransitionNotTriggerableException(int edgeWeight, int placeTokens) {
		super("Not enought tokens in place to trigger edge. Place's tokens : " + placeTokens + ". Edge weight : " + edgeWeight);
	}

}
