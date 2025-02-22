import java.util.ArrayList;
import java.util.Random;

public class Task5 {
	public static void main(String[] args) {
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
			if (num % 2 == 0) list1.add(num); // Парні
			
			if (isFibonacci(num)) list2.add(num); // Числа Фібоначчі
			
			if (num > -17 && num < 0) list3.add(num); // Від’ємні > -17
			
			if (isPrime(num)) list4.add(num); // Прості
		}
		
		System.out.println("\nПарні числа:");
		printArray(list1);
		System.out.println("\nЧисла Фібоначчі:");
		printArray(list2);
		System.out.println("\nВід’ємні числа > -17:");
		printArray(list3);
		System.out.println("\nПрості числа:");
		printArray(list4);
	}
	
	// Перевірка чи число належить до чисел Фібоначчі
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
	
	// Перевірка, чи число є простим
	public static boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	// Виведення одновимірного масиву
	public static void printArray(int[] array) {
		for (int num : array) System.out.print(num + " ");
		System.out.println();
	}
	
	// Виведення ArrayList
	public static void printArray(ArrayList<Integer> array) {
		for (int num : array) System.out.print(num + " ");
		System.out.println();
	}
}
