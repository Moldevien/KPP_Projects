public class Table {
	private int number;
	private boolean isBusy;
	
	public Table(int number) {
		this.number = number;
		this.isBusy = false;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean isBusy() {
		return isBusy;
	}
	
	public void setBusy(boolean busy) {
		isBusy = busy;
	}
	
	@Override
	public String toString() {
		return "Стіл " + number + (isBusy ? " Зайнято" : " Вільний");
	}
}
