package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrganicDogTest {
	OrganicDog organicDog;
	
	@Before
	public void setup() {
		organicDog = new OrganicDog("","",8,8,8,4,7,5);
	}
	
	@Test
	public void shouldBeAbleToGetHungerLevel() {
		int hungerLevel = organicDog.getHungerLevel();
		assertTrue(hungerLevel == 8);
	}

	@Test
	public void shouldBeAbleToGetSleepinessLevel() {
		int sleepinessLevel = organicDog.getSleepinessLevel();
		assertTrue(sleepinessLevel == 7);
	}

	@Test
	public void shouldBeAbleToFeedPet() {

		int originalHungerLevel = organicDog.getHungerLevel();
		organicDog.feed(1);
		assertTrue((originalHungerLevel - 5) == (organicDog.getHungerLevel()));
	}

	@Test
	public void shouldBeAbleToGetBoredomLevel() {
		int boredomLevel = organicDog.getBoredomLevel();
		assertTrue(boredomLevel == 5);
	}

	@Test
	public void shouldBeAbleToPlayWithPet() {
		int originalBoredomLevel = organicDog.getBoredomLevel();
		organicDog.playWith();
		assertTrue(originalBoredomLevel - 3 == organicDog.getBoredomLevel());
	}


	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalBoredomLevel = organicDog.getBoredomLevel();
		int originalThirstLevel = organicDog.getThirstLevel();
		int originalHungerLevel = organicDog.getHungerLevel();
		int originalSleepinessLevel = organicDog.getSleepinessLevel();
		organicDog.tick();
		assertTrue(originalBoredomLevel + 1 == organicDog.getBoredomLevel());
		assertTrue(originalThirstLevel + 1 == organicDog.getThirstLevel());
		assertTrue(originalHungerLevel + 1 == organicDog.getHungerLevel());
		assertTrue(originalSleepinessLevel + 1 == organicDog.getSleepinessLevel());
	}

	@Test
	public void shouldBeAbleToGetName() {
		String name = organicDog.getName();
		assertTrue(name.equals(""));
	}

	@Test
	public void shouldBeAbleToGetDescription() {
		String name = organicDog.getDescription();
		assertTrue(name.equals(""));
	}

	@Test
	public void shouldBeAbleToGetThirstLevel() {
		int thirstLevel = organicDog.getThirstLevel();
		assertTrue(thirstLevel == 4);
	}

	@Test
	public void shouldBeAbleToWaterPet() {
		int originalThirstLevel = organicDog.getThirstLevel();
		organicDog.water();
		assertTrue(originalThirstLevel - 4 == organicDog.getThirstLevel());
	}
}
