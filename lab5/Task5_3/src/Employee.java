public class Employee {
	private int id;
	private String firstName;
	private String surName;
	private int age;
	
	public Employee(int id, String surName, String firstName, int age) {
		this.id = id;
		setFirstName(firstName);
		setSurName(surName);
		setAge(age);
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + ", Прізвище: " + firstName + ", Ім'я: " + surName + ", Вік: " + age;
	}
}
