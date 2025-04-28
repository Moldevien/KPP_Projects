import java.util.Scanner;

//Завдання 2. Створити програму для роботи зі словником.
// Наприклад, англо-іспанським, французько-німецьким або будь-який інший напрям.
// Програма повинна:
// забезпечувати початковий ввід даних для словника;
// дозволяє відобразити слово і його переклади;
// дозволяє додати, замінити, видалити переклад слова;
// дозволяє додати, замінити, видалити слово;
// відображає топ-10 самих популярних слів (визначаємо популярність на базі лічильника звернень)
// відображає топ-10 самих непопулярних слів (визначаємо популярність на базі лічильника звернень).

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		WordsList wordsList = new WordsList();
		while (true) {
			System.out.println("\n1. Переклад слова");
			System.out.println("2. Додати слово");
			System.out.println("3. Змінити слово");
			System.out.println("4. Видалити слово");
			System.out.println("5. Додати переклад слова");
			System.out.println("6. Змінити переклад слова");
			System.out.println("7. Видалити переклад слова");
			System.out.println("8. Самі популярні слова");
			System.out.println("9. Самі не популярні слова");
			System.out.println("0. Вихід");
			System.out.print("Виберіть варіант: ");
			
			switch (scanner.nextLine()) {
				// Переклад слова
				case "1": {
					System.out.print("Шукане слово: ");
					String word = scanner.nextLine();
					
					if (!wordsList.check(word)) {
						System.err.println("Не знайдено");
						break;
					}
					
					System.out.println(wordsList.getWord(word).toString());
					wordsList.getWord(word).recordAccess();
					break;
				}
				// Додати слово
				case "2": {
					System.out.print("Нове слово: ");
					String word = scanner.nextLine();
					System.out.print("Його переклад: ");
					String translation = scanner.nextLine();
					
					System.out.println(wordsList.addWord(word, translation) ? "Слово додане" : "Таке слово уже є");
					break;
				}
				// Змінити слово
				case "3": {
					System.out.print("Слово для редагування: ");
					String word = scanner.nextLine();
					
					if (!wordsList.check(word)) {
						System.err.println("Не знайдено");
						break;
					}
					
					System.out.print("Нове слово: ");
					String newWord = scanner.nextLine();
					
					System.out.println(wordsList.editWord(word, newWord) ? "Оновлено!" : "Не знайдено!");
					break;
				}
				// Видалити слово
				case "4": {
					System.out.print("Слово: ");
					String word = scanner.nextLine();
					System.out.println(wordsList.deleteWord(word) ? "Видалено!" : "Не знайдено");
					break;
				}
				// Додати переклад слова
				case "5": {
					System.out.print("Слово: ");
					String word = scanner.nextLine();
					System.out.print("Його переклад: ");
					String translation = scanner.nextLine();
					
					System.out.println(wordsList.addTranslation(word, translation) ? "Переклад додано" : "Такий переклад уже є");
					break;
				}
				// Змінити переклад слова
				case "6": {
					System.out.print("Слово для пошуку: ");
					String word = scanner.nextLine();
					
					if (!wordsList.check(word)) {
						System.err.println("Не знайдено");
						break;
					}
					
					System.out.print("Переклад для редагування: ");
					String translation = scanner.nextLine();
					
					if (!wordsList.check(word, translation)) {
						System.err.println("Не знайдено");
						break;
					}
					
					System.out.print("Новий переклад: ");
					String newTranslation = scanner.nextLine();
					
					System.out.println(wordsList.editTranslation(word, translation, newTranslation) ? "Оновлено!" : "Не знайдено!");
					break;
				}
				// Видалити переклад слова
				case "7": {
					System.out.print("Слово: ");
					String word = scanner.nextLine();
					System.out.print("Його переклад: ");
					String translation = scanner.nextLine();
					System.out.println(wordsList.deleteTranslation(word, translation) ? "Видалено!" : "Не знайдено");
					break;
				}
				// Самі популярні слова
				case "8": {
					wordsList.getTopPopular().forEach(word -> System.out.println(word.toString()));
					break;
				}
				// Самі не популярні слова
				case "9": {
					wordsList.getTopUnpopular().forEach(word -> System.out.println(word.toString()));
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