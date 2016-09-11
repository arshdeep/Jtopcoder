package com.topcoder.archive;

import java.util.HashMap;

public class KingdomAndDucks {
	public int minDucks(int[] duckTypes) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int max = 0;
		
		for (int duck : duckTypes) {
			if (hm.containsKey(duck)) {
				hm.put(duck, hm.get(duck) + 1);
			}
			else {
				hm.put(duck, 1);
			}
			max = Math.max(max, hm.get(duck));
		}
		
		return max * hm.size();
	}

}
