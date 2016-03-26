package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SwappingDigits {
	void swap(char[] x, int a, int b) {
		char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
	
	public String minNumber(String num) {
		char[] ca = num.toCharArray();
		String res = num;
		
		for (int i = 0; i < num.length(); ++i) {
			for (int j = 0; j < num.length(); ++j) {
				if (i != j) {
					swap(ca, i, j);
					if (ca[0] != '0') {
						if (res.compareTo(String.valueOf(ca)) > 0) {
							res = String.valueOf(ca);
						}
					}
					swap(ca, i, j);
				}
			}
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( minNumber("93218910471211292416").equals("13218910471211292496") );
		assertTrue( minNumber("10234").equals("10234") );
		assertTrue( minNumber("93561").equals("13569") );
		assertTrue( minNumber("596").equals("569") );
	}
}
