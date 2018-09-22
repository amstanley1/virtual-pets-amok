package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoboticDogTest {
	RoboticDog roboticDog;
	
	@Before
	public void setup() {
		roboticDog = new RoboticDog("","", 5, 6);
	}
	
	@Test
	public void shouldBeAbleToGetOilLevel() {
		int oilLevel = roboticDog.getOilLevel();
		assertTrue(oilLevel == 5);
	}
	
	@Test
	public void shouldBeAbleToGetMaintenaceLevel() {
		int maintenanceLevel = roboticDog.getMaintenanceLevel();
		assertTrue(maintenanceLevel == 6);
	}
	
	@Test
	public void shouldBeAbleToOilRoboticDog() {
		int originalOilLevel = roboticDog.getOilLevel();
		roboticDog.oil();
		assertTrue((originalOilLevel + 4) == (roboticDog.getOilLevel()));
	}
	
	@Test
	public void shouldBeAbleToMaintainRoboticDog() {
		int originalMaintenanceLevel = roboticDog.getMaintenanceLevel();
		roboticDog.maintain();
		assertTrue((originalMaintenanceLevel + 5) == (roboticDog.getMaintenanceLevel()));
	}
	
	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalOilLevel = roboticDog.getOilLevel();
		int originalMaintenanceLevel = roboticDog.getMaintenanceLevel();
		roboticDog.tick();
		assertTrue(originalOilLevel + 1 == roboticDog.getOilLevel());
		assertTrue(originalMaintenanceLevel + 1 == roboticDog.getMaintenanceLevel());
	}
}
