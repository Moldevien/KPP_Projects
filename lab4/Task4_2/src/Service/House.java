package Service;

import Interface.IPart;
import Model.House.*;

import java.util.ArrayList;
import java.util.List;

public class House {
	private List<IPart> parts = new ArrayList<>();
	
	public void addPart(IPart part) {
		parts.add(part);
	}
	
	public List<IPart> getParts() {
		return parts;
	}
	
	public boolean isCompleted() {
		return parts.size() == 11;
	}
	
	public void showProgress() {
		System.out.printf("Поточний стан будівництва: %.2f%%\n", (parts.size() / 11.0) * 100);
		System.out.println();
	}
}
