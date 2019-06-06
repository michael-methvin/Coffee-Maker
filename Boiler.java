package coffeeMakerProject;

public interface Boiler extends BoilerHeater, BoilerSensor {
	
	public void heatBoiler(boolean isBoilerHeatOn);
	public boolean checkBoilerSensor();
	public void fillBoiler();
}
