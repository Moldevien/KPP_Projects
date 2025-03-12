package Model;

public class Tiger extends Animal {
	public Tiger(String name) {
		super(name, true, 5);
	}
	
	@Override
	public String Sound() {
		return "Ррррр";
	}
}
