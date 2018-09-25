package virtualpetsamok;

public abstract class Dog extends VirtualPet {

	protected Dog(String name, String description, int healthLevel, int happinessLevel) {
		super(name, description, healthLevel, happinessLevel);
	}

	protected abstract void walk();
}
