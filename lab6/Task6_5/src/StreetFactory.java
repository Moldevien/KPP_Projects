import java.util.ArrayList;
import java.util.List;

public class StreetFactory {
	public static List<Building> generateStreet() {
		return new ArrayList<>(List.of(
				new ResidentialHouse("вул. Київська, 1", 35),
				new Shop("вул. Київська, 2", "Приватний", List.of("Продукти")),
				new Shop("вул. Київська, 3", "Супермаркет", List.of("Продукти", "Одяг", "Техніка", "Іграшки", "Косметика")),
				new School("вул. Київська, 4", "Ліцей"),
				new ResidentialHouse("вул. Київська, 6", 45),
				new Shop("вул. Київська, 7", "Приватний", List.of("Алкоголь")),
				new School("вул. Київська, 8", "Гімназія")
		));
	}
}
