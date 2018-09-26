package virtualpetsamok;

public class OrganicCat extends Cat implements Organic {
	private int hungerLevel;
	private int sleepinessLevel;
	private int boredomLevel;
	private int thirstLevel;
	private boolean isAsleep;

	// Getters
	public boolean getIsAsleep() {
		return this.isAsleep;
	}

	public int getHungerLevel() {
		return this.hungerLevel;
	}

	public int getSleepinessLevel() {
		return this.sleepinessLevel;
	}

	public int getBoredomLevel() {
		return this.boredomLevel;
	}

	public int getThirstLevel() {
		return this.thirstLevel;
	}

	public OrganicCat(String name, String description, int healthLevel, int happinessLevel, int hungerLevel,
			int thirstLevel, int sleepinessLevel, int boredomLevel) {
		super(name, description, healthLevel, happinessLevel);
		this.hungerLevel = hungerLevel;
		this.sleepinessLevel = sleepinessLevel;
		this.boredomLevel = boredomLevel;
		this.thirstLevel = thirstLevel;
	}

	@Override
	// Feed Pet, lowers hunger level depending on user selected food number
	public void feed(int userSelectedFood) {
		switch (userSelectedFood) {
		case 1:
			if (this.hungerLevel < 5) {
				this.hungerLevel = 0;
			} else {
				this.hungerLevel = this.hungerLevel - 5;
			}
			if (this.happinessLevel > 8) {
				this.happinessLevel = 10;
			} else {
				this.happinessLevel += 3;
			}
			if (this.healthLevel > 8) {
				this.happinessLevel = 10;
			} else {
				this.healthLevel += 3;
			}
			break;
		case 2:
			if (this.hungerLevel < 3) {
				this.hungerLevel = 0;
			} else {
				this.hungerLevel = this.hungerLevel - 3;
			}
			if (this.happinessLevel > 9) {
				this.happinessLevel = 10;
			} else {
				this.happinessLevel += 2;
			}
			if (this.healthLevel > 8) {
				this.happinessLevel = 10;
			} else {
				this.healthLevel += 3;
			}
			break;
		case 3:
			if (this.hungerLevel < 1) {
				this.hungerLevel = 0;
			} else {
				this.hungerLevel -= 1;
			}
			if (this.happinessLevel > 8) {
				this.happinessLevel = 10;
			} else {
				this.happinessLevel += 1;
			}
			if (this.healthLevel > 8) {
				this.happinessLevel = 10;
			} else {
				this.healthLevel += 3;
			}
			break;
		}
	}

	@Override
	// Give pet water
	public void water() {
		if (thirstLevel < 4) {
			thirstLevel = 0;
		} else {
			thirstLevel -= 3;
		}
		if (happinessLevel > 8) {
			happinessLevel = 10;
		} else {
			this.happinessLevel += 2;
		}
		if (healthLevel > 8) {
			healthLevel = 10;
		} else {
			this.healthLevel += 2;
		}
	}

	@Override
	// Play with pet, lowers boredom level
	public void playWith() {
		if (this.boredomLevel < 6) {
			this.boredomLevel = 0;
		} else {
			this.boredomLevel -= 5;
		}
		if (this.happinessLevel < 8) {
			this.happinessLevel = 10;
		} else {
			this.happinessLevel += 3;
		}
		if (this.sleepinessLevel > 8) {
			this.sleepinessLevel = 10;
		} else {
			this.sleepinessLevel += 2;
		}
	}

	// sleep method, lowers sleepiness level, sets boolean isAsleep
	// to true
	@Override
	public void sleep() {
		this.sleepinessLevel -= 5;
		this.isAsleep = true;
	}

	// wake method, sets boolean isAsleep to false
	@Override
	public void wake() {
		this.isAsleep = false;
	}

	@Override
	public void tick() {
		if (hungerLevel < 10) {
			hungerLevel++;
		}
		if (hungerLevel > 6 && happinessLevel > 0) {
			happinessLevel--;
		}
		if (hungerLevel > 8 && healthLevel < 0) {
			healthLevel--;
		}
		if (thirstLevel < 10) {
			thirstLevel++;
		}
		if (thirstLevel > 6 && happinessLevel > 0) {
			happinessLevel--;
		}
		if (thirstLevel > 9 && healthLevel > 0) {
			healthLevel--;
		}
		if (boredomLevel < 10) {
			boredomLevel++;
		}
		if (boredomLevel > 6 && happinessLevel > 0) {
			happinessLevel--;
		}
		if (happinessLevel < 3 && healthLevel > 0) {
			healthLevel--;
		}
		sleepinessLevel++;
		if (sleepinessLevel > 8) {
			this.sleep();
		}
	}
}
