import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Corporation {
	private List<Employee> employees;
	private int guid = 0;
	
	public Corporation(List<Employee> employees) {
		this.employees = new ArrayList<>(employees);
		this.guid = employees.stream()
				.mapToInt(Employee::getId)
				.max().orElse(0) + 1;
	}
	
	public void add(String lastName, String firstName, int age) {
		employees.add(new Employee(guid++, lastName, firstName, age));
	}
	
	public boolean edit(int id, String surName, String firstName, int age) {
		for (Employee emp : employees) {
			if (emp.getId() == id) {
				emp.setFirstName(firstName);
				emp.setSurName(surName);
				emp.setAge(age);
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(int id) {
		return employees.removeIf(emp -> emp.getId() == id);
	}
	
	public List<Employee> searchByLastName(String lastName) {
		List<Employee> list = new ArrayList<>();
		for (Employee e : employees) {
			if (e.getSurName().equalsIgnoreCase(lastName)) {
				list.add(e);
			}
		}
		return list;
	}
	
	public List<Employee> getAllSortedByAge() {
		List<Employee> list = new ArrayList<>();
		for (Employee employee : employees) {
			list.add(employee);
		}
		list.sort(Comparator.comparingInt(Employee::getAge));
		return list;
	}
	
	public List<Employee> getAllByFirstLetter(char letter) {
		List<Employee> list = new ArrayList<>();
		for (Employee e : employees) {
			if (!e.getSurName().isEmpty() && e.getSurName().charAt(0) == letter) {
				list.add(e);
			}
		}
		return list;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
}
