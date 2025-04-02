package Model;

import Interface.LibraryItem;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

// Для газети має бути назва газети, дата виходу номера, перелік основних заголовків газети
public class Newspaper implements LibraryItem {
	private String name;
	private LocalDate date;
	private List<String> headlines;
	
	public Newspaper(String name, LocalDate date, List<String> headlines) {
		setName(name);
		setDate(date);
		setHeadlines(headlines);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public List<String> getHeadlines() {
		return headlines;
	}
	
	public void setHeadlines(List<String> headlines) {
		this.headlines = headlines;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("Газета: " + name);
		System.out.println("  Дата випуску: " + date);
		System.out.println("  Заголовки:");
		for (String headline : headlines) {
			System.out.println("    - " + headline);
		}
	}
}
