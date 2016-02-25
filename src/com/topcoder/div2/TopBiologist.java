package com.topcoder;

import java.util.LinkedList;

public class TopBiologist {
	public String findShortestNewSequence(String sequence) {
		LinkedList<String> bfs = new LinkedList<String>();
		
		bfs.add("A");
		bfs.add("C");
		bfs.add("G");
		bfs.add("T");

		while (!bfs.isEmpty()) {
			String top = bfs.pollFirst();
			
			if (!sequence.contains(top)) {
				return top;
			}
			
			bfs.add(top + "A");
			bfs.add(top + "C");
			bfs.add(top + "G");
			bfs.add(top + "T");
		}
		
		return "";
	}
	
	
}
