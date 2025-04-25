import java.time.LocalTime;
import java.util.*;

public class Cafe {
	private Queue<Visitor> queue = new LinkedList<>();
	private List<Visitor> reservations = new ArrayList<>();
	private List<Table> tables = new ArrayList<>();
	
	public Cafe(int tableCount) {
		for (int i = 1; i <= tableCount; i++) {
			tables.add(new Table(i));
		}
	}
	
	public void add(Visitor visitor) {
		if (visitor.isReserved()) {
			reservations.add(visitor);
			System.out.println(visitor.getName() + " зарезервувався.");
		} else {
			queue.add(visitor);
			System.out.println(visitor.getName() + " став у чергу.");
		}
	}
	
	// Обробка зарезервованих
	public void start() {
		List<Visitor> servedReservations = new ArrayList<>();
		
		for (Visitor visitor : reservations) {
			tables.stream()
					.filter(t -> !t.isBusy())
					.findFirst()
					.ifPresentOrElse(table -> {
						table.setBusy(true);
						System.out.println(visitor.getName() + " отримує поза чергою стіл " + table.getNumber());
						servedReservations.add(visitor);
					}, () -> System.out.println(visitor.getName() + " має резервацію, але всі столи зайняті."));
		}
		
		reservations.removeAll(servedReservations);
		
		// Обробка черги
		while (!queue.isEmpty()) {
			Optional<Table> freeTableOpt = tables.stream()
					.filter(t -> !t.isBusy())
					.findFirst();
			
			if (freeTableOpt.isEmpty()) break;
			
			Table freeTable = freeTableOpt.get();
			Visitor v = queue.poll();
			freeTable.setBusy(true);
			System.out.println(v.getName() + " отримує стіл " + freeTable.getNumber());
		}
	}
	
	public void leaveTable(int tableNumber) {
		tables.stream()
				.filter(table -> table.getNumber() == tableNumber)
				.findFirst()
				.ifPresent(table -> {
					table.setBusy(false);
					System.out.println("Стіл " + tableNumber + " тепер вільний.");
				});
	}
	
	public void printStatus() {
		System.out.println("\nЧерга: " + queue);
		System.out.println("Зарезервовані: " + reservations);
		tables.forEach(x -> System.out.println(x));
	}
}
