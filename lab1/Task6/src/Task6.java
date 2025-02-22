import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Уведіть масив чисел: ");
		
		String[] line = scanner.nextLine().split(" ");
		Double[] ar = new Double[line.length];
		for (int i = 0; i < line.length; i++)
			ar[i] = Double.parseDouble(line[i]);
		
		int imax = 0;
		for (int i = 0; i < ar.length; i++)
			if (ar[i] > ar[imax])
				imax = i;
		
		Arrays.sort(ar, 0, imax);
		Arrays.sort(ar, imax+1, ar.length, Collections.reverseOrder());
		
		for (double a : ar) System.out.print(a + " ");
	}
}
