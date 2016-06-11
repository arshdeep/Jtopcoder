package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ColorfulGardenHard {
	char[] garden;
	char[] forbid;
	Integer[][][] dp;
	static final int mod = 1000000007;
	
	int solve(int index, int mask, int prev) {
		if (index == garden.length) {
			return 1;
		}
			
		Integer res = dp[index][mask][prev];
		
		if (res == null) {
			res = 0;
			for (int i = 0; i < garden.length; ++i) {
				if ((mask & (1<<i)) == 0) {
					if (index == 0 || garden[i] != garden[prev]) {
						if (garden[i] != forbid[index]) {
							boolean flag = true;
							for (int j = 0; j < i; ++j) {
								if ((mask & (1<<j)) == 0 && garden[j] == garden[i]) { 
									flag  = false;
									break;
								}
							}
							if (flag)
								res = (res + (solve(index + 1, mask | (1<<i), i) % mod)) % mod;
						}
					}
				}
			}
		}
		return dp[index][mask][prev] = res;
	}
	public int count(String garden, String forbid) {
		this.forbid = forbid.toCharArray();
		this.garden = garden.toCharArray();

		Arrays.sort(this.garden);
		int n = garden.length();
		this.dp = new Integer[n][1<<n][n];
		return solve(0, 0, 0);
	}
	@Test
	public void test() {
		assertTrue(count("abcdefghijklmno", "zzzzzzzzzzzzzzz") == 674358851);
		assertTrue(count("aabbcc", "aabbcc") == 5);
		assertTrue(count("aaabbb", "cccccc") == 2);
	}
}
