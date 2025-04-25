import java.util.Arrays;
import java.util.List;

public class Shop extends Building {
	private String type;
	private List<String> departments;
	
	public Shop(String address, String type, List<String> departments) {
		super(address);
		this.type = type;
		this.departments = departments;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<String> getDepartments() {
		return departments;
	}
	
	public void setDepartments(List<String> departments) {
		this.departments = departments;
	}
	
	@Override
	public void setFieldsFromString(String input) {
		try {
			String[] arrayInputs = input.split(" ");
			setAddress(arrayInputs[0]);
			setType(arrayInputs[1]);
			setDepartments(Arrays.asList(Arrays.copyOfRange(arrayInputs, 2, arrayInputs.length)));
		} catch (Exception e) {
			System.err.println("Некоректний формат вводу");
		}
	}
	
	@Override
	public void displayInfo() {
		System.out.println("Адреса магазину: " + getAddress() + ", тип магазину: " + type + ", кількість відділів відділи: " + departments);
	}
}
