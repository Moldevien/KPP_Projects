package Model;

// Визначте класи Article (автор статті («Людина»), назва статті, рейтинг статті)
public class Article {
	private People people;
	private String title;
	private int rating;
	
	public Article(People people, String title, int rating) {
		this.people = people;
		this.title = title;
		this.rating = rating;
	}
	
	public People getPeople() {
		return people;
	}
	
	public void setPeople(People people) {
		this.people = people;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "people=" + people +
				", title='" + title + '\'' +
				", rating=" + rating;
	}
}
