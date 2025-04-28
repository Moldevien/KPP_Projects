import java.util.Scanner;

//Завдання1. Необхідно розробити програму, яка дозволить зберігати інформацію про авторизаціє користувачів.
// Кожному користувачеві відповідає пара логін та пароль.
// При старті програма відображає меню:
//	Додати нового користувача;
//	Видалити існуючого користувача;
//	Перевірити чи існує користувач;
//	Змінити  логін існуючого користувача;
//	Змінити пароль користувача;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		UsersList usersList = new UsersList();
		
		while (true) {
			System.out.println("\n1. Додати користувача");
			System.out.println("2. Видалити користувача");
			System.out.println("3. Перевірити існування користувача");
			System.out.println("4. Змінити логін");
			System.out.println("5. Змінити пароль");
			System.out.println("6. Переглянути список");
			System.out.println("0. Вийти");
			System.out.print("Виберіть варіант: ");
			
			switch (scanner.nextLine()) {
				// Додавання
				case "1": {
					// Ввід
					System.out.print("Логін: ");
					String login = scanner.nextLine();
					System.out.print("Пароль: ");
					String pass1 = scanner.nextLine();
					System.out.print("Повторний пароль: ");
					String pass2 = scanner.nextLine();
					
					// Перевірка паролів
					if (!pass1.equals(pass2)) {
						System.err.println("Паролі не схожі!");
						break;
					}
					
					// Додавання
					System.out.println(usersList.add(login, pass1) ? "Співробітник доданий" : "Такий користувач уже існує");
					break;
				}
				// Видалити
				case "2": {
					System.out.print("Логін для видалення: ");
					String login = scanner.nextLine();
					System.out.println(usersList.delete(login) ? "Видалено!" : "Не знайдено");
					break;
				}
				// Перевірити існування
				case "3": {
					System.out.print("Логін для пошуку: ");
					String login = scanner.nextLine();
					System.out.println(usersList.check(login) ? "Знайдено!" : "Не знайдено!");
					break;
				}
				// Змінити логін
				case "4": {
					System.out.print("Логін для редагування: ");
					String login = scanner.nextLine();
					
					if (!usersList.check(login)) {
						System.err.println("Не знайдено");
						break;
					}
					
					System.out.print("Пароль для перевірки: ");
					String pass = scanner.nextLine();
					
					if (!usersList.getUser(login).getPass().equals(pass)) {
						System.err.println("Паролі не співпадають");
						break;
					}
					
					System.out.print("Новий логін: ");
					String newLogin = scanner.nextLine();
					
					System.out.println(usersList.editLogin(login, newLogin) ? "Оновлено!" : "Не знайдено!");
					break;
				}
				// Змінити пароль
				case "5": {
					System.out.print("Логін для редагування: ");
					String login = scanner.nextLine();
					
					if (!usersList.check(login)) {
						System.err.println("Не знайдено");
						break;
					}
					
					System.out.print("Пароль для перевірки: ");
					String pass = scanner.nextLine();
					
					if (!usersList.getUser(login).getPass().equals(pass)) {
						System.err.println("Паролі не співпадають");
						break;
					}
					
					System.out.print("Новий пароль: ");
					String newPass = scanner.nextLine();
					
					System.out.println(usersList.editPass(login, newPass) ? "Оновлено!" : "Не знайдено!");
					break;
				}
				// Переглянути список
				case "6": {
					usersList.showAll();
					break;
				}
				// Вийти
				case "0": {
					System.out.println("Кінець роботи");
					System.exit(0);
					break;
				}
				// Помилка
				default: {
					System.err.println("Такого варіанту немає");
					break;
				}
			}
		}
	}
}