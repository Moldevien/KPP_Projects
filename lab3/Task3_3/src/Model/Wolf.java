package Model;

public class Wolf extends Animal{
	public Wolf(String name) {
		super(name, true, 4);
	}
	
	@Override
	public String Sound() {
		return "Ау";
	}
}
