package virtualpetsamok;

public class RoboticDog extends Dog implements Robotic {
	private int oilLevel;
	private int maintenanceLevel;
	
	public int getOilLevel() {
		return oilLevel;
	}
	
	public int getMaintenanceLevel() {
		return maintenanceLevel;
	}
	
	public RoboticDog(String name, String description, int oilLevel, int maintenanceLevel) {
		super(name, description);
		this.oilLevel = oilLevel;
		this.maintenanceLevel = maintenanceLevel;
	}
	
	@Override
	public void tick() {
		if (this.oilLevel < 10) {
			this.oilLevel++;
		}
		if (this.maintenanceLevel < 10) {
			this.maintenanceLevel++;
		}
	}
	
	@Override
	public void oil() {
		oilLevel += 4;
		
	}
	
	@Override
	public void maintain() {
		maintenanceLevel += 5;	
	}

	
}
