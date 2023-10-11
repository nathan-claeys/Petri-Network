package petriNet;

public interface PetriNetwork {
	
	public void triggerTransition(Transition transition);
	
	public void add(Place place);
	
	public void add(Transition transition);
	
	public void add(Place place, Transition transition, int weight, EdgeType type);
	
	public void remove(Place place);
	
	public void remove(Transition transition);
	
	public void remove(Place place, Transition transition);

}
