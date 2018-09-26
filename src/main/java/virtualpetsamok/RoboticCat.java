package virtualpetsamok;

public class RoboticCat extends Cat implements Robotic {
	private int rustLevel;

	public int getRustLevel() {
		return rustLevel;
	}

	public RoboticCat(String name, String description, int healthLevel, int happinessLevel, int rustLevel) {
		super(name, description, healthLevel, happinessLevel);
		this.rustLevel = rustLevel;
	}

	@Override
	public void tick() {
		if (rustLevel < 10) {
			rustLevel++;
		}
		if (rustLevel > 8 && healthLevel > 0) {
			healthLevel--;
		}
		if (rustLevel > 8 && happinessLevel > 0) {
			happinessLevel--;
		}

	}

	@Override
	public void oil() {
		if (rustLevel < 5) {
			rustLevel = 0;
		} else {
			rustLevel -= 4;
		}
		if (happinessLevel > 7) {
			happinessLevel = 10;
		} else {
			happinessLevel += 2;
		}
		if (healthLevel > 7) {
			healthLevel = 10;
		} else {
			healthLevel += 2;
		}
	}

	// Play with pet, raises happiness level
	public void playWith() {
		if (happinessLevel > 7) {
			happinessLevel = 10;
		} else {
			happinessLevel += 3;
		}
	}
}
