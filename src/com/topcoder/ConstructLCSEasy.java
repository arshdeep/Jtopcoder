package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConstructLCSEasy {
	public String construct(int ab, int bc, int ca)
	{
		StringBuffer a = new StringBuffer();
		
		for (int i = 0; i < ca; ++i) {
			a.append('0');
		}
		
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < bc; ++i) {
			b.append('1');
		}
		String c = a.toString() + b.toString();
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < ab; ++i) {
			temp.append("10");
		}
		for (int i = 0; i < ca - ab; ++i) {
			temp.append("0");
		}
		a = temp;
		return a.toString() + " " + b.toString() + " " + c.toString();
	}
	
	@Test
	public void test() {
		assertTrue(construct(6,7,8).equals("10101010 1011 1010101"));
		assertTrue(construct(4,4,7).equals("10101010 1011 1010101"));
		assertTrue(construct(2,3,4).equals("1111 101 1010101"));
	}
}
