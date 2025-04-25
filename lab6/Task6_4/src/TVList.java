import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TVList {
	private List<TV> tvs;
	
	public TVList(List<TV> tvs) {
		this.tvs = tvs;
	}
	
	public TVList() {
		tvs = new ArrayList<>();
		tvs.add(new TV("LG123", 2023, 500, 32, "LG"));
		tvs.add(new TV("SamsungQLED", 2024, 1200, 55, "Samsung"));
		tvs.add(new TV("SonyX90", 2024, 999, 40, "Sony"));
		tvs.add(new TV("TCL30", 2024, 299, 30, "TCL"));
		tvs.add(new TV("PhilipsMini", 2024, 250, 28, "Philips"));
		tvs.add(new TV("SonyBravia", 2022, 1400, 65, "Sony"));
		tvs.add(new TV("SamsungNeo", 2023, 1800, 75, "Samsung"));
		tvs.add(new TV("LGNano", 2024, 1350, 55, "LG"));
		tvs.add(new TV("ToshibaLite", 2021, 220, 24, "Toshiba"));
		tvs.add(new TV("XiaomiSmart", 2024, 400, 40, "Xiaomi"));
	}
	
	public boolean add(String model, int year, double price, double diagonal, String producer) {
		if (check(model)) {
			return false;
		}
		tvs.add(new TV(model, year, price, diagonal, producer));
		return true;
	}
	
	public boolean edit(String model, String newModel, int newYear, double newPrice, double newDiagonal, String newProducer) {
		if (!check(model)) {
			return false;
		}
		getTV(model).setModel(newModel);
		getTV(model).setYear(newYear);
		getTV(model).setPrice(newPrice);
		getTV(model).setDiagonal(newDiagonal);
		getTV(model).setProducer(newProducer);
		return true;
	}
	
	public boolean delete(String model) {
		if (!check(model)) {
			return false;
		}
		tvs.removeIf(model1 -> model1.getModel().equals(model));
		return true;
	}
	
	public boolean check(String model) {
		return tvs.stream().anyMatch(model1 -> model1.getModel().equals(model));
	}
	
	public TV getTV(String model) {
		return tvs.stream().filter(model1 -> model1.getModel().equals(model)).findFirst().get();
	}
	
	public void all() {
		tvs.forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show1(double diagonal) {
		tvs.stream().filter(tv -> tv.getDiagonal() == diagonal)
				.forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show2(String producer) {
		tvs.stream().filter(tv -> tv.getProducer().equals(producer))
				.forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show3(double price) {
		tvs.stream()
				.filter(tv -> tv.getYear() == LocalDate.now().getYear())
				.filter(tv -> tv.getDiagonal() <= 30)
				.filter(tv -> tv.getPrice() >= price)
				.forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show4(double price) {
		tvs.stream().filter(tv -> tv.getPrice() > price)
				.forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show5() {
		tvs.stream().sorted(Comparator.comparingDouble(tv1 -> tv1.getPrice()))
				.forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show6() {
		tvs.stream().sorted(Comparator.comparingDouble((TV tv1) -> tv1.getDiagonal()).reversed())
				.forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show7() {
		tvs.stream()
				.collect(Collectors.groupingBy(tv1 -> tv1.getProducer()))
				.forEach((s, tv) -> System.out.println(s));
	}
	
	public void show8() {
		tvs.stream().sorted(Comparator.comparingDouble((TV tv1) -> tv1.getPrice()).reversed())
				.limit(5).forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show9() {
		tvs.stream().sorted(Comparator.comparingDouble(tv1 -> tv1.getDiagonal()))
				.limit(3).forEach(tv -> System.out.println(tv.toString()));
	}
	
	public void show10() {
		System.out.println(tvs.stream().filter(tv -> tv.getDiagonal() == 40)
				.max(Comparator.comparingDouble(tv1 -> tv1.getPrice())).get());
	}
}
