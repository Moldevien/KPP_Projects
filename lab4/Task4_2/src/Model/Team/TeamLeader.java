package Model.Team;

import Interface.IWorker;
import Service.House;

public class TeamLeader implements IWorker {
	public void work(House house) {
		System.out.println("Бригадир перевіряє стан будівництва...");
		house.showProgress();
	}
}
