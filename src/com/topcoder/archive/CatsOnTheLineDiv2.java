package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CatsOnTheLineDiv2 {
	public String getAnswer(int[] position, int[] count, int time) {
		int x = -10000;
		
		for (int i = 0; i < position.length; ++i) {
			for (int j = i + 1; j < position.length; ++j) {
				if (position[i] > position[j]) {
					int temp = position[i];
					position[i] = position[j];
					position[j] = temp;
					
					temp = count[i];
					count[i] = count[j];
					count[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < position.length; ++i) {
			for (int j = 0; j < count[i]; ++j) {
				int nx = Math.max(x + 1, position[i] - time);
				
				if (nx > position[i] + time) {
					return "Impossible";
				}
				else {
					x = nx;
				}
			}
		}
		return "Possible";
	}
	
	@Test
	public void test(){
		assertTrue( getAnswer(new int[]{0}, new int[]{7}, 3).equals("Possible") );
		assertTrue( getAnswer(new int[]{-1000, -999}, new int[]{1000, 1000}, 999).equals("Possible") );
	}
}
