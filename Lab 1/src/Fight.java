
public class Fight {

	
	public static void main(String[] args) {
		
		double rain = 0 + (Math.random() * ((1 - 0)));
		double wind = 0 + (Math.random() * ((1 - 0)));
		
		
		HorseSizedDuck HSD = new HorseSizedDuck(wind);
		DuckSizedHorse DSH = new DuckSizedHorse(rain);
//		Animal animal = new Animal();
		
		System.out.println("HorseSizedDuck named " + HSD.setName()
		+ " created with power " + HSD.getPower() + " and accuracy = "
				+ HSD.getAccuracy(wind));
		
		System.out.println("DuckSizedHorse named " + DSH.setName()
		+ " created with power " + DSH.getPower(rain) + " and accuracy = "
				+ DSH.getAccuracy());
		
		System.out.println("Fight begins with wind level " + wind + " and rain level " + rain);

//		Animal.isAlive();
		while(true) {
			HSD.attack(DSH);
			if(!DSH.isAlive()) {
				System.out.println(HSD.setName() + " wins");
				break;
			}
			DSH.attack(HSD);
			if(!HSD.isAlive()) {
				System.out.println(DSH.setName() + " wins");
				break;
			}
		}
	}

}
