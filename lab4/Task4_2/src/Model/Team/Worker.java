package Model.Team;

import Interface.IPart;
import Interface.IWorker;
import Model.House.*;
import Service.House;

public class Worker implements IWorker {
	private static IPart[] Plan = {
			new Basement(),
			new Walls(),
			new Walls(),
			new Walls(),
			new Walls(),
			new Window(),
			new Window(),
			new Window(),
			new Window(),
			new Door(),
			new Roof()
	};
	
	private String name;
	
	public Worker(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void work(House house) {
		for (IPart part : Plan) {
			long count = house.getParts().stream().filter(p -> p.getClass().equals(part.getClass())).count();
			if ((part instanceof Basement && count == 0) ||
					(part instanceof Walls && count < 4) ||
					(part instanceof Window && count < 4) ||
					(part instanceof Door && count == 0) ||
					(part instanceof Roof && count == 0)) {
				house.addPart(part);
				System.out.println(getName() + " додав: " + part.getName());
				break;
			}
		}
	}
}
