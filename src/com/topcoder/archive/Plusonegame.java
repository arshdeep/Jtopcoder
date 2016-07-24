package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Plusonegame {
	public String getorder(String s)
	{
		int plus = 0;
		int[] cc = new int[10];
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '+') {
				++plus;
			}
			else {
				cc[s.charAt(i) - '0'] += 1;
			}
		}
		
		String ret = "";
		int counter = 0;
		for (int i = 0; i < 10; ++i) {
			if (cc[i] > 0) {

				while ((int)Math.abs(counter - i) != 0 && plus > 0) {
					ret += "+";
					++counter;
					--plus;
				}
				while (cc[i] > 0) {
					ret += String.valueOf(i);
					--cc[i];
				}
			}
		}
		
		while (plus > 0) {
			ret += "+";;
			--plus;
		}
		
		return ret;
	}
	@Test
	public void test() {
		assertTrue(getorder("++++4++++200++2++1+6++++++").equals("00+1+22++4++6+++++++++++++") );
		assertTrue(getorder("+++++2+").equals("++2++++") );
	}	
}
