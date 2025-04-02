package Model;

import Interface.LibraryItem;

import java.util.List;

// Характеристиками альманаху є назва альманаху та перелік творів (книг), які у ньому надруковані
public class Almanac implements LibraryItem {
	private String name;
	private List<Book> books;
	
	public Almanac(String name, List<Book> books) {
		setName(name);
		setBooks(books);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("Альманах: " + name);
		System.out.println("  Включає книги:");
		for (Book book : books) {
			System.out.println("    - " + book.getName() + " (Автор: " + book.getAuthor() + ")");
		}
	}
}
