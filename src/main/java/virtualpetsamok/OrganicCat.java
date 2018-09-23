package virtualpetsamok;

public class OrganicCat extends Cat implements Organic {
	private int hungerLevel;
	private int sleepinessLevel;
	private int boredomLevel;
	private int thirstLevel;
	private boolean isAsleep;
	
	//Getters
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

	
	public OrganicCat(String name, String description, int healthLevel, int happinessLevel, int hungerLevel, int thirstLevel, int sleepinessLevel,
			int boredomLevel) {
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
				break;
			case 2:
				if (this.hungerLevel < 3) {
					this.hungerLevel = 0;
				} else {
					this.hungerLevel = this.hungerLevel - 3;
				}
				break;
			case 3:
				if (this.hungerLevel < 1) {
					this.hungerLevel = 0;
				} else {
					this.hungerLevel -= 1;
				}
				break;
			}
		}

		@Override
		// Give pet water
		public void water() {
			this.thirstLevel -= 4;
		}

		@Override
		// Play with pet, lowers boredom level
		public void playWith() {
			if (this.boredomLevel < 3) {
				this.boredomLevel = 0;
			} else {
				this.boredomLevel -= 3;
			}
			if (this.sleepinessLevel > 8) {
				this.sleepinessLevel = 10;
			} else {
				this.sleepinessLevel = this.sleepinessLevel + 2;
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
			if (this.hungerLevel < 10) {
				this.hungerLevel++;
			}
			if (this.hungerLevel > 6) {
				this.happinessLevel--;
			}
			if (this.hungerLevel > 9) {
				this.healthLevel--;
			}
			if (this.thirstLevel < 10) {
				this.thirstLevel++;
			}
			if (this.thirstLevel > 6) {
				this.happinessLevel--;
			}
			if (this.thirstLevel > 8) {
				this.healthLevel--;
			}
			if (this.boredomLevel < 10) {
				this.boredomLevel++;
			}
			this.sleepinessLevel++;
			if (this.sleepinessLevel > 8) {
				this.sleep();
			}
		}
		
		

	
}
