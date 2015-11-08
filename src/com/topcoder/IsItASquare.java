package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IsItASquare {
	int eucldian(int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		return dx*dx + dy*dy;
	}
	public String isSquare(int[] x, int[] y) {
		
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				if (i == j) continue;
				
				for (int k = 0; k < 4; ++k) {
					if (i == k || j == k) continue;
					
					for (int l = 0; l < 4; ++l) {
						if (l == i || l == j || l == k) continue;
						
						int ab = eucldian(x[i], y[i], x[j], y[j]);
						int ac = eucldian(x[i], y[i], x[k], y[k]);
						int bd = eucldian(x[j], y[j], x[l], y[l]);
						int cd = eucldian(x[k], y[k], x[l], y[l]);
						
						int ad = eucldian(x[i], y[i], x[l], y[l]);
						int bc = eucldian(x[j], y[j], x[k], y[k]);
						
						if (ab == ac && ab == bd && ab == cd && ad == bc) {
							return "It's a square";
						}
					}
				}
			}
		}
		
		return "Not a square";
	}

	@Test
	public void test() {
		assertTrue( isSquare(new int[]{0, 0, 2, 2}, new int[]{0, 2, 0, 2}).equals("It's a square") );
		assertTrue( isSquare(new int[]{0, 1, 5, 6}, new int[]{1, 6, 0, 5}).equals("It's a square") );
		assertTrue( isSquare(new int[]{0, 0, 7, 7}, new int[]{0, 3, 0, 3}).equals("Not a square") );
	}
		
}
