import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Уведіть декілька чисел:");
		int i = 0;
		int a = 1000;
		while (true) {
			System.out.print("Число " + (i + 1) + ": ");
			int b = scanner.nextInt();
			scanner.nextLine();
			if (b < 0) {
				System.out.println("Число повинно бути додатним");
				continue;
			}
			if (b < 10) break;
			if (a > b) a = b;
			i++;
		}
		System.out.println("Мінімальне число: "+ a);
	}
}
