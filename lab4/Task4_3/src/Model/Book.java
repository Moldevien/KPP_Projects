package Model;

import Interface.LibraryItem;

// Для книги у нас має бути автор книги, назва книги, жанр, кількість сторінок
public class Book implements LibraryItem {
	private String author;
	private String name;
	private String genre;
	private int pages;
	
	public Book(String author, String name, String genre, int pages) {
		setAuthor(author);
		setName(name);
		setGenre(genre);
		setPages(pages);
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getPages() {
		return pages;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("Книга: " + name);
		System.out.println("  Автор: " + author);
		System.out.println("  Жанр: " + genre);
		System.out.println("  Сторінок: " + pages);
	}
}
