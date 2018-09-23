package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoboticCatTest {
	RoboticCat roboticCat;
	
	@Before
	public void setup() {
		roboticCat = new RoboticCat("","", 8,5, 6);
	}
	
	@Test
	public void shouldBeAbleToGetOilLevel() {
		int oilLevel = roboticCat.getOilLevel();
		assertTrue(oilLevel == 5);
	}
	
	
	@Test
	public void shouldBeAbleToOilRoboticCat() {
		int originalOilLevel = roboticCat.getOilLevel();
		roboticCat.oil();
		assertTrue((originalOilLevel + 4) == (roboticCat.getOilLevel()));
	}
	
	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalOilLevel = roboticCat.getOilLevel();
		roboticCat.tick();
		assertTrue(originalOilLevel + 1 == roboticCat.getOilLevel());
	}
}
