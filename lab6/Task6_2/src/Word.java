import java.util.ArrayList;
import java.util.List;

public class Word {
	private String word;
	private List<String> translations;
	private int access;
	
	public Word(String word, String translation) {
		this.word = word;
		this.translations = new ArrayList<>();
		translations.add(translation);
		this.access = 0;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public List<String> getTranslations() {
		return translations;
	}
	
	public void setTranslations(List<String> translations) {
		this.translations = translations;
	}
	
	public void setTranslation(String translation, String newTranslation) {
		int index = translations.indexOf(translation);
		if (index != -1) {
			translations.set(index, newTranslation);
		}
	}
	
	public int getAccess() {
		return access;
	}
	
	public void setAccess(int access) {
		this.access = access;
	}
	
	public void recordAccess() {
		access++;
	}
	
	@Override
	public String toString() {
		return "word = " + word +
				", translations = " + translations +
				", access = " + access;
	}
}
