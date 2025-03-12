package Model;

import java.time.LocalDate;
import java.util.Arrays;

// Magazine (назва журналу поле типу Frequency з інформацією про періодичність виходу журналу,
// дата виходу журналу, тираж журналу, полі типу Article[] зі списком статей у журналі).
public class Magazine {
	private String name;
	private Frequency frequency;
	private LocalDate date;
	private int circulation;
	private Article[] articles;
	
	public Magazine(String name, Frequency frequency, LocalDate publicationDate, int circulation, Article[] articles) {
		this.name = name;
		this.frequency = frequency;
		this.date = publicationDate;
		this.circulation = circulation;
		this.articles = articles;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Frequency getFrequency() {
		return frequency;
	}
	
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public int getCirculation() {
		return circulation;
	}
	
	public void setCirculation(int circulation) {
		this.circulation = circulation;
	}
	
	public Article[] getArticles() {
		return articles;
	}
	
	public void setArticles(Article[] articles) {
		this.articles = articles;
	}
	
	@Override
	public String toString() {
		return "name='" + name + '\'' +
				", frequency=" + frequency +
				", date=" + date +
				", circulation=" + circulation +
				", articles=" + Arrays.toString(articles);
	}
}
