package Model;

public class Kangaroo extends Animal {
	public Kangaroo(String name) {
		super(name, false, 3);
	}
	
	@Override
	public String Sound() {
		return "Кррр";
	}
	
}
