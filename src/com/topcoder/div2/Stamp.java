package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Stamp {
	public int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
		int cost = Integer.MAX_VALUE;
		int n = desiredColor.length();
		
		for (int len = 1; len <= n; ++len) {
			int[] dp = new int[n + 1];

			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			
			for (int i = 0; i < n; ++i) {
				int color = 7;
				for (int j = i; j < n; ++j) {
					
					switch (desiredColor.charAt(j)) {
						case 'R':
							color &= 1;
							break;
						case 'G':
							color &= 2;
							break;
						case 'B':
							color &= (1<<2);
							break;
					}
				
					if (color == 0) continue;
					int seg = j - i + 1;
					if (seg < len) continue;
					int pc = (seg + len - 1) / len;
					
					if (dp[i] != Integer.MAX_VALUE)
						dp[j + 1] = Math.min(dp[i] + pc * pushCost, dp[j + 1]);
				}
			}
			if (dp[n] != Integer.MAX_VALUE)
				cost = Math.min(cost, dp[n] + len * stampCost);
		}
		return cost;
	}
	@Test
	public void test() {
		assertTrue( getMinimumCost("R*RR*GG", 10, 58) == 204 );
	}
}
