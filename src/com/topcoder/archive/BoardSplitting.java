package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardSplitting {
	int gcd (int a, int b) {
		while (b != 0) {
			int z = b;
			b = a % b;
			a = z;
		}
		return a;
	}
	int lcm(int a, int b) {
		return (a*b) / gcd(a, b);
	}
	
	public int minimumCuts(int desiredLength, int desiredCount, int actualLength) {
		int res = 0;
		int count = lcm(desiredLength, actualLength) / desiredLength;
		
		
		while (desiredCount - count >= 0) {
			desiredCount -= count;
			res += (count - 1);
		}
		
		return res + desiredCount;
	}
	@Test
	public void test(){
		assertTrue( minimumCuts(336, 794, 916) == 791 );
		assertTrue( minimumCuts(212, 737, 173) == 733 );
		//assertTrue( minimumCuts(400, 5, 1000) == 5 );
		assertTrue( minimumCuts(500, 5, 1000) == 3 );
		assertTrue( minimumCuts(6,100,6) == 0 );
		assertTrue( minimumCuts(6,100,3) == 0 );
		assertTrue( minimumCuts(314, 159, 26) == 147 );
		assertTrue( minimumCuts(5, 4, 4) == 3 );
	}
}
