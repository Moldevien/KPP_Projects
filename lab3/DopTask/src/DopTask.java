import Model.ATM;
import Model.Bank;

import java.util.Map;
import java.util.Random;

public class DopTask {
	public static void main(String[] args) {
		Random r = new Random();
		
		Bank bank = new Bank();
		
		// Створюємо банкомат із максимальними параметрами
		for (int i = 0; i < r.nextInt(5) + 2; i++)
			bank.addATM(new ATM(r.nextInt(25000) + 4000, r.nextInt(50) + 10));
		
		// Завантажуємо гроші в банкомат
		int[] denominations = {500, 200, 100, 10, 20, 50, 5, 2, 1};
		for (int i = 0; i < bank.getCount(); i++)
			for (int j = 0; j < denominations.length; j++)
				bank.loadMoneyToATM(i, denominations[j], r.nextInt(50));
		
		System.out.println("Загальна сума грошей у мережі банкоматів: " + bank.getTotalMoney() + " грн");
		System.out.println();
		
		for (int i = 0; i < bank.getCount(); i++)
			System.out.println(i + ". " + bank.getAtms().get(i).toString());
		System.out.println();
		
		// Знімаємо гроші
		int a = r.nextInt(10000);
		System.out.println("Запрос на зняття " + a + " грн.");
		Map<Integer, Integer> withdrawn = bank.withdrawFromATM(0, a);
		System.out.println("Видано: " + withdrawn);
	}
}
