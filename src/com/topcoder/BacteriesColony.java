package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class BacteriesColony {
	public int[] performTheExperiment(int[] colonies) {
		boolean isChanged = true;
		int[] copy = colonies.clone();
		while (isChanged) {
			
			isChanged = false;
			for (int  i = 1, size = colonies.length; i < size - 1; ++i) {
				if (colonies[i - 1] > colonies[i] && colonies[i] < colonies[i + 1]) {
					isChanged = true;
					copy[i] += 1;
				}
				else if (colonies[i - 1] < colonies[i] && colonies[i] > colonies[i + 1]) {
					copy[i] -= 1;
					isChanged = true;
				}
				
			}
			colonies = copy.clone();
		}
		return colonies;
	}
	
	@Test
	public void test() {
	    assertTrue( Arrays.equals(performTheExperiment(new int[]{1, 5, 4, 9 }), new int[]{1, 4, 5, 9 }) );
	    assertTrue( Arrays.equals(performTheExperiment(new int[]{32, 68, 50, 89, 34, 56, 47, 30, 82, 7, 21, 16, 82, 24, 91 }),
	    		new int[]{32, 59, 59, 59, 47, 47, 47, 47, 47, 18, 18, 19, 53, 53, 91 }) );
	}	

}
