import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task6 {
	public static void main(String[] args) {
		//Ввід
		Scanner scanner = new Scanner(System.in);
		System.out.println("Уведіть масив чисел: ");
		
		String[] line = scanner.nextLine().split(" ");
		Double[] ar = new Double[line.length];
		for (int i = 0; i < line.length; i++)
			ar[i] = Double.parseDouble(line[i]);
		
		//Пошук найбільшого
		int imax = 0;
		for (int i = 0; i < ar.length; i++)
			if (ar[i] > ar[imax])
				imax = i;
		
		//Сортування за збільшенням
		Arrays.sort(ar, 0, imax);
		//Сортування за зменшенням
		Arrays.sort(ar, imax + 1, ar.length, Collections.reverseOrder());
		
		//Вивід
		for (double a : ar) System.out.print(a + " ");
	}
}
