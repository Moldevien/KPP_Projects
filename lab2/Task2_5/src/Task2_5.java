import java.security.AccessControlContext;
import java.util.Scanner;

public class Task2_5 {
	public static void main(String[] args) {
		//текст приклад
		String emailText = "test@gmail.ru gmail@gmail.com user@gmail.ru";
		
		String[] text = emailText.split(" ");
		
		//прибирання непотрібних речень
		for (String mail : text) {
			String[] mas = mail.split("\\.");
			if (mas[mas.length - 1].equals("ru"))
				emailText = emailText.replaceAll(mail, "");
		}
		
		System.out.println("Рядок без доменів .ru");
		System.out.println(emailText);
		
	}
}
