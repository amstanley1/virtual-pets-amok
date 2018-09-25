package virtualpetsamok;

public class RoboticDog extends Dog implements Robotic {
	private int rustLevel;

	public int getRustLevel() {
		return rustLevel;
	}

	public RoboticDog(String name, String description, int healthLevel, int happinessLevel, int rustLevel) {
		super(name, description, healthLevel, happinessLevel);
		this.rustLevel = rustLevel;
	}

	@Override
	public void tick() {
		if (rustLevel < 10) {
			rustLevel++;
		}
	}

	@Override
	public void oil() {
		if (rustLevel < 5) {
			rustLevel = 0;
		} else {
			rustLevel -= 4;
		}
	}

	// Play with pet, raises happiness level
	public void playWith() {
		if (this.happinessLevel > 6) {
			this.happinessLevel = 10;
		} else {
			this.happinessLevel += 3;
		}
	}

	@Override
	public void walk() {
		if (this.happinessLevel > 7) {
			this.happinessLevel = 10;
		} else {
			this.happinessLevel += 2;
		}
	}
}
