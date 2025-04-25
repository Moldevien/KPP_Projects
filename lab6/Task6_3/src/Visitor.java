import java.time.LocalTime;

public class Visitor {
	private String name;
	private boolean reserved;
	
	public Visitor(String name) {
		this.name = name;
		this.reserved = false;
	}
	
	public Visitor(String name, boolean hasReservation) {
		this.name = name;
		this.reserved = hasReservation;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isReserved() {
		return reserved;
	}
	
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
	@Override
	public String toString() {
		return name + (reserved ? " (зарезервувався)" : "");
	}
}
