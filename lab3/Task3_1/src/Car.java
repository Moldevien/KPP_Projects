import java.time.LocalDate;

// Предметна область: оренда автомобілів, клас: автомобіль, орієнтовний перелік полів:
// марка автомобіля, номерний знак, рік випуску, автомобіль орендовано (так/ні), дата оренди, термін оренди.
// Вивести окремо список вільних та окремо список орендованих автомобілів.
// Реалізувати пошук автомобілів, що звільняться з оренди у вказаному місяці.

public class Car {
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
		this.termin = termin > 0 ? termin : 0;
	}
	
	@Override
	public String toString() {
		return brand + "\t\t|\t"
				+ license_plate + "\t|\t"
				+ year + "\t\t|\t"
				+ (rented ? "так\t\t|\t" + date + "\t|\t" + termin + " днів"
				: "\t\t|\t\t\t\t|");
	}
}