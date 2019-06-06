package coffeeMakerProject;
/* 
 * My design allows for user input to designate amounts of coffee desired and when to interrupt
 * so some input will be required to get through the case tests.
 */
public class CoffeeMakerTest {
	public static void main(String[] args) {
		// Beginning of the first coffee test
		System.out.println("---------------Case Test 1--------------");
		// CoffeeMaker created
		CoffeeMaker a = new CoffeeMaker();
		// Runs through the basic process of brewing a pot of coffee
		System.out.println("Step 1: Put empty pot onto coffee maker warmer plate");
		a.moveCoffeePot();
		System.out.println("Step 2: Fill boiler with water");
		a.fillBoiler();
		System.out.println("Step 3: Put filter and coffee grounds into holder");
		a.fillHolder();
		System.out.println("Step 4: Select coffee strength");
		a.selectStrength("Light");
		System.out.println("Step 5: brew coffee");
		a.brew();
		// End of the first coffee test
		System.out.println("");
		System.out.println("------------Case test 2-------------");
		// Beginning of the second coffee test
		// Coffee Maker created
		CoffeeMaker b = new CoffeeMaker();
		b.moveCoffeePot();
		b.fillBoiler();
		b.fillHolder();
		b.selectStrength("Dark");
		b.brew();
		/* All previous lines were done in first case test.
		// In this one the coffee is moved. asks user the amount of cofee and then prints costs
		 as well as adds in extras*/
		b.moveCoffeePot();
		b.pourCoffee();
		b.moveCoffeePot();
		b.getTotalCost();
		b.addMocha();
		b.addCinammon();
		System.out.println("Updating cost");
		b.getTotalCost();
		System.out.println();
		
		System.out.println("------------Case test 3-------------");
		// Coffee Maker created
		CoffeeMaker c = new CoffeeMaker();
		c.moveCoffeePot(); 
		c.fillBoiler();
		c.fillHolder();
		c.selectStrength("Dark");
		c.interrupt();
		c.brew(); // new input required to interrupt when enough coffee has been brewed
		c.pourCoffee(); // checking that values are updated properly if you use some coffee
		// if you want to interrupt again then call c.interrupt()
		c.brew();
		
		System.out.println();
		System.out.println("-------Morning Routine-------");
		CoffeeMaker d = new CoffeeMaker();
		System.out.println("The coffee lady wakes up and brews a medium pot of coffee");
		d.moveCoffeePot();
		d.fillBoiler();
		d.fillHolder();
		d.selectStrength("Medium"); 
		d.interrupt();
		d.brew(); // Type "Yes" at 8 cups brewed for about 3/4 of the pot complete
		System.out.println("Coffee Lady interrupts the process around 3/4 of the way");
		d.pourCoffee(); // Input 1 to brew 1 cup only
		System.out.println("She adds whip to her medium coffee");
		d.addWhip();
		System.out.println("Writes down the cost");
		d.getTotalCost();
		System.out.println("Rushes to work");
		System.out.println();
		
		
		System.out.println("-------Evening routing-------");
		CoffeeMaker e = new CoffeeMaker();
		System.out.println("The coffee lady has invited her friend over");
		System.out.println("She brews a pot of coffee for her and her friend");
		e.moveCoffeePot();
		e.fillBoiler();
		e.fillHolder();
		e.selectStrength("Light");
		e.interrupt();
		e.brew(); // Type "Yes" at 2 or 4 cups for around 1/4 through
		System.out.println("Now she makes herself a cup of coffee with cinammon");
		e.pourCoffee();
		e.addCinammon();
		e.getTotalCost();
		System.out.println("She brews more coffee for her friend");
		e.brew();
		e.pourCoffee();
		e.addMocha();
		e.getTotalCost();
		
		
		
		
	}
}
