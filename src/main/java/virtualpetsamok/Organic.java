package virtualpetsamok;

public interface Organic {

	abstract int getHungerLevel();

	abstract int getThirstLevel();

	abstract int getBoredomLevel();

	abstract int getSleepinessLevel();

	abstract void feed(int food);

	abstract void water();

	abstract void sleep();

	abstract void wake();
}
