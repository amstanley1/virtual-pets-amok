package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import virtualpetsamok.OrganicCat;

public class OrganicCatTest {
	OrganicCat organicCat;

	@Before
	public void setup() {
		organicCat = new OrganicCat("", "", 8, 8, 8, 4, 7, 5);
	}

	@Test
	public void shouldBeAbleToGetHungerLevel() {
		int hungerLevel = organicCat.getHungerLevel();
		assertTrue(hungerLevel == 8);
	}

	@Test
	public void shouldBeAbleToGetSleepinessLevel() {
		int sleepinessLevel = organicCat.getSleepinessLevel();
		assertTrue(sleepinessLevel == 7);
	}

	@Test
	public void shouldBeAbleToFeedPet() {

		int originalHungerLevel = organicCat.getHungerLevel();
		organicCat.feed(1);
		assertTrue((originalHungerLevel - 5) == (organicCat.getHungerLevel()));
	}

	@Test
	public void shouldBeAbleToGetBoredomLevel() {
		int boredomLevel = organicCat.getBoredomLevel();
		assertTrue(boredomLevel == 5);
	}

	@Test
	public void shouldBeAbleToPlayWithPet() {
		int originalBoredomLevel = organicCat.getBoredomLevel();
		organicCat.playWith();
		assertTrue(originalBoredomLevel - 3 == organicCat.getBoredomLevel());
	}

	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalBoredomLevel = organicCat.getBoredomLevel();
		int originalThirstLevel = organicCat.getThirstLevel();
		int originalHungerLevel = organicCat.getHungerLevel();
		int originalSleepinessLevel = organicCat.getSleepinessLevel();
		organicCat.tick();
		assertTrue(originalBoredomLevel + 1 == organicCat.getBoredomLevel());
		assertTrue(originalThirstLevel + 1 == organicCat.getThirstLevel());
		assertTrue(originalHungerLevel + 1 == organicCat.getHungerLevel());
		assertTrue(originalSleepinessLevel + 1 == organicCat.getSleepinessLevel());
	}

	@Test
	public void shouldBeAbleToGetName() {
		String name = organicCat.getName();
		assertTrue(name.equals(""));
	}

	@Test
	public void shouldBeAbleToGetDescription() {
		String name = organicCat.getDescription();
		assertTrue(name.equals(""));
	}

	@Test
	public void shouldBeAbleToGetThirstLevel() {
		int thirstLevel = organicCat.getThirstLevel();
		assertTrue(thirstLevel == 4);
	}

	@Test
	public void shouldBeAbleToWaterPet() {
		int originalThirstLevel = organicCat.getThirstLevel();
		organicCat.water();
		assertTrue(originalThirstLevel - 3 == organicCat.getThirstLevel());
	}
}
