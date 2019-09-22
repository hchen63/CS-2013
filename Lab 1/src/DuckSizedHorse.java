
public class DuckSizedHorse extends Animal{
	
	double rain;
	
	public DuckSizedHorse(double rain){
		this.power = 0.1/rain;
		this.accuracy = 0.1;
		this.name = "Mr. Ed";
		
	}
	public double getPower(double rain) {
		return 0.1/rain;
	}
	
	public double getAccuracy() {
		return 0.1;
	}
	
	public String setName() {
		return "Mr. Ed";
	}
	
	public String toString() {
		return " ";
	}

}
