import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Уведіть числа: ");
		try {
			//Ввід
			String[] line = scanner.nextLine().split(" ");
			
			int[] a = new int[line.length];
			
			for (int i = 0; i < line.length; i++)
				a[i] = Integer.parseInt(line[i]);
			
			//Нормалізація
			System.out.print("Проведемо нормалізацію: ");
			a = Arrays.stream(a).sorted().toArray();
			
			for (int b : a)
				System.out.print(b + " ");
			
			//Пошук
			System.out.print("\nНепарні числа: ");
			for (int b : a)
				if (b % 2 == 1)
					System.out.print(b + " ");
			
		} catch (Exception e) {
			System.out.println("Сталась помилка " + e.getMessage() + "\nспробуйте знову наступного разу");
		}
	}
}