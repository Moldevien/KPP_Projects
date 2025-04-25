public class TV {
	private String model;
	private int year;
	private double price;
	private double diagonal;
	private String producer;
	
	public TV(String model, int year, double price, double diagonal, String producer) {
		this.model = model;
		this.year = year;
		this.price = price;
		this.diagonal = diagonal;
		this.producer = producer;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getDiagonal() {
		return diagonal;
	}
	
	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	@Override
	public String toString() {
		return model + ", " + year + ", " + price + ", " + diagonal + ", " + producer;
	}
}
