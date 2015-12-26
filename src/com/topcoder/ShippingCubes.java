package com.topcoder;

public class ShippingCubes {
	public int minimalCost(int N) {
		int res = Integer.MAX_VALUE;
		
		for (int a = 1; a <= N; ++a) {
			for (int b = 1; b <= N; ++b) {
				for (int c = 1; c <= N; ++c) {
					if (a * b * c == N) {
						res = Math.min(res, a + b + c);
					}
				}
			}
		}
		return res;
	}
}
