package petriNet;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author natha
 *This class represent edge that goes inside a place
 */
public class EdgeIn extends Edge {
	private int weight;
	private Place place;

	public EdgeIn(int weight, Place place) {
		super(weight,place);
	}

	/**
	 *Every time the edgeIn is triggered, it will give
	 *it's associated place it weight in tokens
	 */
	@Override
	public void trigger() {
		this.place.add(this.weight);		
	}

	@Test
	public void testGetPlace() {
		Place place = null;
		EdgeIn edge = new EdgeIn(3,place);
		Place p2 = edge.getPlace();
		assertEquals(p2,place);
		
	}
	@Test
	public void testGetWeight() {
		Place place = null;
		EdgeIn edge = new EdgeIn(3,place);
		int w = edge.getWeight();
		assertEquals(w,3);
		
	}
}
