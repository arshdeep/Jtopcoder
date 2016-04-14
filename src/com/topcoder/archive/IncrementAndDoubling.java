package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class IncrementAndDoubling {
	public int getMinEx(int[] desiredArray) {
		int res = 0;
		
		while (true) {
			Arrays.sort(desiredArray);
			if (desiredArray[desiredArray.length - 1] == 0) {
				break;
			}
			boolean odd = false;
			for (int i = 0; i < desiredArray.length; ++i) {
				if ((desiredArray[i] & 1) != 0 && desiredArray[i] > 0) {
					--desiredArray[i];
					++res;
					odd = true;
				}
			}
			
			if (!odd) {
				++res;
				for (int i = 0; i < desiredArray.length; ++i) {
					desiredArray[i] /= 2;
				}
			}
		}

		return res;
	}
	
	public int getMin(int[] desiredArray) {
		int res = 0;
		int db = 0;
		for (int i = 0; i < desiredArray.length; ++i) {
			int led = 32 - Integer.numberOfLeadingZeros(desiredArray[i]);
			res += Integer.bitCount(desiredArray[i]);
			db = Math.max(db, led - 1);
		}
		
		return res + db;
	}
	
	@Test
	public void test() {
		assertTrue( getMin(new int[]{123, 234, 345, 456, 567, 789}) == 40 );
		assertTrue( getMin(new int[]{100}) == 9 );
		assertTrue( getMin(new int[]{16, 16, 16}) == 7 );
		assertTrue( getMin(new int[]{2,1}) == 3 );
	}		
	
}
