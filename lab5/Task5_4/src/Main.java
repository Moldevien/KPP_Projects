import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

// Завдання 4
// Користувач вводить шлях до каталогу з файлами.
// Створіть програмний код, що дозволить створити копію файлів з каталогу та записати їх у новостворений каталог за шляхом, що вказує користувач.
// (Можна замінити введення даних користувачем на зчитування шляхів до каталогів з файлу – на розсуд студента).
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Введіть шлях до вихідного каталогу: ");
		String sourceDir = scanner.nextLine();
		
		System.out.print("Введіть шлях до цільового каталогу: ");
		String targetDir = "lab5/Task5_4/src/" + scanner.nextLine();
		
		try {
			Path sourcePath = Paths.get(sourceDir);
			Path targetPath = Paths.get(targetDir);
			
			// Перевірка чи існує вихідний каталог
			if (!Files.isDirectory(sourcePath)) {
				throw new NoSuchFileException("Вихідний каталог не існує або не є каталогом");
			}
			
			Files.createDirectories(targetPath);
			
			// Копіювання файлів
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourcePath)) {
				for (Path file : stream) {
					if (Files.isRegularFile(file)) {
						Path targetFile = targetPath.resolve(file.getFileName());
						Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Скопійовано: " + file.getFileName());
					}
				}
			}
			System.out.println("Копіювання успішно завершено!");
		} catch (IOException e) {
			System.err.println("Помилка копіювання: " + e.getMessage());
		}
	}
}