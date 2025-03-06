public class Task2_1 {
	public static void main(String[] args) {
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
				"Ut nec odio imperdiet, varius purus sagittis, molestie justo. " +
				"Cras eu ligula nisl. Nullam vestibulum ligula sed sollicitudin faucibus. " +
				"Suspendisse fringilla, erat ultricies placerat imperdiet, nibh quam tempor risus, " +
				"vestibulum lobortis ante est non risus. Duis sagittis, odio eget tristique maximus, " +
				"elit mi varius nisi, quis elementum lacus odio a mi. Donec fringilla felis tortor, " +
				"a gravida turpis condimentum sit amet. Nullam viverra turpis at dolor suscipit, " +
				"quis rhoncus ipsum commodo. Nam mi sem, rhoncus id aliquet vitae, varius posuere ex. " +
				"Ut congue consequat venenatis. Morbi aliquam viverra tempus.";
		
		//Вивід тексту
		System.out.println("Заданий текст:");
		System.out.println(text);
		System.out.println();
		
		//Текст розділений на слова
		String[] textSplit = text.split(" ");
		//Текст розділений на речення
		String[] textSentence = text.split("\\.");
		
		System.out.println("Кількість слів у тексті: " + textSplit.length);
		System.out.println("Кількість речень: " + textSentence.length);
		System.out.println();
		
		//пошук найдовшого речення
		String longSentence = "";
		for (String sent : textSentence)
			if (sent.length() > longSentence.length())
				longSentence = sent;
		
		System.out.println("Найдовше речення: " + longSentence);
		System.out.println();
		
		//цензурні слова
		String[] badWords = {"odio", "varius", "mi", "vestibulum", "sagittis", "turpis"};
		
		//цензура тексту
		String textWithoutBadWords = text;
		for (String badWord : badWords)
			textWithoutBadWords = textWithoutBadWords.replaceAll(badWord, "*".repeat(badWord.length()));
		
		System.out.println("Текст з цензурой:");
		System.out.println(textWithoutBadWords);
	}
}
