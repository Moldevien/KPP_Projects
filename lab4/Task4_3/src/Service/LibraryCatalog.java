package Service;

import Interface.LibraryItem;
import Model.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
	private List<LibraryItem> items;
	
	public LibraryCatalog() {
		this.items = new ArrayList<>();
	}
	
	public void add(LibraryItem item) {
		items.add(item);
		System.out.println("Додано: " + item.getName());
	}
	
	public void remove(String title) {
		items.removeIf(item -> item.getName().equalsIgnoreCase(title));
		System.out.println("Видалено: " + title);
	}
	
	public void showLibrary() {
		if (items.isEmpty()) {
			System.out.println("Каталог порожній.");
			return;
		}
		System.out.println("Каталог бібліотеки:");
		for (LibraryItem item : items) {
			item.displayInfo();
			System.out.println("-------------------");
		}
	}
	
	public void searchByTitle(String title) {
		boolean found = false;
		for (LibraryItem item : items) {
			if (item.getName().equalsIgnoreCase(title)) {
				item.displayInfo();
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Нічого не знайдено за назвою: " + title);
		}
	}
	
	public void searchByAuthor(String author) {
		boolean found = false;
		for (LibraryItem item : items) {
			if (item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author)) {
				item.displayInfo();
				found = true;
			}
		}
		if (!found) {
			System.out.println("Нічого не знайдено за автором: " + author);
		}
	}
}