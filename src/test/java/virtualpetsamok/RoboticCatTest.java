package virtualpetsamok;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoboticCatTest {
	RoboticCat roboticCat;
	
	@Before
	public void setup() {
		roboticCat = new RoboticCat("","", 5, 6);
	}
	
	@Test
	public void shouldBeAbleToGetOilLevel() {
		int oilLevel = roboticCat.getOilLevel();
		assertTrue(oilLevel == 5);
	}
	
	@Test
	public void shouldBeAbleToGetMaintenaceLevel() {
		int maintenanceLevel = roboticCat.getMaintenanceLevel();
		assertTrue(maintenanceLevel == 6);
	}
	
	@Test
	public void shouldBeAbleToOilRoboticCat() {
		int originalOilLevel = roboticCat.getOilLevel();
		roboticCat.oil();
		assertTrue((originalOilLevel + 4) == (roboticCat.getOilLevel()));
	}
	
	@Test
	public void shouldBeAbleToMaintainRoboticCat() {
		int originalMaintenanceLevel = roboticCat.getMaintenanceLevel();
		roboticCat.maintain();
		assertTrue((originalMaintenanceLevel + 5) == (roboticCat.getMaintenanceLevel()));
	}
	
	@Test
	public void tickMethodShouldIncrementAndDecrementProperties() {
		int originalOilLevel = roboticCat.getOilLevel();
		int originalMaintenanceLevel = roboticCat.getMaintenanceLevel();
		roboticCat.tick();
		assertTrue(originalOilLevel + 1 == roboticCat.getOilLevel());
		assertTrue(originalMaintenanceLevel + 1 == roboticCat.getMaintenanceLevel());
	}
}
