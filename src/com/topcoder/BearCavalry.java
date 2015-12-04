package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class BearCavalry {
	final int LIMIT = 1_000_000_007;
	
	public int countAssignments(int[] warriors, int[] horses) {
		int res = 0;
		int n = warriors.length;
		int []war = Arrays.copyOfRange(warriors, 1, n);
		Arrays.sort(war);
		Arrays.sort(horses);
		for (int i = 0; i < n; ++i) {
			int mx = warriors[0] * horses[i];
			int []hor = new int[n - 1];
			int idx = 0;
			for (int j = 0; j < n; ++j) {
				if (j != i) {
					hor[idx++] = horses[j];
				}
			}
			
			long temp = 1;
			int X = 0;
			for (int j = n - 2; j >= 0; --j) {
				while (X < n - 1 && war[j] * hor[X] < mx) {
					++X;
				}
				int t = X - (n - 2 - j);
				if (t <= 0)  {
					temp = 0;
					break;
				}
				temp = (temp * t) % LIMIT;
			}
			
			res = (int)(res + temp) % LIMIT;
		}
		
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( countAssignments( new int[]{5,8,4,8}, new int[]{19,40,25,20}) == 2 );
		assertTrue( countAssignments( new int[]{10,2,10}, new int[]{100,150,200}) == 3 );
		assertTrue( countAssignments( new int[]{970,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,
				800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
				new int[]{1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
				1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,
				1000,1000,1000,1000,1000,1000,1000,1000,1000,1000}) == 318608048 );
	}
}
