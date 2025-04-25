import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordsList {
	private List<Word> words;
	
	public WordsList(List<Word> words) {
		this.words = words;
	}
	
	public WordsList() {
		this.words = new ArrayList<>();
		words.add(new Word("apple", "яблуко"));
		words.add(new Word("book", "книга"));
		words.add(new Word("cat", "кіт"));
		words.add(new Word("dog", "пес"));
		words.add(new Word("egg", "яйце"));
		words.add(new Word("fish", "риба"));
		words.add(new Word("grape", "виноград"));
		words.add(new Word("house", "будинок"));
		words.add(new Word("island", "острів"));
		words.add(new Word("jungle", "джунглі"));
		words.add(new Word("kite", "повітряний змій"));
		words.add(new Word("lamp", "лампа"));
		words.add(new Word("mountain", "гора"));
		words.add(new Word("notebook", "зошит"));
		words.add(new Word("orange", "апельсин"));
		words.add(new Word("pencil", "олівець"));
		words.add(new Word("queen", "королева"));
		words.add(new Word("rain", "дощ"));
		words.add(new Word("sun", "сонце"));
		words.add(new Word("tree", "дерево"));
		words.add(new Word("umbrella", "парасоля"));
		words.add(new Word("violin", "скрипка"));
		words.add(new Word("window", "вікно"));
		words.add(new Word("xylophone", "ксилофон"));
		words.add(new Word("yogurt", "йогурт"));
		words.add(new Word("zebra", "зебра"));
		words.add(new Word("air", "повітря"));
		words.add(new Word("ball", "м'яч"));
		words.add(new Word("cloud", "хмара"));
		words.add(new Word("dance", "танець"));
		words.add(new Word("elephant", "слон"));
		words.add(new Word("flower", "квітка"));
		words.add(new Word("guitar", "гітара"));
		words.add(new Word("hat", "капелюх"));
		words.add(new Word("ice", "лід"));
		words.add(new Word("jacket", "куртка"));
		words.add(new Word("king", "король"));
		words.add(new Word("lion", "лев"));
		words.add(new Word("moon", "місяць"));
		words.add(new Word("nest", "гніздо"));
		words.add(new Word("ocean", "океан"));
		words.add(new Word("pizza", "піца"));
		words.add(new Word("quilt", "ковдра"));
		words.add(new Word("robot", "робот"));
		words.add(new Word("star", "зірка"));
		words.add(new Word("train", "потяг"));
		words.add(new Word("universe", "всесвіт"));
		words.add(new Word("vase", "ваза"));
		words.add(new Word("water", "вода"));
		words.add(new Word("x-ray", "рентген"));
		words.add(new Word("yawn", "позіхання"));
		words.add(new Word("zipper", "блискавка"));
		words.add(new Word("banana", "банан"));
		words.add(new Word("chair", "стілець"));
		words.add(new Word("desk", "парта"));
		words.add(new Word("engine", "двигун"));
		words.add(new Word("fan", "вентилятор"));
		words.add(new Word("game", "гра"));
		words.add(new Word("hill", "пагорб"));
		words.add(new Word("ink", "чорнило"));
		words.add(new Word("jeans", "джинси"));
		words.add(new Word("key", "ключ"));
		words.add(new Word("leaf", "листок"));
		words.add(new Word("mirror", "дзеркало"));
		words.add(new Word("nail", "цвях"));
		words.add(new Word("owl", "сова"));
		words.add(new Word("pen", "ручка"));
		words.add(new Word("quiet", "тиша"));
		words.add(new Word("river", "річка"));
		words.add(new Word("snake", "змія"));
		words.add(new Word("table", "стіл"));
		words.add(new Word("uniform", "уніформа"));
		words.add(new Word("volcano", "вулкан"));
		words.add(new Word("wall", "стіна"));
		words.add(new Word("xerox", "копіювати"));
		words.add(new Word("yard", "двір"));
		words.add(new Word("zoo", "зоопарк"));
		words.add(new Word("ant", "мураха"));
		words.add(new Word("bread", "хліб"));
		words.add(new Word("circle", "коло"));
		words.add(new Word("drum", "барабан"));
		words.add(new Word("earth", "земля"));
		words.add(new Word("flag", "прапор"));
		words.add(new Word("glove", "рукавиця"));
		words.add(new Word("hammer", "молоток"));
		words.add(new Word("idea", "ідея"));
		words.add(new Word("jam", "варення"));
		words.add(new Word("kite", "змій"));
		words.add(new Word("ladder", "драбина"));
		words.add(new Word("milk", "молоко"));
		words.add(new Word("needle", "голка"));
		words.add(new Word("octopus", "восьминіг"));
		words.add(new Word("parrot", "папуга"));
		words.add(new Word("queen", "королева"));
		words.add(new Word("road", "дорога"));
		words.add(new Word("shoe", "взуття"));
		words.add(new Word("tiger", "тигр"));
		words.add(new Word("umbrella", "парасоля"));
		words.add(new Word("vacuum", "пилосос"));
		words.add(new Word("whale", "кит"));
		words.add(new Word("xenon", "ксенон"));
		words.add(new Word("yarn", "пряжа"));
		words.add(new Word("zip", "застібка"));
	}
	
	public boolean addWord(String word, String translation) {
		if (check(word)) {
			return false;
		}
		words.add(new Word(word, translation));
		return true;
	}
	
	public boolean editWord(String word, String newWord) {
		if (!check(word)) {
			return false;
		}
		getWord(word).setWord(newWord);
		return true;
	}
	
	public boolean deleteWord(String word) {
		if (!check(word)) {
			return false;
		}
		words.removeIf(word1 -> word1.getWord().equals(word));
		return true;
	}
	
	public boolean addTranslation(String word, String translation) {
		if (check(word, translation)) {
			return false;
		}
		getWord(word).getTranslations().add(translation);
		return true;
	}
	
	public boolean editTranslation(String word, String translation, String newTranslation) {
		if (!check(word, translation)) {
			return false;
		}
		getWord(word).setTranslation(translation, newTranslation);
		return true;
	}
	
	public boolean deleteTranslation(String word, String translation) {
		if (!check(word, translation)) {
			return false;
		}
		getWord(word).getTranslations().removeIf(word1 -> word1.equals(translation));
		return true;
	}
	
	public boolean check(String word) {
		return words.stream().anyMatch(word1 -> word1.getWord().equals(word));
	}
	
	public boolean check(String word, String translation) {
		return getWord(word).getTranslations().stream().anyMatch(word1 -> word1.equals(translation));
	}
	
	public Word getWord(String word) {
		return words.stream().filter(word2 -> word2.getWord().equals(word)).findFirst().get();
	}
	
	public List<Word> getTopPopular() {
		return words.stream()
				.sorted(Comparator.comparingInt(Word::getAccess).reversed())
				.limit(10)
				.collect(Collectors.toList());
	}
	
	public List<Word> getTopUnpopular() {
		return words.stream()
				.sorted(Comparator.comparingInt(Word::getAccess))
				.limit(10)
				.collect(Collectors.toList());
	}
}
