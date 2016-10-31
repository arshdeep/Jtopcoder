package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class WordsGame {
	private int getDiff(String s1, String s2) {
		for (int i = 0; i < s1.length(); ++i) {
			if (!s2.contains(String.valueOf(s1.charAt(i)))) {
				return Integer.MAX_VALUE;
			}
		}
		int delta = 0;
		char[] tar = s2.toCharArray();
		for (int i = 0; i < s1.length(); ++i) {
			if (s1.charAt(i) != tar[i]) {
				for (int j = i + 1; j < s2.length(); ++j) {
					if (s1.charAt(i) == tar[j]) {
						char t = tar[i];
						tar[i] = s1.charAt(i);
						tar[j] = t;
					}
				}
				++delta;
			}
		}
		return delta;
	}

	public int minimumSwaps(String[] grid, String word) {
		int res = Integer.MAX_VALUE;
		
		for (int i = 0; i < grid.length; ++i) {
			res = Math.min(res, getDiff(word, grid[i]));
		}
		for (int i = 0; i < grid[0].length(); ++i) {
			String t = "";
			for (int j = 0; j < grid.length; ++j) {
				t += grid[j].charAt(i);
			}
			res = Math.min(res, getDiff(word, t));
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	@Test
	public void test() {
		assertTrue(minimumSwaps(new String[]{"kLKNRdVYDJ", "QHJfnjvekh", "CcNrihekJg", "eImXJadcfv", "AQdVPhfXui", "uHCgRHzHZT", "relqRsDgCo", "rVrCaLwinV", "YzSYZIXMSm", "HeQjvhJknf"}, "nhJHvefjQk") == 7);
		assertTrue(minimumSwaps(new String[]{"eKUNGHktLB",
				 "EtBFDndTlG",
				 "RRFHmjwrDs",
				 "eKYsHlYhlu",
				 "ljxyJSwTds",
				 "dUQToyWHvl",
				 "azDPWRwioE",
				 "EARdktoDBh",
				 "dmIqcGSvCE",
				 "wXypNQEMxz"}, "oDmWcJHGNk") == 6);
		assertTrue(minimumSwaps(new String[]{"xSZB",
				 "gbHk",
				 "kbgH",
				 "WFSg"}, "bkHg") == 2);
	}	
}
