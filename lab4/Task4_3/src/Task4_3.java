import Model.Almanac;
import Model.Book;
import Model.Newspaper;
import Service.LibraryCatalog;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task4_3 {
	public static void addRandomItem(LibraryCatalog catalog) {
		Random r = new Random();
		int choice = r.nextInt(3);
		switch (choice) {
			case 0:
				catalog.add(new Book("Автор " + r.nextInt(100), "Книга " + r.nextInt(1000), "Фантастика", 200 + r.nextInt(300)));
				break;
			case 1:
				List<String> headlines = List.of("Новина 1", "Новина 2", "Новина 3");
				catalog.add(new Newspaper("Газета " + r.nextInt(50), LocalDate.now().minusDays(r.nextInt(30)), headlines));
				break;
			case 2:
				List<Book> books = List.of(new Book("Автор A", "Книга A", "Роман", 250));
				catalog.add(new Almanac("Альманах " + r.nextInt(20), books));
				break;
		}
	}
	
	public static void testLibrary(LibraryCatalog catalog) {
		catalog.add(new Book("Дж. К. Ролінг", "Гаррі Поттер", "Фентезі", 500));
		catalog.add(new Book("Джордж Оруелл", "1984", "Антиутопія", 350));
		catalog.add(new Newspaper("Київські Вісті", LocalDate.of(2025, 3, 15), List.of("Політика", "Економіка", "Спорт")));
		catalog.add(new Almanac("Літературний Вісник", List.of(new Book("Л. Толстой", "Війна і мир", "Історичний роман", 1200))));
	}
	
	/* Для каталогу передбачити:
	можливість тестової ініціалізації,
	додавання об'єкта конкретного типу,
	додавання об'єкта випадкового типу,
	видалення об'єкта за назвою,
	виведення всього каталогу на екран,
	пошук за назвою книги або газети,
	пошук за автором*/
	public static void main(String[] args) {
		LibraryCatalog catalog = new LibraryCatalog();
		testLibrary(catalog);
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nМеню:");
			System.out.println("1. Додати книгу");
			System.out.println("2. Додати випадковий об'єкт");
			System.out.println("3. Видалити за назвою");
			System.out.println("4. Показати каталог");
			System.out.println("5. Пошук за назвою");
			System.out.println("6. Пошук за автором");
			System.out.println("0. Вихід");
			System.out.print("Виберіть опцію: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
				case 1: {
					catalog.add(new Book("Стівен Кінг", "Воно", "Хоррор", 900));
					break;
				}
				case 2: {
					addRandomItem(catalog);
					break;
				}
				case 3: {
					System.out.print("Введіть назву: ");
					catalog.remove(scanner.nextLine());
					break;
				}
				case 4: {
					catalog.showLibrary();
					break;
				}
				case 5: {
					System.out.print("Введіть назву: ");
					catalog.searchByTitle(scanner.nextLine());
					break;
				}
				case 6: {
					System.out.print("Введіть автора: ");
					catalog.searchByAuthor(scanner.nextLine());
					break;
				}
				case 0: {
					return;
				}
			}
		}
	}
}
