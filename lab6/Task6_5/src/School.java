import java.util.Random;

public class School extends Building {
	private String level;
	private int students;
	
	public School(String address, String level) {
		super(address);
		this.level = level;
		Random rand = new Random();
		switch (level) {
			case "Загальноосвітня": {
				students = 200 + rand.nextInt(101);
				break;
			}
			case "Гімназія": {
				students = 300 + rand.nextInt(101);
				break;
			}
			case "Ліцей": {
				students = 400 + rand.nextInt(101);
				break;
			}
		}
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public int getStudents() {
		return students;
	}
	
	public void setStudents(int students) {
		this.students = students;
	}
	
	@Override
	public void setFieldsFromString(String input) {
		try {
			String[] arrayInputs = input.split(" ");
			setAddress(arrayInputs[0]);
			setLevel(arrayInputs[1]);
			setStudents(Integer.parseInt(arrayInputs[2]));
		} catch (Exception e) {
			System.err.println("Некоректний формат вводу");
		}
	}
	
	@Override
	public void displayInfo() {
		System.out.println("Адреса закладу: " + getAddress() + ", рівень: " + level + ", кількість учнів: " + students);
	}
}
