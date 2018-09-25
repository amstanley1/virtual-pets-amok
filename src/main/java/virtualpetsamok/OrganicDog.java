package virtualpetsamok;

public class OrganicDog extends Dog implements Organic {
	private int cageWasteLevel;
	private int hungerLevel;
	private int sleepinessLevel;
	private int boredomLevel;
	private int thirstLevel;
	private boolean isAsleep;
	private boolean hasBeenWalked = false;

	// Getters
	public boolean getIsAsleep() {
		return isAsleep;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getSleepinessLevel() {
		return sleepinessLevel;
	}

	public int getBoredomLevel() {
		return boredomLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getCageWasteLevel() {
		return cageWasteLevel;
	}

	public OrganicDog(String name, String description, int healthLevel, int happinessLevel, int hungerLevel,
			int thirstLevel, int sleepinessLevel, int boredomLevel) {
		super(name, description, healthLevel, happinessLevel);
		this.hungerLevel = hungerLevel;
		this.sleepinessLevel = sleepinessLevel;
		this.boredomLevel = boredomLevel;
		this.thirstLevel = thirstLevel;
	}

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

	// Give pet water
	public void water() {
		if (thirstLevel < 3) {
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

	// Play with pet, lowers boredom level
	public void playWith() {
		if (this.boredomLevel < 3) {
			this.boredomLevel = 0;
		} else {
			this.boredomLevel -= 3;
		}
		if (this.happinessLevel < 8) {
			this.happinessLevel = 10;
		} else {
			this.happinessLevel += 3;
		}
		if (this.sleepinessLevel > 8) {
			this.sleepinessLevel = 10;
		} else {
			this.sleepinessLevel = this.sleepinessLevel + 2;
		}
	}

	// sleep method, lowers sleepiness level, sets boolean isAsleep
	// to true
	public void sleep() {
		this.sleepinessLevel -= 5;
		this.isAsleep = true;
	}

	// wake method, sets boolean isAsleep to false
	public void wake() {
		this.isAsleep = false;
	}

	public void cleanCage() {
		cageWasteLevel = 0;
	}

	@Override
	public void tick() {
		if (this.hungerLevel < 10) {
			this.hungerLevel++;
		}
		if (this.hungerLevel > 6 && this.happinessLevel > 0) {
			this.happinessLevel--;
		}
		if (this.hungerLevel > 8 && this.healthLevel > 0) {
			this.healthLevel--;
		}
		if (this.thirstLevel < 10) {
			this.thirstLevel++;
		}
		if (this.thirstLevel > 6 && this.happinessLevel > 0) {
			this.happinessLevel--;
		}
		if (this.thirstLevel > 9 && this.healthLevel > 0) {
			this.healthLevel--;
		}
		if (this.boredomLevel < 10) {
			this.boredomLevel++;
		}
		if (this.boredomLevel > 6 && this.happinessLevel > 0) {
			this.happinessLevel--;
		}
		this.sleepinessLevel++;
		if (this.sleepinessLevel > 8) {
			this.sleep();
		}
		if (cageWasteLevel < 10 && !hasBeenWalked) {
			cageWasteLevel++;
		}
		if (cageWasteLevel > 6 && this.happinessLevel > 0) {
			this.happinessLevel--;
		}
		if (this.cageWasteLevel > 9 && this.healthLevel > 0) {
			this.healthLevel--;
		}
		hasBeenWalked = false;
	}

	@Override
	public void walk() {
		boredomLevel = 0;
		if (happinessLevel > 7) {
			happinessLevel = 10;
		} else {
			happinessLevel += 2;
		}
		if (sleepinessLevel > 7) {
			sleepinessLevel = 10;
		} else {
			sleepinessLevel += 2;
		}
		hasBeenWalked = true;
	}
}
