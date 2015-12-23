package com.topcoder;

import static org.junit.Assert.assertTrue;

public class RelationClassifier {
	public String isBijection(int[] domain, int[] range) {
		boolean[] dp = new boolean[101];
		boolean[] dp2 = new boolean[101];
		
		for (int i = 0; i < range.length; ++i) {
			if (!dp[domain[i]] && !dp2[range[i]]) {
				dp[domain[i]] = true;
				dp2[range[i]] = true;
			}
			else return "Not";
		}
		return "Bijection";
	}
	
	public void test() {
		assertTrue( isBijection(new int[]{1, 1}, new int[] {2, 3}).equals("Not") );
	}
}
