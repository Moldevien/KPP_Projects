// Завдання 3. Створіть додаток, що емулює чергу у популярне кафе.
// Відвідувачі кафе приходять та потрапляють у чергу, якщо немає вільного місця.
// Коли столик в кафе стає вільним, перший відвідувач з черги займає його.
// Якщо приходить відвідувач, який резервував столик на певний час, він отримує зарезервований столик позачергово.

import java.time.LocalTime;

public class Main {
	public static void main(String[] args) {
		Cafe cafe = new Cafe(3);
		
		cafe.add(new Visitor("Alice"));
		cafe.add(new Visitor("Bob"));
		cafe.add(new Visitor("Clara", true));
		cafe.add(new Visitor("Dave"));
		cafe.add(new Visitor("Emma", true));
		
		cafe.start();
		cafe.printStatus();
		
		cafe.leaveTable(2);
		cafe.start();
		cafe.printStatus();
	}
}