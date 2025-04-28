import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Завдання 3
// Напишіть інформаційну систему “Корпорація”.
// Програма повинна забезпечувати:
// − введення даних;
// − редагування даних співробітника корпорації;
// − видалення співробітника корпорації;
// − пошук співробітника корпорації за прізвищем;
// − вивід інформації про усіх співробітників(за віком; за прізвищем, що розпочинається з відповідної літери).
// Організуйте можливість збереження знайденої інформації у файл - звіт.
// Врахувати, що список співробітників зберігається у файлі.
// При старті програми проходить завантаження списку співробітників корпорації із вказаного користувачем файлу.
// При виході з програми – автоматично іде перезапис інформації у файл, якщо список співробітників був оновлений.
// У процесі виконання програми за командою користувача, може бути виконано перезапис файлу, що містить список співробітників.

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean isModified = false;
	private static Corporation corporation;
	private static String PATH = "lab5/Task5_3/src/Працівники.txt";
	
	public static void main(String[] args) {
		corporation = new Corporation(load(PATH));
		System.out.println("Дані завантажено.");
		
		while (true) {
			System.out.println("\n1. Додати співробітника");
			System.out.println("2. Редагувати співробітника");
			System.out.println("3. Видалити співробітника");
			System.out.println("4. Пошук співробітника за прізвищем");
			System.out.println("5. Вивести співробітників за віком");
			System.out.println("6. Вивести співробітників за літерою");
			System.out.println("7. Зберегти дані");
			System.out.println("0. Вийти");
			System.out.print("Виберіть варіант: ");
			
			switch (scanner.nextInt()) {
				case 1: {
					scanner.nextLine();
					System.out.print("Прізвище: ");
					String lastName = scanner.nextLine();
					System.out.print("Ім'я: ");
					String firstName = scanner.nextLine();
					System.out.print("Вік: ");
					int age = scanner.nextInt();
					corporation.add(lastName, firstName, age);
					System.out.println("Співробітник доданий!");
					isModified = true;
					break;
				}
				case 2: {
					scanner.nextLine();
					System.out.print("ID для редагування: ");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Нове прізвище: ");
					String lastName = scanner.nextLine();
					System.out.print("Нове ім'я: ");
					String firstName = scanner.nextLine();
					System.out.print("Новий вік: ");
					int age = scanner.nextInt();
					boolean success = corporation.edit(id, lastName, firstName, age);
					System.out.println(success ? "Оновлено!" : "ID не знайдено!");
					isModified = true;
					break;
				}
				case 3: {
					scanner.nextLine();
					System.out.print("ID для видалення: ");
					int id = scanner.nextInt();
					boolean success = corporation.delete(id);
					System.out.println(success ? "Видалено!" : "ID не знайдено!");
					isModified = true;
					break;
				}
				case 4: {
					scanner.nextLine();
					System.out.print("Прізвище: ");
					String lastName = scanner.nextLine();
					List<Employee> result = corporation.searchByLastName(lastName);
					printEmployees(result);
					break;
				}
				case 5: {
					List<Employee> employees = corporation.getAllSortedByAge();
					printEmployees(employees);
					
					saveReport(employees);
					break;
				}
				case 6: {
					scanner.nextLine();
					System.out.print("Літера: ");
					List<Employee> employees = corporation.getAllByFirstLetter(scanner.nextLine().toUpperCase().charAt(0));
					printEmployees(employees);
					
					saveReport(employees);
					break;
				}
				case 7: {
					save();
					break;
				}
				case 0: {
					if (isModified) {
						save();
					}
					System.out.println("Кінець роботи");
					System.exit(0);
					break;
				}
				default: {
					System.err.println("Такого варіанту немає");
					break;
				}
			}
		}
	}
	
	private static List<Employee> load(String filePath) {
		List<Employee> employees = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			//boolean firstLine = true;
			
			while ((line = reader.readLine()) != null) {
//				if (firstLine) {
//					firstLine = false;
//					continue;
//				}
				
				String[] parts = line.split(", ");
				
				try {
					int id = Integer.parseInt(parts[0].trim());
					String lastName = parts[1].trim();
					String firstName = parts[2].trim();
					int age = Integer.parseInt(parts[3].trim());
					employees.add(new Employee(id, lastName, firstName, age));
				} catch (NumberFormatException e) {
					System.err.println("Помилка у рядку: " + line);
				}
			}
		} catch (IOException e) {
			System.err.println("Помилка: " + e.getMessage());
		}
		
		return employees;
	}
	
	private static void save() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
			for (Employee emp : corporation.getEmployees()) {
				writer.write(emp.toString() + "\n");
			}
			isModified = false;
			
			System.out.println("Дані збережено!");
		} catch (IOException e) {
			System.err.println("Помилка: " + e.getMessage());
		}
	}
	
	private static void saveReport(List<Employee> employees) {
		System.out.println("Зберегти зібрану інформацію у звіт? (так/ні)");
		scanner.nextLine();
		String answer = scanner.nextLine();
		
		if (answer.equalsIgnoreCase("так")) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("lab5/Task5_3/src/Звіт.txt"))) {
				for (Employee e : employees) {
					writer.write(e.toString() + "\n");
				}
				System.out.println("Звіт збережено!");
			} catch (IOException e) {
				System.err.println("Помилка: " + e.getMessage());
			}
		}
	}
	
	private static void printEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println("Нічого не знайдено!");
			return;
		}
		
		System.out.println(
				"ID\tПрізвище\t\tІм'я\t\tВік");
		employees.forEach(e -> System.out.println(
				e.getId() + "\t" + e.getSurName() + "\t\t\t" + e.getFirstName() + "\t\t\t" + e.getAge()));
	}
}