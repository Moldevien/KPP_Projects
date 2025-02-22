import java.util.*;

public class Task3 {
	public static void main(String[] args) {
		Food[] foods = new Food[]{
				new Food("Борщ", 120.50),
				new Food("Вареники", 95.00),
				new Food("Компот", 35.00)
		};
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Уведіть кількість людей: ");
		int quantity = scanner.nextInt();
		scanner.nextLine();
		
		ArrayList<Map<Food, Integer>> personMenu = new ArrayList<>();
		
		for (int i = 0; i < quantity; i++) {
			Map<Food, Integer> personFoods = new HashMap<>();
			System.out.println("Замовник " + (i + 1) + ":");
			
			while (true) {
				System.out.println("Що ви бажаєте?");
				
				for (int k = 0; k < foods.length; k++)
					System.out.println((k + 1) + ". " + foods[k]);
				
				System.out.print("Уведіть номер бажаної страви (або 0 для завершення): ");
				
				int indexFood = scanner.nextInt();
				
				if (indexFood == 0) break;
				
				if (indexFood < 1 || indexFood > foods.length) {
					System.out.println("Невірний вибір, спробуйте ще раз.");
					continue;
				}
				
				Food selectedFood = foods[indexFood - 1];
				
				personFoods.put(selectedFood, personFoods.getOrDefault(selectedFood, 0) + 1);
			}
			
			personMenu.add(personFoods);
		}
		
		// Виведемо меню для кожного користувача
		double totalSum = 0;
		System.out.println("\nЗамовлення:");
		for (int i = 0; i < personMenu.size(); i++) {
			System.out.println("Користувач " + (i + 1) + " замовив:");
			for (Map.Entry<Food, Integer> entry : personMenu.get(i).entrySet()) {
				double itemCost = entry.getKey().getPrice() * entry.getValue();
				totalSum += itemCost;
				System.out.println(" - " + entry.getKey() + " x" + entry.getValue() + " = " + itemCost + " грн");
			}
		}
		System.out.println("\nЗагальна сума: " + totalSum + " грн\n");
	}
}
