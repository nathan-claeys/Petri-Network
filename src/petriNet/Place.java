package petriNet;

import java.security.InvalidParameterException;

/**
 * Reprensents a Place in a PetriNet
 * 
 * @author Cheucle
 *
 */
public class Place {

	private int countTokens;

	/**
	 * Constructor
	 * 
	 * @param countTokens Initial number of tokens in the place (abs value if
	 *                    negative)
	 */
	public Place(int countTokens) {
		this.countTokens = Math.abs(countTokens);
	}

	/**
	 * Count place's tokens
	 * 
	 * @return number of current tokens
	 */
	public int getCountTokens() {
		return this.countTokens;
	}

	/**
	 * Test if the place is empty (no token)
	 * 
	 * @return is place empty
	 */
	public boolean isEmpty() {
		return (this.countTokens == 0);
	}

	/**
	 * Add tokens to place
	 * 
	 * @param count Number of tokens to add
	 */
	public void add(int count) {
		if (count <= 0) {
			throw new InvalidParameterException();
		} else {
			this.countTokens += count;
		}
	}

	/**
	 * Remove tokens from place
	 * 
	 * @param count Number of tokens to remove
	 */
	public void remove(int count) {
		if (count <= 0 || count > this.countTokens) {
			throw new InvalidParameterException();
		} else {
			this.countTokens -= count;
		}
	}

}
