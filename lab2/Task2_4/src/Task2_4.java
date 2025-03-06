import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2_4 {
	public static void main(String[] args) {
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
				"Ut nec odio Motivation, varius purus sagittis, molestie justo. " +
				"Cras eu ligula nisl. Nullam Situation ligula sed sollicitudin faucibus. " +
				"Suspendisse Situation, erat ultricies placerat imperdiet, Motivation quam tempor risus, " +
				"vestibulum lobortis ante est non risus. Duis sagittis, odio eget tristique maximus, " +
				"elit mi varius nisi, quis elementum lacus odio a mi. Donec fringilla felis tortor, " +
				"a gravida turpis Motivation sit amet. Nullam viverra Situation at dolor suscipit, " +
				"quis rhoncus ipsum commodo. Nam mi sem, rhoncus id aliquet vitae, varius posuere ex. " +
				"Ut congue consequat venenatis. Morbi aliquam viverra tempus.";
		
		//Вивід тексту
		System.out.println("Заданий текст:");
		System.out.println(text);
		System.out.println();
		
		//пошук слів
		Pattern pattern = Pattern.compile("[A-Z][a-z]{1,8}tion[.,!?:;]");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println("Знайдене слово: " + matcher.group());
		}
	}
}
