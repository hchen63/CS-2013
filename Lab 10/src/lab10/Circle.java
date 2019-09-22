package lab10;

import java.util.Arrays;

public class Circle {
	
	static double ci[];

	public Circle() {	

	}
	public void clone(double[] in) {
		ci = in.clone();
	}
	
	public double setRand() {
		double ra = 0;
		for( int i = 0; i < 10; i++) {
			ra = 5 + (Math.random() * ((70 - 5)));
//			ci[i] = ra;
		}return ra;
		
	}
	public double getRadius(int n, double[] ci) {		
		return ci[n];
	}

	public double getArea(int n, double[] ci) {
		double area = 2* Math.PI* Math.pow(getRadius(n, ci), 2);
		return area;
	}
	
	public String toString(int n, double[] ci) {		
		return "Circle with radius: " + getRadius(n, ci) + ", area " + getArea(n, ci);
	}

	public double compare(double a, double b) {
		// TODO Auto-generated method stub
		return a - b;
	}
}
