import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

// Завдання 1
// Користувач вводить з клавіатури шляхи до двох файлів.
// Програма повинна перевірити чи збігаються їх рядки.
// Якщо ні, то вивести рядки, що не збігаються із кожного з файлів
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String file1, file2;
		
		while (true) {
			System.out.println("Уведіть шлях до першого файлу: ");
			file1 = scanner.nextLine();
			
			if (Files.exists(Paths.get(file1))) break;
			
			System.out.println("Такого файлу не існує. Спробуйте ще раз.");
		}
		
		while (true) {
			System.out.println("Уведіть шлях до другого файлу: ");
			file2 = scanner.nextLine();
			
			if (Files.exists(Paths.get(file2))) break;
			
			System.out.println("Такого файлу не існує. Спробуйте ще раз.");
		}
		
		try {
			List<String>
					lines1 = Files.readAllLines(Paths.get(file1)),
					lines2 = Files.readAllLines(Paths.get(file2));
			
			if (lines1.equals(lines2)) {
				System.out.println("Списки одинакові");
				return;
			}
			
			int minSize = Math.min(lines1.size(), lines2.size());
			
			for (int i = 0; i < minSize; i++) {
				if (!lines1.get(i).equals(lines2.get(i))) {
					System.out.println("Рядок " + (i + 1) + " не співпадають у файлах");
					System.out.println("Рядок з першого файлу: \"" + lines1.get(i) + "\"");
					System.out.println("Рядок з другого файлу: \"" + lines2.get(i) + "\"");
					System.out.println();
				}
			}
			if (lines1.size() != lines2.size()) {
				System.out.println("Всі рядки, починаючи з " + (minSize + 1) + " не співпадатимуть");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}