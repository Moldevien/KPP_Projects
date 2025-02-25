import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
	public static int ab, bc, gas, mas;
	
	public static void main(String[] args) {
		try {
			Load();
			
			//Перевірка файлу
			int speed;
			if (mas < 0 || gas < 0 || ab < 0 || bc < 0) {
				System.out.println("Помилка у файлі");
				return;
			}
			
			//Вивід інформації
			System.out.println("відтань від A до B: " + ab);
			System.out.println("відтань від B до C: " + bc);
			System.out.println("Об'єм топлива: " + gas);
			System.out.println("Маса вантажу: " + mas);
			
			//Пошук швидкості
			switch (mas / 500) {
				case 1: { speed = 1; break;	}
				case 2: { speed = 4; break;	}
				case 3: { speed = 7; break;	}
				case 4: { speed = 9; break;	}
				default: { System.out.println("Літак не полетить"); return; }
			}
			
			System.out.println("Швидкість: " + speed);
			
			//Переліт 1
			if (speed * gas < ab) {
				System.out.println("Літаку не хватило топлива що долетіти до пункту B");
				return;
			}
			
			//Перевірка
			System.out.println("Літаку хватило топлива що долетіти до пункту B");
			
			gas -= ab / speed;
			
			int a = bc / speed;
			System.out.println("Літаку необхідно " + a + " літрів топлива, щоб долетіти до пункту С");
			
			System.out.println("Об'єм топлива: " + gas);
			
			if (gas >= a)
				System.out.println("У літаку достатньо топлива");
			else
				System.out.println("Літаку було дозаправлено: " + (a - gas) + " літрів");
			
			//Переліт 2
			if (speed * a < bc) {
				System.out.println("Літаку не хватило топлива що долетіти до пункту D");
				return;
			}
			
			System.out.println("Літак успішно долетів до пункту C");
		} catch (Exception e) {
			System.out.println("Сталася помилка: " + e.getMessage());
		}
	}
	
	//Робота з файлом
	public static void Load() {
		try (Scanner scanner = new Scanner(new FileReader("data.txt"))) {
			ab = Integer.parseInt(scanner.nextLine());
			bc = Integer.parseInt(scanner.nextLine());
			gas = Integer.parseInt(scanner.nextLine());
			mas = Integer.parseInt(scanner.nextLine());
		} catch (IOException ex) {
			System.out.println("Помилка з файлом: " + ex.getMessage());
		} catch (NumberFormatException ex) {
			System.out.println("Помилка в форматі даних: " + ex.getMessage());
		}
	}
}
