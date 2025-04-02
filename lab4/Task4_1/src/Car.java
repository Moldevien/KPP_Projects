import java.io.*;
import java.time.LocalDate;

public class Car implements Serializable, Comparable<Car> {
	private static final long serialVersionUID = 1L;
	
	private String brand;
	private String license_plate;
	private int year;
	private boolean rented;
	private LocalDate date;
	private int termin; //days
	
	public Car(String brand, String license_plate, int year, boolean rented, LocalDate date, int termin) {
		setBrand(brand);
		setLicense_plate(license_plate);
		setYear(year);
		setRented(rented);
		setDate(date);
		setTermin(termin);
	}
	
	public Car(String brand, String license_plate, int year) {
		setBrand(brand);
		setLicense_plate(license_plate);
		setYear(year);
		setRented(false);
	}
	
	// Brand
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		if (brand == null || brand.isEmpty())
			this.brand = "Невідомо";
		else
			this.brand = brand;
	}
	
	// License plate
	public String getLicense_plate() {
		return license_plate;
	}
	
	public void setLicense_plate(String license_plate) {
		if (license_plate == null || license_plate.isEmpty())
			this.license_plate = "Невідомо";
		else {
			String[] s = license_plate.split(" ");
			if (s.length == 3 && s[1].matches("\\d+")) {
				this.license_plate = license_plate;
			} else {
				System.out.println("Невірний формат номерного знака: " + license_plate);
			}
		}
	}
	
	// Year
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		int currentYear = LocalDate.now().getYear();
		if (year > 1960 && year <= currentYear)
			this.year = year;
		else
			this.year = 0;
	}
	
	// Rented
	public boolean isRented() {
		return rented;
	}
	
	public void setRented(boolean rented) {
		this.rented = rented;
	}
	
	// Date
	public LocalDate getDate() {
		return rented ? date : null;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	// Termin
	public int getTermin() {
		return rented ? termin : 0;
	}
	
	public void setTermin(int termin) {
		this.termin = Math.max(termin, 0);
	}
	
	@Override
	public String toString() {
		return brand + "\t\t|\t"
				+ license_plate + "\t|\t"
				+ year + "\t\t|\t"
				+ (rented ? "так\t\t|\t" + date + "\t|\t" + termin + " днів"
				: "\t\t|\t\t\t\t|");
	}
	
	@Override
	public int compareTo(Car other) {
		int result = this.year - other.year;
		if (result == 0) result = this.termin - other.termin;
		if (result == 0) result = license_plate.compareTo(other.license_plate);
		return result;
	}
	
	// Метод для запису масиву автомобілів у файл
	public static void saveToFile(String filename, Car[] cars) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(cars);
			System.out.println("Дані успішно збережені у файл.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Метод для читання масиву автомобілів з файлу
	public static Car[] loadFromFile(String filename) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			return (Car[]) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new Car[0];
	}
}
