package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class SimilarUserDetection {
	public String haveSimilar(String[] handles)
	{
		HashSet<String> hs = new HashSet<String>();

		for (int i = 0; i < handles.length; ++i) {
			String s = handles[i];
			
			if (s.contains("O")) {
				s = s.replaceAll("O", "0");
			}
			if (s.contains("1")) {
				s = s.replaceAll("1", "I");
			}
			if (s.contains("l")) {
				s = s.replaceAll("l", "I");
			}
			if (hs.contains(s)) {
				return "Similar handles found";
			}
			hs.add(s);
		}
		return "Similar handles not found";
	}
	@Test
	public void test() {
		
		assertTrue(haveSimilar(new String[]{"i23", "123", "456", "789", "000", "o", "O"}).equals("Similar handles not found"));
		assertTrue(haveSimilar(new String[]{"top", "coder", "TOPCODER", "TOPC0DER"}).equals("Similar handles found"));
		assertTrue(haveSimilar(new String[]{"top", "coder", "T0PCODER", "TOPC0DER"}).equals("Similar handles found"));
	}
}
