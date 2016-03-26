package com.topcoder.archive;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BearCries {
	String mMessage;
	long dp[][][];
	long MOD = 1000000007;
	
	long go(int idx, int a, int b) {
		long res = dp[idx][a][b];
		
		if (res != -1) {
			return res;
		}

		if (idx == mMessage.length()) {
			return a == 0 && b == 0 ? 1 : 0;
		}
		res = 0;
		
		if (mMessage.charAt(idx) == ';') {
			if (a < mMessage.length()/3)
				res += go(idx + 1, a + 1, b);
			if (b > 0)
				res+= (b * go(idx + 1, a, b - 1)) % MOD;
		}
		else {
			if (a > 0)
				res += (a * go(idx + 1, a - 1, b + 1)) % MOD;
			if (b > 0)
				res += (b * go(idx + 1, a, b)) %MOD;			
		}
		
		dp[idx][a][b] = (res % MOD);
		
		return res;
	}
	public int count(String message) {
		dp = new long[201][201][201];
		
		for (int i = 0; i < 201; ++i) {
			for (int j = 0; j < 201; ++j) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		mMessage = message;
		int res = (int)go(0, 0, 0);
		
		return res;
	}

	@Test
	public void test() {
		assertTrue(count(";_;;_____;") == 2);
		assertTrue(count(";;;___;;;") == 36);
		assertTrue(count("_;__;") == 0);
		assertTrue(count(";_;;__;_;;") == 52);
		assertTrue(count(";__;____;") == 0);
		assertTrue(count(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;______________________________________________________________________;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;") == 966319858);
		assertTrue(count(";_____________________________________;") == 1);
		assertTrue(count(";___;______________________________________________________________________________________________________________________________________________________________________________________________;___;") == 907225484);
	}
}
