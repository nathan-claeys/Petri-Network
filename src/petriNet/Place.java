package petriNet;

public class Place {

	private int countTokens;

	public Place(int countTokens) {
		this.countTokens = countTokens;
	}
	
	public int count() {
		return this.countTokens;
	}
	
	public boolean isEmpty() {
		return (this.countTokens == 0);
	}
	
	public void add(int count) {
		this.countTokens += count;
	}
	
	public void remove(int count) {
		this.countTokens -= count;
	}
	
}
