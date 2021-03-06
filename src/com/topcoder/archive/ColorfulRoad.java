package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ColorfulRoad {
	char getNext(char ch) {
		if (ch == 'R') 
			return 'G';
		else if (ch == 'G')
			return 'B';
		
		return 'R';
	}
	int go(String road, char color, int start) {
		int cost = Integer.MAX_VALUE;
		
		for (int i = start; i < road.length(); ++i) {
			int temp = 0;
			if (road.charAt(i) == color) {
				temp = i - start;
				temp *= temp;
				if (i < road.length() - 1) {
					int ret = go(road, getNext(color), i);
					if (ret == Integer.MAX_VALUE)
						continue;
					temp += ret;
				}
				cost = Math.min(cost, temp);
			}
			
		}
		return cost;
	}
	public int getMin(String road) {
		int cost = go(road, 'G', 0);
		
		return cost == Integer.MAX_VALUE ? -1 : cost;
	}
	
	@Test
	public void test() {
		assertTrue( getMin("RGGGB") == 8);
		assertTrue(getMin("RBRGBGBGGBGRGGG")  == 52);
		
	}
}
