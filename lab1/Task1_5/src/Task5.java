import java.util.ArrayList;
import java.util.Random;

public class Task5 {
	public static void main(String[] args) {
		// Заповнення масиву випадковими числами
		Random random = new Random();
		int[] ar = new int[50];
		for (int i = 0; i < ar.length; i++) ar[i] = random.nextInt(100) - 50;
		
		System.out.println("Початковий масив:");
		printArray(ar);
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		ArrayList<Integer> list4 = new ArrayList<>();
		
		for (int num : ar) {
			// Парні числа
			if (num % 2 == 0) list1.add(num);
			
			// Числа Фібоначчі
			if (isFibonacci(num)) list2.add(num);
			
			// Від’ємні > -17
			if (num > -17 && num < 0) list3.add(num);
			
			// Прості числа
			if (isPrime(num)) list4.add(num);
		}
		
		// Перетворення у масиви
		int[][] mas = {
				convertListToArray(list1),
				convertListToArray(list2),
				convertListToArray(list3),
				convertListToArray(list4)
		};
		
		System.out.println("\nПарні числа:");
		printArray(mas[0]);
		System.out.println("\nЧисла Фібоначчі:");
		printArray(mas[1]);
		System.out.println("\nВід’ємні числа > -17:");
		printArray(mas[2]);
		System.out.println("\nПрості числа:");
		printArray(mas[3]);
	}
	
	// Перевірка чисел Фібоначчі
	public static boolean isFibonacci(int num) {
		if (num < 0) return false;
		int a = 0, b = 1;
		while (b < num) {
			int temp = a + b;
			a = b;
			b = temp;
		}
		return num == a || num == b;
	}
	
	// Перевірка простих чисел
	public static boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	// Перетворення у масив
	public static int[] convertListToArray(ArrayList<Integer> list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	// Виведення масиву
	public static void printArray(int[] array) {
		for (int num : array) System.out.print(num + " ");
		System.out.println();
	}
}
