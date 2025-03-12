package Model;

public abstract class Instrument {
	private String name;
	private String sound;
	private String description;
	private String history;
	
	protected Instrument(String name, String sound, String description, String history) {
		this.name = name;
		this.sound = sound;
		this.description = description;
		this.history = history;
	}
	
	public String Sound(){
		return sound;
	}
	
	public String Show() {
		return name;
	}
	
	public String Desc() {
		return description;
	}
	
	public String History() {
		return history;
	}
}
