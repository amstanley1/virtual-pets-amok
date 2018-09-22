package virtualpetsamok;

public abstract class VirtualPet {

	// Fields for name, description, hunger level, sleepiness level, boredom level,
	// state of sleep, and location
	private String name;
	private String description;
	

	// Getters
	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	// Constructors
	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		
	}

	// makes time pass, raises pet's needs
	public abstract void tick();

	
}
