package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RowAndCoins {
	String getWinner(String cells) {
		int a = cells.charAt(0) == 'A' ? 1 : 0;
		int b = cells.charAt(0) == 'B' ? 1 : 0;
		for (int i = 1; i < cells.length(); ++i) {
			if (cells.charAt(i) == 'A' && cells.charAt(i - 1) != 'A') {
				++a;
			}
			
			if (cells.charAt(i) == 'B' && cells.charAt(i - 1) != 'B') {
				++b;
			}
		}
		
		return a >= b ? "Alice" : "Bob";
	}
	@Test
	public void test() {
		assertTrue(getWinner("AABA").equals("Alice"));
		assertTrue(getWinner("BAAB").equals("Bob"));
		assertTrue(getWinner("AAAA").equals("Alice"));
		assertTrue(getWinner("ABBB").equals("Alice"));
		assertTrue(getWinner("BBBBBBBBBBBBB").equals("Bob"));
		assertTrue(getWinner("BA").equals("Alice"));
		assertTrue(getWinner("BBBAAABBAAABBB").equals("Bob"));
		assertTrue(getWinner("ABABABABABABB").equals("Alice"));
		assertTrue(getWinner("BBABABABABABB").equals("Bob"));
	}	
}
