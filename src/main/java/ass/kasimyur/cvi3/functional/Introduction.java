package ass.kasimyur.cvi3.functional;

import java.util.LinkedList;
import java.util.List;

public class Introduction {
	
	public static void main(String[] args) {
		
		// generate 20 string items
		List<String> items = new LinkedList<>();
		for(int i = 0; i < 20; i++) {
			if(i > 13) break;

			String item = "ITEM"+i; 
			if(!item.endsWith("5")) {
				items.add(item);
			}
		}
		
		// then convert them to lower case
		List<String> lower = new LinkedList<>();
		for(String s : items) {
			lower.add(s.toLowerCase());
		}
		
		// print them
		for(String s : lower) {
			System.out.println(s);
		}
	}
	
}
