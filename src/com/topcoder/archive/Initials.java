package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Initials {
	public String getInitials(String name)
	{
		String ret = "";
		String[] arr = name.split(" ");
		for (String str : arr) {
			ret += String.valueOf(str.charAt(0));
		}
		
		return ret;
	}
	@Test
	public void test() {
		assertTrue(getInitials("abc cc").equals("ac"));
	}
}
