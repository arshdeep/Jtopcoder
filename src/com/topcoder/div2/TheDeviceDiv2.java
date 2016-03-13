package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TheDeviceDiv2 {
	public String identify(String[] plates) {
		for (int j = 0; j < plates[0].length(); ++j) {
			int ones = 0;
			int zeros = 0;
			for (int i = 0; i < plates.length; ++i) {
				if (plates[i].charAt(j) == '1') {
					++ones;
				}
				else if (plates[i].charAt(j) == '0') {
					++zeros;
				}
			}
			if (ones <= 1 || zeros == 0) {
				return "NO";
			}
		}
		return "YES";
	}
	
	@Test
	public void test(){
		
		assertTrue( identify(new String[]{"1", "0", "0"}).equals("NO"));
		assertTrue( identify(new String[]{"010",
				 "011",
		 "000"}).equals("NO"));
	}	
}
