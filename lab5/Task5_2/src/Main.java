import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// Завдання 2
// Користувач отримує шлях до каталогу з текстовими файлами, які необхідно перевірити на наявність заборонених слів.
// Перелік заборонених слів необхідно отримати з файлу, що розташований у корені проєкту.
// Користувачу на екран потрібно вивести детальну інформацію про файли,
// що містять заборонені слова (які заборонені слова та їх кількість).
// Далі необхідно запропонувати користувачу виправити файли шляхом заміни символів заборонених слів символом ‘*’ (зірочка).
// Цю пропозицію потрібно пропонувати для кожного файлу окремо та виправляти файл лише за згодою користувача.
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			DirectoryStream<Path> directory = Files.newDirectoryStream(
					Path.of("lab5\\Task5_2\\src\\TXTfiles"));
			List<String> badWords = Files.readAllLines(Paths.get("badWords.txt"));
			
			for (Path path : directory) {
				String text = Files.readString(path).toLowerCase();
				
				String[] textSplit = text.split(" ");
				
				Map<String, Integer> badWordsMap = new HashMap<>();
				
				for (String badWord : badWords) {
					int count = 0;
					
					for (int i = 0; i < textSplit.length; i++)
						if (badWord.equals(textSplit[i]))
							count++;
					
					if (count > 0) badWordsMap.put(badWord, count);
				}
				
				if (!badWordsMap.isEmpty()) {
					System.out.println("Файлі \"" + path.getFileName() + "\" містить такі заборонені слова:");
					badWordsMap.forEach((key, value) -> System.out.println(key + ": " + value));
				}
				
				System.out.print("Бажаєте замінити заборонені слова на *? (так/ні): ");
				String edit = scanner.nextLine();
				
				if (edit.equals("так")) {
					for (String badWord : badWords)
						text = text.replaceAll(badWord, "*".repeat(badWord.length()));
					
					Files.writeString(path, text);
					System.out.println("Файл оновлено: " + path.getFileName());
				}
			}
			
			for (String badWord : badWords) System.out.println(badWord);
		} catch (IOException e) {
			System.err.println("Сталася помилка: " + e.getMessage());
		}
	}
}