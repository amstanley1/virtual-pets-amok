package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoboticDogTest {
	RoboticDog roboticDog;
	
	@Before
	public void setup() {
		roboticDog = new RoboticDog("","", 8, 5, 6);
	}
	
	@Test
	public void shouldBeAbleToGetOilLevel() {
		int oilLevel = roboticDog.getOilLevel();
		assertTrue(oilLevel == 5);
	}

	@Test
	public void shouldBeAbleToOilRoboticDog() {
		int originalOilLevel = roboticDog.getOilLevel();
		roboticDog.oil();
		assertTrue((originalOilLevel + 4) == (roboticDog.getOilLevel()));
	}
	
	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalOilLevel = roboticDog.getOilLevel();
		roboticDog.tick();
		assertTrue(originalOilLevel + 1 == roboticDog.getOilLevel());	
	}
}
