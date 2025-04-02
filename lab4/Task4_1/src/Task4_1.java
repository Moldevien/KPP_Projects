import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Task4_1 {
	public static Random r = new Random();
	
	public static void main(String[] args) {
		Car[] cars = {
				new Car("Brand 1", "aa 1111 aa", getYear(), true, SetDateRental(), getTermin()),
				new Car("Brand 2", "bb 2222 vv", getYear()),
				new Car("Brand 3", "bv 0001 ff", getYear()),
				new Car("Brand 4", "ff 2234 aa", getYear(), true, SetDateRental(), getTermin()),
				new Car("Brand 5", "ss 1234 aa", getYear()),
				new Car("Brand 6", "aa 5511 tt", getYear(), true, SetDateRental(), getTermin()),
				new Car("Brand 7", "kk 9001 mm", getYear(), true, SetDateRental(), getTermin()),
		};
		
		System.out.println("\nСписок автомобілів:");
		PrintMas(cars);
		
		// Збереження в файл
		Car.saveToFile("cars.dat", cars);
		
		// Завантаження з файлу
		Car[] loadedCars = Car.loadFromFile("cars.dat");
		System.out.println("\nДані з файлу:");
		PrintMas(loadedCars);
		
		// Сортування за роком випуску
		Arrays.sort(loadedCars);
		System.out.println("\nСписок автомобілів після сортування за роком випуску:");
		PrintMas(loadedCars);
	}
	
	private static int getYear() {
		return r.nextInt(65) + 1960;
	}
	
	private static LocalDate SetDateRental() {
		return LocalDate.now().plusDays(-r.nextInt(100));
	}
	
	private static int getTermin() {
		return r.nextInt(1000) + 1;
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
}
