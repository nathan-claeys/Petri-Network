package petriNet;

/** Reprensents a Place in a PetriNet
 * @author Cheucle
 *
 */
public class Place {

	private int countTokens;

	/** Constructor
	 * @param countTokens Initial number of tokens in the place
	 */
	public Place(int countTokens) {
		this.countTokens = countTokens;
	}
	
	/** Count place's tokens
	 * @return number of current tokens
	 */
	public int count() {
		return this.countTokens;
	}
	
	/** Test if the place is empty (no token)
	 * @return is place empty
	 */
	public boolean isEmpty() {
		return (this.countTokens == 0);
	}
	
	/** Add tokens to place
	 * @param count Number of tokens to add
	 */
	public void add(int count) {
		this.countTokens += count;
	}
	
	/** Remove tokens from place
	 * @param count Number of tokens to remove
	 */
	public void remove(int count) {
		this.countTokens -= count;
	}
	
}
