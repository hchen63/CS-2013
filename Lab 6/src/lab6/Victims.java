package lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Victims implements Comparator{
	 List<String> name = new ArrayList<String>();
	 List<Integer> iq = new ArrayList<Integer>();
	 List<Integer> apperance = new ArrayList<Integer>();
	
	
	 public Victims() {
		 setName();
		 setIq();
		 setApperance();
		
	}
	
	public void setName() {
		name.add("Bob");
		name.add("Joe");
		name.add("Susuan");
		name.add("Stan");
		name.add("Mary");
		name.add("Harry");	
	}
	
	public String getName(int index) {
		return name.get(index);
	}
	
	public void setIq() {
		for(int i = 0; i < name.size(); i++) {
			int num =  (int) (50 + (Math.random() * ((200 - 50))));
			iq.add(num);
		}	
	}	
	
	public int getIq(int index) {
		return iq.get(index);
	}
	
	public void setApperance() {
		for(int i = 0; i < name.size(); i++) {
			int num =  (int) (1 + (Math.random() * ((10 - 1))));
			apperance.add(num);
		}	
	}
	
	public int getApperance(int index) {
		return apperance.get(index);
	}
	
	public String toString(int index) {
		return name.get(index) + ": intelligence " + iq.get(index) 
		+ ", appearance " + apperance.get(index);
	}

	public enum Zombie{
		iq;
		
		void setIq(Victims v) {
			for(int i = 0; i < v.iq.size(); i++) {
				System.out.println(v.getIq(i));
				v.getIq(i);
				
			}
		}
	}

	public enum Vampire{
		apperance;
		void setApperance(Victims v) {
			for(int i = 0; i < v.apperance.size(); i++) {
				System.out.println(v.getApperance(i));
				v.getApperance(i);
				
			}
		}
	}

	@Override
	public int compare(Object o1, Object o2) {
		
		for(int i = 0; i < name.size(); i++) {
			double iqNum =((iq.get(i)-50)/150.0);
			double apperanceNum = (apperance.get(i)/10.0);
//			System.out.println(iqNum);
//			System.out.println(apperanceNum);
			if(iqNum > apperanceNum) {
//				System.out.println("IQ");
				return -1;
				
			}
			else if(iqNum < apperanceNum) {
//				System.out.println("APP");
				return 1;
			}
		}
		
			return 0;
	}
}
