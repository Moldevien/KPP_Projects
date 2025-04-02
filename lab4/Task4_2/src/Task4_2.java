import Interface.IWorker;
import Service.House;
import Service.Team;
import Model.Team.TeamLeader;
import Model.Team.Worker;

import java.util.ArrayList;
import java.util.List;

public class Task4_2 {
	public static void main(String[] args) {
		House house = new House();
		List<IWorker> workers = new ArrayList<>();
		
		workers.add(new Worker("Працівник 1"));
		workers.add(new Worker("Працівник 2"));
		workers.add(new Worker("Працівник 3"));
		workers.add(new Worker("Працівник 4"));
		workers.add(new TeamLeader());
		
		Team team = new Team(workers);
		
		team.build(house);
	}
}
