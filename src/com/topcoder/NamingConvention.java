package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NamingConvention {
	public String toCamelCase(String variableName) {
		String[] in = variableName.split("_");
		
		String out = in[0];
		for (int i = 1; i < in.length; ++i) {
			StringBuffer temp = new StringBuffer(in[i]);
			
			temp.setCharAt(0, (char)('A' + temp.charAt(0) - 'a'));
			out += temp.toString();
		}
		
		return out;
	}
	
	@Test
	public void test1()
	{
		assertTrue( toCamelCase("sum_of_two_numbers").equals("sumOfTwoNumbers") );
	}
}
