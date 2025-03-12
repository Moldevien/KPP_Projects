// Варіант 7
// Описати клас для зберігання даних про заданий тип об’єктів у заданій предметній області.
// При описі класу дотримуватися принципу інкапсуляції – усі поля з даними повинні бути закритими,
// а для роботи з даними, що містяться у цих полях, реалізувати відповідні методи.
// Для створення екземплярів класу реалізувати відкриті конструктори, що заповнюють поля об’єктів даними.
// Реалізувати перевантаження одного – двох методів класу та конструктора класу.
// Для демонстрації функціонування класу створити масив з 5-7 екземплярів класу.
// Для створеного масиву реалізувати:
// а) вивід на консоль даних з усіх елементів масиву;
// б) вивід даних лише тих елементів, які відповідають заданому у варіанті завдання критерію;
// в) пошук в масиві та вивід на консоль об’єктів з вказаною властивістю (згідно з варіантом).

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task3_1 {
	public static void main(String[] args) {
		Random r = new Random();
		Car[] cars = {
				new Car("Марка 1", "aa 1111 aa", r.nextInt(65) + 1960, true, SetLocalDate(-r.nextInt(100)), r.nextInt(1000) + 1),
				new Car("Марка 2", "bb 2222 vv", r.nextInt(65) + 1960),
				new Car("Марка 3", "bv 0001 ff", r.nextInt(65) + 1960),
				new Car("Марка 4", "ff 2234 aa", r.nextInt(65) + 1960, true, SetLocalDate(-r.nextInt(100)), r.nextInt(1000) + 1),
				new Car("Марка 5", "ss 1234 aa", r.nextInt(65) + 1960),
				new Car("Марка 6", "aa 5511 tt", r.nextInt(65) + 1960, true, SetLocalDate(-r.nextInt(100)), r.nextInt(1000) + 1),
				new Car("Марка 7", "kk 9001 mm", r.nextInt(65) + 1960, true, SetLocalDate(-r.nextInt(100)), r.nextInt(1000) + 1),
		};
		
		System.out.println("а) вивід на консоль даних з усіх елементів масиву");
		PrintMas(cars);
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("б) вивід даних лише тих елементів, які відповідають заданому у варіанті завдання критерію");
		System.out.println("Вивести окремо список вільних та окремо список орендованих автомобілів");
		Car[] cars2 = Arrays.stream(cars)
				.filter(car -> car.isRented())
				.toArray(Car[]::new);
		PrintMas(cars2);
		System.out.println("------------------------------------------------------------------------------------------");
		Car[] cars3 = Arrays.stream(cars)
				.filter(car -> !car.isRented())
				.toArray(Car[]::new);
		PrintMas(cars3);
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("в) пошук в масиві та вивід на консоль об’єктів з вказаною властивістю (згідно з варіантом)");
		System.out.println("Реалізувати пошук автомобілів, що звільняться з оренди у вказаному місяці");
		System.out.println("Уведіть номер місяця: ");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		
		Car[] cars4 = Arrays.stream(cars)
				.filter(car -> car.getDate() != null && car.getDate().plusDays(car.getTermin()).getMonthValue() == month)
				.toArray(Car[]::new);
		if (cars4.length == 0)
			System.out.println("Автомобілі, які звільняться з оренди у даний місяць не знайдені");
		else
			PrintMas(cars4);
	}
	
	private static void PrintMas(Car[] cars) {
		System.out.println("№\t" +
				"|Марка автомобіля\t" +
				"|Номерний знак\t" +
				"|Рік випуску\t" +
				"|Орендовано\t" +
				"|Дата оренди\t" +
				"|Термін оренди");
		for (int i = 0; i < cars.length; i++) {
			System.out.println(i + "\t|\t\t" + cars[i].toString());
		}
	}
	
	private static LocalDate SetLocalDate(int i) {
		return LocalDate.now().plusDays(i);
	}
}