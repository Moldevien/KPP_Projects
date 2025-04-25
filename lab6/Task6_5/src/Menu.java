import java.util.Random;
import java.util.Scanner;

public class Menu {
	private Street street;
	
	public Menu(Street street) {
		this.street = street;
	}
	
	public void start() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n1. Вивести всю вулицю");
			System.out.println("2. Додати будинок");
			System.out.println("3. Видалити будинок");
			System.out.println("4. Знайти магазини з відділом поруч із житловим будинком");
			System.out.println("0. Вихід");
			System.out.print("Виберіть варіант: ");
			
			switch (scanner.nextLine()) {
				case "1": {
					street.all();
					break;
				}
				case "2": {
					System.out.print("Введіть адресу нового житлового будинку: ");
					String address = scanner.nextLine();
					System.out.println(
							street.add(new ResidentialHouse(address, 10 + new Random().nextInt(90))) ?
									"Будівлю додано" : "Місце зайняте уже є");
					break;
				}
				case "3": {
					System.out.print("Введіть адресу будинку для видалення: ");
					System.out.println(street.delete(scanner.nextLine()) ? "Видалено!" : "Не знайдено");
					break;
				}
				case "4": {
					System.out.print("Введіть адресу житлового будинку: ");
					String address = scanner.nextLine();
					System.out.print("Околиця (діапазон пошуку): ");
					int r = Integer.parseInt(scanner.nextLine());
					System.out.print("Відділ: ");
					String d = scanner.nextLine();
					street.searchShopsNear(address, r, d);
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