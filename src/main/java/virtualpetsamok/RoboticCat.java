package virtualpetsamok;

public class RoboticCat extends Cat implements Robotic {
	private int oilLevel;
	
	public int getOilLevel() {
		return oilLevel;
	}
	
	public RoboticCat(String name, String description, int healthLevel, int happinessLevel, int oilLevel) {
		super(name, description, healthLevel, happinessLevel);
		this.oilLevel = oilLevel;
	}
	
	@Override
	public void tick() {
		if (oilLevel > 0) {
			oilLevel--;
		}
	}
	
	@Override
	public void oil() {
		if (oilLevel < 10) {
		oilLevel += 4;
		}
	}	
}
