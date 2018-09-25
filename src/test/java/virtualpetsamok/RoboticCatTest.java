package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoboticCatTest {
	RoboticCat roboticCat;

	@Before
	public void setup() {
		roboticCat = new RoboticCat("", "", 8, 5, 6);
	}

	@Test
	public void shouldBeAbleToGetRustLevel() {
		int rustLevel = roboticCat.getRustLevel();
		assertTrue(rustLevel == 6);
	}

	@Test
	public void shouldBeAbleToOilRoboticCat() {
		int originalRustLevel = roboticCat.getRustLevel();
		roboticCat.oil();
		assertTrue((originalRustLevel - 4) == (roboticCat.getRustLevel()));
	}

	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalRustLevel = roboticCat.getRustLevel();
		roboticCat.tick();
		assertTrue(originalRustLevel + 1 == roboticCat.getRustLevel());
	}
}
