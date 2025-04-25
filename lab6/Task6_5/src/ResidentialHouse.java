public class ResidentialHouse extends Building {
	private int people;
	
	public ResidentialHouse(String address, int people) {
		super(address);
		this.people = people;
	}
	
	public int getPeople() {
		return people;
	}
	
	public void setPeople(int people) {
		this.people = people;
	}
	
	@Override
	public void setFieldsFromString(String input) {
		try {
			String[] arrayInputs = input.split(" ");
			setAddress(arrayInputs[0]);
			setPeople(Integer.parseInt(arrayInputs[1]));
		} catch (Exception e) {
			System.err.println("Некоректний формат вводу");
		}
	}
	
	@Override
	public void displayInfo() {
		System.out.println("Адреса житлового будинку: " + getAddress() + ", кількість мешканців: " + people);
	}
}
