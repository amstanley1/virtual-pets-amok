package virtualpetsamok;

public class OrganicCat extends Cat {
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

	
	public OrganicCat(String name, String description, int hungerLevel, int thirstLevel, int sleepinessLevel,
			int boredomLevel) {
		super(name, description);
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

		// Give pet water
		public void water() {
			this.thirstLevel -= 4;
		}

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
		public void sleep() {
			this.sleepinessLevel -= 5;
			this.isAsleep = true;
		}

		// wake method, sets boolean isAsleep to false
		public void wake() {
			this.isAsleep = false;
		}

		@Override
		public void tick() {
			if (this.hungerLevel < 10) {
				this.hungerLevel++;
			}
			if (this.thirstLevel < 10) {
				this.thirstLevel++;
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
