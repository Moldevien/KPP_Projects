import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		TVList tvList = new TVList();
		while (true) {
			System.out.println("\n1. Показати усі телевізори");
			System.out.println("2. Показати телевізори із заданою діагоналлю");
			System.out.println("3. Показати усі телевізори одного виробника");
			System.out.println("4. Показати усі телевізори цього року з діагоналлю, що не перевищує 30 дюймів, та ціною, що не менше ніж задана користувачем");
			System.out.println("5. Показати усі телевізори дорожчі за задану ціну");
			System.out.println("6. Показати усі телевізори, відсортовані за ціною за зростанням");
			System.out.println("7. Показати усі телевізори, відсортовані по діагоналі за зменшенням");
			System.out.println("8. Показати групи телевізорів, відповідно до країни виробника");
			System.out.println("9. Показати 5 найдорожчих телевізорів");
			System.out.println("10. Показати 3 телевізори з найменшою діагоналлю");
			System.out.println("11. Показати останній найдорожчий телевізор з діагоналлю 40 дюймів");
			System.out.println("0. Вихід");
			System.out.print("Виберіть варіант: ");
			
			switch (scanner.nextLine()) {
				case "1": {
					tvList.all();
					break;
				}
				case "2": {
					tvList.show1(40);
					break;
				}
				case "3": {
					tvList.show2("Sony");
					break;
				}
				case "4": {
					tvList.show3(300);
					break;
				}
				case "5": {
					tvList.show4(100);
					break;
				}
				case "6": {
					tvList.show5();
					break;
				}
				case "7": {
					tvList.show6();
					break;
				}
				case "8": {
					tvList.show7();
					break;
				}
				case "9": {
					tvList.show8();
					break;
				}
				case "10": {
					tvList.show9();
					break;
				}
				case "11": {
					tvList.show10();
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