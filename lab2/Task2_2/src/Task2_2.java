public class Task2_2 {
	public static void main(String[] args) {
		StringBuilder text = new StringBuilder("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
				"Ut nec odio imperdiet, varius purus sagittis, molestie justo. " +
				"Cras eu ligula nisl. Nullam vestibulum ligula sed sollicitudin faucibus. " +
				"Suspendisse fringilla, erat ultricies placerat imperdiet, nibh quam tempor risus, " +
				"vestibulum lobortis ante est non risus. Duis sagittis, odio eget tristique maximus, " +
				"elit mi varius nisi, quis elementum lacus odio a mi. Donec fringilla felis tortor, " +
				"a gravida turpis condimentum sit amet. Nullam viverra turpis at dolor suscipit, " +
				"quis rhoncus ipsum commodo. Nam mi sem, rhoncus id aliquet vitae, varius posuere ex. " +
				"Ut congue consequat venenatis. Morbi aliquam viverra tempus.");
		
		//Вивід тексту
		System.out.println("Заданий текст:");
		System.out.println(text);
		System.out.println();
		
		// Отримання підрядка
		System.out.println("Підрядок:");
		System.out.println(text.substring(15, 100));
		System.out.println();
		
		// Додавання підрядків
		text.append(" WORD");
		text.insert(50, " I`M HERE");
		System.out.println("Модифікований рядок:");
		System.out.println(text);
		System.out.println();
		
		// Видалення або заміна підрядка
		text.delete(5, 15);
		text.insert(5, "DELETE");
		System.out.println("Після змін: " + text);
	}
}
