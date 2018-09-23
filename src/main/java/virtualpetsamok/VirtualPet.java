package virtualpetsamok;

public abstract class VirtualPet {

	// Fields for name, description, hunger level, sleepiness level, boredom level,
	// state of sleep, and location
	private String name;
	private String description;
	protected int healthLevel;
	protected int happinessLevel;
	

	// Getters
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getHealthLevel() {
		return healthLevel;
	}
	
	public int getHappinessLevel() {
		return happinessLevel;
	}

	// Constructors
	public VirtualPet(String name, String description, int healthLevel, int happinessLevel) {
		this.name = name;
		this.description = description;
		this.healthLevel = healthLevel;;
		this.happinessLevel = happinessLevel;
	}

	// makes time pass, raises pet's needs
	public abstract void tick();

	
}
