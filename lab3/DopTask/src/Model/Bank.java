package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bank {
	private final List<ATM> atms;
	
	public List<ATM> getAtms() {
		return atms;
	}
	
	public Bank() {
		this.atms = new ArrayList<>();
	}
	
	public void addATM(ATM atm) {
		atms.add(atm);
	}
	
	public int getTotalMoney() {
		return atms.stream().mapToInt(ATM::getTotalMoney).sum();
	}
	
	public void loadMoneyToATM(int atmIndex, int denomination, int count) {
		if (atmIndex < 0 || atmIndex >= atms.size()) {
			System.out.println("Невірний індекс банкомату.");
		}
		atms.get(atmIndex).addCash(denomination, count);
	}
	
	public Map<Integer, Integer> withdrawFromATM(int atmIndex, int amount) {
		if (atmIndex < 0 || atmIndex >= atms.size()) {
			System.out.println("Невірний індекс банкомату.");
		}
		return atms.get(atmIndex).getCash(amount);
	}
	
	public int getCount() {
		return atms.size();
	}
}
