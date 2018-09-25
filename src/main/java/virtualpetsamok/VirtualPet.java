package virtualpetsamok;

public abstract class VirtualPet {

	// Fields for name, description
	private String name;
	private String description;
	protected int healthLevel;
	protected int happinessLevel;

	// Getters
	protected String getName() {
		return name;
	}

	protected String getDescription() {
		return description;
	}

	protected int getHealthLevel() {
		return healthLevel;
	}

	protected int getHappinessLevel() {
		return happinessLevel;
	}

	// Constructors
	protected VirtualPet(String name, String description, int healthLevel, int happinessLevel) {
		this.name = name;
		this.description = description;
		this.healthLevel = healthLevel;
		;
		this.happinessLevel = happinessLevel;
	}

	// makes time pass, raises pet's needs
	protected abstract void tick();

	protected abstract void playWith();
}
