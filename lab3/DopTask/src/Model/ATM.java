package Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ATM {
	private Map<Integer, Integer> banknotes = new HashMap<>();
	private int maxValue;
	private int maxQuantity;
	
	public ATM(int maxValue, int maxQuantity) {
		int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};
		for (int i : denominations)
			banknotes.put(i, 0);
		this.maxValue = maxValue;
		this.maxQuantity = maxQuantity;
	}
	
	public ATM(int[] denominations2, int maxValue, int maxQuantity) {
		int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};
		for (int i = 0; i < 9; i++)
			banknotes.put(denominations[i], denominations2[i]);
		this.maxValue = maxValue;
		this.maxQuantity = maxQuantity;
	}
	
	public Map<Integer, Integer> getCash(int amount) {
		if (amount > maxValue)
			System.out.println("Запитувана сума перевищує максимальну суму видачі: " + maxValue);
		
		if (amount > getTotalMoney())
			System.out.println("Недостатньо коштів у банкоматі.");
		
		Map<Integer, Integer> result = new HashMap<>();
		int remainingAmount = amount;
		int totalBanknotesUsed = 0;
		int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};
		
		for (int i = 0; i < denominations.length; i++) {
			if (remainingAmount == 0) break;
			int availableNotes = banknotes.get(denominations[i]);
			int neededNotes = Math.min(remainingAmount / denominations[i], availableNotes);
			
			if (neededNotes > 0) {
				result.put(denominations[i], neededNotes);
				remainingAmount -= neededNotes * denominations[i];
				totalBanknotesUsed += neededNotes;
			}
		}
		
		if (remainingAmount > 0)
			System.out.println("Неможливо видати потрібну суму.");
		if (totalBanknotesUsed > maxQuantity)
			System.out.println("Перевищено ліміт купюр для видачі: " + maxQuantity);
		
		result.forEach((denomination, count) -> banknotes.put(denomination, banknotes.get(denomination) - count));
		return result;
	}
	
	public void addCash(int denomination, int count) {
		if (count > 0)
			banknotes.put(denomination, banknotes.get(denomination) + count);
	}
	
	public int getTotalMoney() {
		return banknotes.entrySet().stream()
				.mapToInt(entry ->
						entry.getKey() * entry.getValue()).sum();
	}
	
	@Override
	public String toString() {
		return banknotes.toString();
	}
}
