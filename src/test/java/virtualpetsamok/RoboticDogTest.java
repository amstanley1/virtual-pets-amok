package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoboticDogTest {
	RoboticDog roboticDog;

	@Before
	public void setup() {
		roboticDog = new RoboticDog("", "", 8, 5, 6);
	}

	@Test
	public void shouldBeAbleToGetRustLevel() {
		int rustLevel = roboticDog.getRustLevel();
		assertTrue(rustLevel == 6);
	}

	@Test
	public void shouldBeAbleToOilRoboticDog() {
		int originalRustLevel = roboticDog.getRustLevel();
		roboticDog.oil();
		assertTrue((originalRustLevel - 4) == (roboticDog.getRustLevel()));
	}

	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalRustLevel = roboticDog.getRustLevel();
		roboticDog.tick();
		assertTrue(originalRustLevel + 1 == roboticDog.getRustLevel());
	}
}
