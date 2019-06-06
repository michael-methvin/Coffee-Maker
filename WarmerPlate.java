package coffeeMakerProject;

public interface WarmerPlate extends PlateSensor, PlateHeater {
	public void heatWarmerPlate(boolean isWarmerPlateOn);
	public boolean checkPlateSensor();
	public void potSensor(boolean isPotEmpty);
	public void moveCoffeePot();
}
