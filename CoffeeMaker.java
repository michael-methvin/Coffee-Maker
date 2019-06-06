package coffeeMakerProject;
import java.util.Scanner;

public class CoffeeMaker implements Boiler, WarmerPlate, BrewButton, CoffeeHolder, ReliefValve, SprayControl {
	
	private double totalCost = 0; // Tracks cost of coffees made
	private int coffeeLeft = 0; // Tracks coffee still left in the pot
	private boolean isBoilerHeatOn = false; // Tracks boiler heat status
	private boolean isBoilerFull = false; // Tracks whether boiler has water
	private boolean isWarmerPlateOn = false; // Tracks warmer plate status
	private boolean isPotOn = false; // Tracks whether pot is on warmer
	private boolean isPotEmpty = true; // Tracks whether pot has water
	private boolean isLightOn = false; // Tracks indicator light status
	private boolean isHolderFull = false; // Tracks coffee holder status
	private String strength = "Medium"; // Set to medium by default, can be changed to Light or Dark
	private boolean isValveOpen = true; // Tracks valve status
	private boolean interrupt = false; // Determines if interrupt has been called
	private int waterLeft = 0; // Tracks how much water is in the boiler
	
	// Method used to determine whether to interrupt the brewing process
	public void interrupt() {
		if(interrupt == false) {
			interrupt = true;
		}
		else {
			interrupt = false;
		}
	}
	// Method used to pour coffee and remove coffee from pot
	public void pourCoffee() {
		// Validation check
		if (coffeeLeft == 0) {
			System.out.println("No coffee to pour");
		}
		else {
		Scanner input = new Scanner(System.in);
		int cups = 11;
		System.out.println("How many cups of coffee?");
		cups = input.nextInt();
		while(cups > coffeeLeft) {
		System.out.println("Error not enough coffee left: How many cups of coffee?");
		cups = input.nextInt();
		}
		coffeeLeft = coffeeLeft - cups;
		totalCost += (cups * 1.10);
		}
	}
	// Method to determine how much money has been spent on coffee and extras
	public void getTotalCost() {
		System.out.println("Total Cost: " + totalCost);
	}
	// adds mocha to coffee / adjusts price
	public void addMocha() {
		System.out.println("Adding mocha");
		totalCost += .90;
	}
	// adds whip cream to coffee and adjusts price
	public void addWhip() {
		System.out.println("Adding whip");
		totalCost += 1.25;
	}
	// adds cinammon to coffee and adjusts price
	public void addCinammon() {
		System.out.println("Adding cinammon");
		totalCost += .90;
	}
	// closes relief valve
	public void closeValve() {
		isValveOpen = false;
		System.out.println("Relief valve closed");
	}
	// opens relief valve
	public void openValve() {
		isValveOpen = true;
		System.out.println("Relief valve open");
	}
	// changes the strength of coffee if input is not available sets to medium by default
	public void selectStrength(String strength) {
		if(strength.compareTo("Light") == 0 || strength.compareTo("light") == 0) {
			this.strength = "Light";
			System.out.println("Coffee set to light");
		}
		else if(strength.compareTo("Dark") == 0 || strength.compareTo("dark") == 0) {
			this.strength = "Dark";
			System.out.println("Coffee set to dark");
		}
		else if(strength.compareTo("Medium") == 0 || strength.compareTo("medium") == 0) {
			this.strength = "Medium";
			System.out.println("Coffee set to medium");
		}
		else {
			this.strength = "Medium";
			System.out.println("Input Error: Coffee set to medium by default");
		}
	}
	// Sprays the coffee with the strength input
	public void spray() {
		if(strength.compareTo("Medium") == 0) {
			System.out.println("Spraying coffee moderately");
		}
		else if(strength.compareTo("Dark") == 0) {
			System.out.println("Spraying coffee dark");
		}
		else if(strength.compareTo("Light") == 0) {
			System.out.println("Spraying coffee lightly");
		}
	}
	// fills holder with filter and coffee grounds
	public void fillHolder() {
		this.isHolderFull = true;
		System.out.println("Coffee and filter placed into holder.");
	}
	// brewing process, used to interrupt as well as adjusts coffeeLeft and waterLeft
	public void brew() {
		if(this.isBoilerFull && this.isPotOn && this.isPotEmpty && this.interrupt == true) {
			System.out.println("Brewing coffee");
			heatBoiler(true);
			closeValve();
			spray();
				while(this.interrupt == true) {
					for(coffeeLeft = this.coffeeLeft; coffeeLeft < 10;) {
						coffeeLeft+= 2;
						waterLeft -= 2;
				System.out.println(coffeeLeft + " cups brewed. Would you like to interrupt now?");
				Scanner input = new Scanner(System.in);
				String input1 = input.nextLine();
				if(input1.compareTo("Yes") == 0 || input1.compareTo("yes") == 0) {
					heatBoiler(false);
					openValve();
					isLightOn = true;
					System.out.println("Indicator light on");
					System.out.println(coffeeLeft + " cups ready");
					interrupt();
					return;
				}
				}
			}
		}
		if(this.isBoilerFull && this.isPotOn && this.isPotEmpty) {
			System.out.println("Brewing coffee");
			heatBoiler(true);
			closeValve();
			spray();
			heatBoiler(false);
			openValve();
			isLightOn = true;
			System.out.println("Indicator light on");
			for(waterLeft = this.waterLeft; waterLeft > 0; waterLeft--) {
				coffeeLeft++;
			}
			System.out.println(coffeeLeft + " cups ready");
		}
		
		else {
			System.out.println("A step has not been completed");
		}
	}
	// heats the boiler
	public void heatBoiler(boolean isBoilerHeatOn) {
		this.isBoilerHeatOn = isBoilerHeatOn;
		if(this.isBoilerHeatOn) {
			System.out.println("Heating element for boiler on.");
		}
		else {
			System.out.println("Heating element for boiler off.");
		}
	}
	// checks the boilerSensor
	public boolean checkBoilerSensor() {
		return isBoilerFull;
	}
	// heats warmer plate for coffee brewing
	public void heatWarmerPlate(boolean isWarmerPlateOn) {
		this.isWarmerPlateOn = isWarmerPlateOn;
	}
	// Plate sensor check
	public boolean checkPlateSensor() {
		return this.isPotOn;
	}
	// Pot sensor check
	public void potSensor(boolean isPotEmpty) {
		this.isPotEmpty = isPotEmpty;
	}
	// moves coffee pot off and on the plate
	public void moveCoffeePot() {
		if(this.checkPlateSensor() == true) {
		this.isPotOn = false;
		System.out.println("Coffee Pot is moved off the warmer");
		this.isWarmerPlateOn = false;
		this.isLightOn = false;
		}
		else if(this.checkPlateSensor() == false && coffeeLeft > 0) {
			this.isPotOn = true;
			this.isWarmerPlateOn = true;
			System.out.println("Coffee Pot is moved onto the warmer. Warmer is on");
		}
		else if(this.checkPlateSensor() == false && coffeeLeft == 0) {
			this.isPotOn = true;
			this.isWarmerPlateOn = false;
			System.out.println("Coffee Pot is moved onto the warmer. Warmer is off");
		}
		}
	// fills boiler with water and adjusts waterLeft
	public void fillBoiler() {
		if(this.isBoilerFull == true) {
			System.out.println("The boiler is already full");
		}
		else {
			this.isBoilerFull = true;
			System.out.println("The boiler has been filled");
			waterLeft = 10;
		}
	}
}