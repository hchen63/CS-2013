package lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class RoadMapBFTraversal {
	private RoadMap c;

	public RoadMapBFTraversal(RoadMap c) {
		this.c = c;
	}
	
	public List<String> getTraversal(String start) {
		String[] node = (String[]) c.getSortedListOfNodes().toArray();
		System.out.println(Arrays.toString(node));
		
		List<String> left = null;
		List<String> right = null;
		for(int i = 0; i < node.length; i++) {
			if(start.compareTo(node[i]) < 0) {
				left.add(node[i]);
			}else
				right.add(node[i]);
		}
		System.out.println(start);
		for(int i = 0; i < node.length; i++) {
			System.out.println(left.get(node.length - i));
			System.out.println(right.get(i));
		}
;
		System.out.println();
		
		return null;
		
	// complete code here, using additional methods if necessary
	}

}
