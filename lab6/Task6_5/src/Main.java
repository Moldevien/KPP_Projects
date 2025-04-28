public class Main {
	public static void main(String[] args) {
		Street street = new Street(StreetFactory.generateStreet());
		
		Menu menu = new Menu(street);
		menu.start();
	}
}