package Model;

// Створити базовий клас «Тварина» та похідні класи “Тигр”, “Кролик”, “Вовк”, “Кенгуру”.
// За допомогою конструкторів встановити ім’я кожної тварини та її характеристики, визначте метод,
// який повертає рядок, який містить відображення звуку, що видається тваринам, а також інші необхідні методи та поля.
public abstract class Animal {
	private String name;
	private boolean isPredator;
	private double foodQuantity;
	
	public Animal(String name, boolean isPredator, double foodQuantity) {
		this.name = name;
		this.isPredator = isPredator;
		this.foodQuantity = foodQuantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isPredator() {
		return isPredator;
	}
	
	public double getFoodQuantity() {
		return foodQuantity;
	}
	
	public void setFoodQuantity(double foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	
	public abstract String Sound();
	
	@Override
	public String toString() {
		return name + " говорить: " + Sound();
	}
}
