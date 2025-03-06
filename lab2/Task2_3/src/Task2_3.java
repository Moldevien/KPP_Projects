import java.util.Scanner;

public class Task2_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//ввід
		System.out.print("Уведіть пароль: ");
		String pass = scanner.nextLine();
		System.out.println();
		
		//перевірка пароля
		if (pass.length() < 8) {
			System.out.println("Пароль занадто короткий");
			return;
		}
		
		boolean bigLetter = false, smallLetter = false, number = false, special = false;
		String specialChars = "!*_.";
		
		for (char c : pass.toCharArray()) {
			if (Character.isUpperCase(c)) bigLetter = true;
			else if (Character.isLowerCase(c)) smallLetter = true;
			else if (Character.isDigit(c)) number = true;
			else if (specialChars.indexOf(c) != -1) special = true;
		}
		
		if (!bigLetter) {
			System.out.println("Пароль не має малих літер");
			return;
		}
		
		if (!smallLetter) {
			System.out.println("Пароль не має великих літер");
			return;
		}
		
		if (!number) {
			System.out.println("Пароль не має числа");
			return;
		}
		
		if (!special) {
			System.out.println("Пароль не має спеціального символу (!*_. )");
			return;
		}
		
		System.out.println("Пароль надійний!");
	}
}
