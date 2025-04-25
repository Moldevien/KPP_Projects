import java.util.List;

public class Street {
	private List<Building> buildings;
	
	public Street(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	public boolean add(Building building) {
		if (check(building.getAddress())) {
			return false;
		}
		buildings.add(building);
		return true;
	}
	
	public boolean delete(String address) {
		if (!check(address)) {
			return false;
		}
		buildings.removeIf(building -> building.getAddress().equals(address));
		return true;
	}
	
	public List<Building> getBuildings() {
		return buildings;
	}
	
	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	public boolean check(String address) {
		return buildings.stream().anyMatch(building -> building.getAddress().equals(address));
	}
	
	public Building getBuilding(String address) {
		return buildings.stream().filter(building -> building.getAddress().equals(address)).findFirst().get();
	}
	
	public void all() {
		buildings.forEach(building -> building.displayInfo());
	}
	
	public void searchShopsNear(String address, int range, String department) {
		int index = -1;
		for (int i = 0; i < buildings.size(); i++) {
			if (buildings.get(i) instanceof ResidentialHouse && buildings.get(i).getAddress().equals(address)) {
				index = i;
				break;
			}
		}
		
		if (index == -1) {
			System.err.println("Будинок не знайдено.");
			return;
		}
		
		int start = Math.max(0, index - range);
		int end = Math.min(buildings.size(), index + range + 1);
		
		System.out.println("Магазини поблизу з відділом '" + department + "':");
		buildings.subList(start, end).stream()
				.filter(b -> b instanceof Shop)
				.map(b -> (Shop) b)
				.filter(shop -> shop.getDepartments().stream()
						.anyMatch(d -> d.equals(department)))
				.forEach(shop1 -> shop1.displayInfo());
	}
}
