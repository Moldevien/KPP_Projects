package Model;

public class Rabbit extends Animal{
	public Rabbit(String name) {
		super(name, false, 1);
	}
	
	@Override
	public String Sound() {
		return "Пі-пі";
	}
}
