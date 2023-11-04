package petriNet;

/**
 * Enum representing the four edges types. IN represents an edge directed from
 * the transition to the place. OUT represents an edge directed from the place
 * to the transition. ZERO is a specific OUT edge, activated if the place is
 * empty. EMPTY is a specitif OUT edge, actived is the place is not empty It is
 * used to describe the edge we want to build between a place and a transition.
 * 
 * @author Cheucle
 *
 */
public enum EdgeType {
	IN, OUT, ZERO, EMPTY
}
