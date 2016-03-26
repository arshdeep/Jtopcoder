package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LuckyXor {
	boolean isLucky(String str) {
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != '4' && str.charAt(i) != '7') {
				return false;
			}
		}
		
		return true;
	}
	public int construct(int a){ 
		for (int b = a + 1; b <= 100; ++b) {
			if (isLucky(String.valueOf(a^b))) {
				return b;
			}
		}
		
		return -1;
	}
	@Test
	public void test(){
		
		assertTrue( construct(4) == 40);
	}	
}
