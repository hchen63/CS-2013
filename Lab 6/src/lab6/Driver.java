package lab6;

import java.util.LinkedHashMap;

import lab6.Victims.Vampire;
import lab6.Victims.Zombie;

public class Driver {
	
	static Carnage c = new Carnage();
	
	public static void main(String[] args) {
		
		Victims v = new Victims();
		
		Zombie z = Zombie.iq;
		Vampire vamp = Vampire.apperance;
		v.compare(z, vamp);
		monsterAttack(v,z, vamp);

	}
	
	public static void monsterAttack(Victims v,Zombie z , Vampire vamp) {
		for(int i = 0; i < v.name.size(); i++) {
			System.out.print(v.toString(i));
			c.compareTo(i, v);
			System.out.println("");
			
		}
	}
	

}
