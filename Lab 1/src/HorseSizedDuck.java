
public class HorseSizedDuck extends Animal{
	
	double wind;
	
	public HorseSizedDuck(double wind){
		this.power = 0.1;
		this.accuracy = 0.1/wind;
		this.name = "Daffy";
		
	}
	public double getPower() {
		return 0.1;
	}
	
	public double getAccuracy(double wind) {
		return 0.1/wind;
	}
	
	public String setName() {
		return "Daffy";
	}
	
	public String toString() {
		return " ";
	}

}
