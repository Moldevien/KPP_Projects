public abstract class Building {
	private String address;
	
	public Building(String address) {
		this.address = address;
	}
	
	public Building() {}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public abstract void setFieldsFromString(String input); // віртуальний метод
	
	public abstract void displayInfo(); // для виводу інформації
}