package lab6;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class Carnage {
	PriorityQueue<Integer> zombie = new PriorityQueue<Integer>();
	PriorityQueue<Integer> vampire = new PriorityQueue<Integer>();
	LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
	public Carnage() {
		setZombie();
		setVampire();
	}
	
	
	public void setZombie() {
		for(int i = 0; i < 7; i++) {
			zombie.offer(i);
		}
	}
	
	public void setVampire() {
		for(int i = 0; i < 7; i++) {
			vampire.offer(i);
		}
		
	}

	public void compareTo(int index, Victims v) {
		double iqNum =(((v.iq.get(index))-50)/150.0);
		double apperanceNum = (v.apperance.get(index)/10.0);
//		System.out.println("iqNum "+ iqNum);
//		System.out.println("appNum" + apperanceNum);
			if( iqNum > apperanceNum) {
				System.out.print(" is eaten by ZOMBIE number " + zombie.peek());				
				map.put(v.name.get(index), zombie.peek());
				zombie.remove();
			}
			else {
				System.out.print(" is eaten by VAMPIRE number " + vampire.peek());				
				map.put(v.name.get(index), vampire.peek());
				vampire.remove();

			}
		}
		
	}
	


