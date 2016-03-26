package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=13951&rd=16551&rm=&cr=14970299*/
public class BearDarts {
	int gcd (int a, int b) {
		while (b != 0) {
			int z = b;
			b = a % b;
			a = z;
		}
		return a;
	}
	public long count(int[] w) {
		long ans = 0;
		HashMap<Point, Integer> dp = new HashMap<Point, Integer>();
		int len = w.length;
		for (int i = len - 3; i >= 0; --i) {
			int j = i + 1;
			
			for (int k = i + 2; k < len; ++k) {
				int cf = gcd(w[k], w[j]);
				Point ir = new Point(w[k]/cf, w[j]/cf);

				if (dp.containsKey(ir)) {
					dp.put(ir, dp.get(ir) + 1);
				}
				else {
					dp.put(ir, 1);
				}
			}
			
			for (int z = 0; z < i; ++z) {
				int cf = gcd(w[z], w[i]);
				Point ir = new Point(w[z]/cf, w[i]/cf);
				
				if (dp.containsKey(ir)) {
					ans += dp.get(ir);
				}
			}
		}

		return ans;
	}
	
	@Test
	public void test() {
		assertTrue( count( new int[]{6,8,4,3,6}) == 2 );
		assertTrue( count( new int[]{3,4,12,1}) == 0 );
		assertTrue( count( new int[]{1,1,1,1,1}) == 5 );
		assertTrue( count( new int[]{42,1000000,1000000,42,1000000,1000000}) == 3 );
		assertTrue( count( new int[]{1,2,3,4,5,6,5,4,3,2,1}) == 22 );
		assertTrue( count( new int[]{33554432, 33554432, 67108864, 134217728}) == 0 );
	}
}
