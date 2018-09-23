package virtualpetsamok;

public interface Organic {
	
	int getHungerLevel();
	
	int getThirstLevel();
	
	int getBoredomLevel();
	
	int getSleepinessLevel();
	
	void feed(int food);
	
	void water();
	
	void playWith();
	
	void sleep();
	
	void wake();
}
