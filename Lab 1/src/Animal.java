import java.util.Random;

public abstract class Animal {

	Random r = new Random();

	double health = 1.0; // if health reaches 0, the Animal dies

	double accuracy; // probability (0 to 1) that an attack by this Animal hits its target.

	double power; // amount of damage (0 to 1) done by a successful attack by this Animal

	String name;

	public boolean isAlive() {
		if (health > 0 ) {
			return true;
		}
		else
			return false;
		// write code here to return true if the Animal's health is a positive number,
		// otherwise false
	}

	// receiveInjury() is run when this animal is the victim of a successful attack

	public void receiveInjury(double d) {
		health = health - d;
		System.out.println(this.name + " does "  + d + " damage.");
		if(health <= 0 ) {
			System.out.println(this.name + " dies");
		}
		else {
			System.out.println(this.name + " reaming health = " + health);
		}

		// write code here to do the following:

		// reduce this Animal's health by d, the parameter

		// print a message about the damage

		// print a message if the Animal is now dead

		// otherwise, print a message showing the Animal's current health

	}

	public void attack(Animal target) {

		// write code here to do the following:
		System.out.print(this.name + " attacks " + target.getName());
		if(r.nextDouble() < accuracy) {
			receiveInjury(power);
		}
		else
			System.out.println(" but misses");
		// print a message indicating whom this Animal is attacking (name of the other
		// Animal)

		// get a random double between 0 and 1

		// if the random double is less than accuracy, the attack succeeds. In that
		// case,

		// call receiveInjury(power) on target. The argument is *this* Animal's power.

		// otherwise, the attack fails. Print a message indicating that the attack
		// missed.

	}

	public String getName() {
		return this.name;	
	}

}