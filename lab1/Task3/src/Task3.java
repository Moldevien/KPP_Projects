import java.util.*;

public class Task3 {
	public static void main(String[] args) {
		//Маленьке меню
		Food[] menu = new Food[]{
				new Food("Борщ", 120.50),
				new Food("Вареники", 95.00),
				new Food("Компот", 35.00)
		};
		
		//Кількість людей
		Scanner scanner = new Scanner(System.in);
		System.out.print("Уведіть кількість людей: ");
		int peopleCount = scanner.nextInt();
		scanner.nextLine();
		
		ArrayList<Map<Food, Integer>> orders = new ArrayList<>();
		
		for (int i = 0; i < peopleCount; i++) {
			Map<Food, Integer> personOrder = new HashMap<>();
			System.out.println("Замовник " + (i + 1) + ":");
			
			//Меню
			while (true) {
				System.out.println("Що ви бажаєте?");
				
				for (int k = 0; k < menu.length; k++)
					System.out.println((k + 1) + ". " + menu[k]);
				
				System.out.print("Уведіть номер бажаної страви (або 0 для завершення): ");
				
				//Вибір бажаного
				int indexFood = scanner.nextInt();
				
				if (indexFood == 0) break;
				
				if (indexFood < 1 || indexFood > menu.length) {
					System.out.println("Невірний вибір, спробуйте ще раз.");
					continue;
				}
				
				Food selectedFood = menu[indexFood - 1];
				
				personOrder.put(selectedFood, personOrder.getOrDefault(selectedFood, 0) + 1);
			}
			
			orders.add(personOrder);
		}
		
		//Чек
		double totalSum = 0;
		System.out.println("\nЗамовлення:");
		for (int i = 0; i < orders.size(); i++) {
			//Конкретна людина
			System.out.println("Користувач " + (i + 1) + " замовив:");
			for (Map.Entry<Food, Integer> entry : orders.get(i).entrySet()) {
				//Загальна сума
				double foodCost = entry.getKey().getPrice() * entry.getValue();
				totalSum += foodCost;
				System.out.println(" - " + entry.getKey() + " x" + entry.getValue() + " = " + foodCost + " грн");
			}
		}
		System.out.println("\nЗагальна сума: " + totalSum + " грн\n");
	}
}
