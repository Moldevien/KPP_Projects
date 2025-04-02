package Service;

import Interface.IWorker;

import java.util.List;

public class Team {
	private List<IWorker> workers;
	
	public Team(List<IWorker> workers) {
		this.workers = workers;
	}
	
	public void build(House house) {
		while (house.getParts().size() != 11) {
			for (IWorker worker : workers) {
				worker.work(house);
				if (house.isCompleted()) {
					System.out.println("Будинок повністю побудовано!");
					return;
				}
			}
		}
	}
}
