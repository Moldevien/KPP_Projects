package Model;

import java.time.LocalDate;

// Реалізуйте клас «Людина» (ім’я, прізвище, дата народження)
public class People {
	private String firstName;
	private String lastName;
	private LocalDate date;
	
	public People(String firstName, String lastName, LocalDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = birthDate;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", date=" + date;
	}
}
