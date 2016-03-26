package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

/*https://community.topcoder.com/stat?c=problem_statement&pm=12807&rd=15856*/
public class CatchTheBeat {
	int lcs(int[] in, int n) {
		int[] dp = new int[n + 1];
		int lcs = 0;
		for (int i = 0; i < n; ++i) {
			int lo = 1;
			int hi = lcs;
			
			while (lo <= hi) {
				int mid = (hi + lo) / 2;
				
				if (in[dp[mid]] <= in[i]) {
					lo = mid + 1;
				}
				else {
					hi = mid - 1;
				}
			}
			
			int newL = lo;
			dp[newL] = i;
			
			if (newL > lcs)
				lcs = newL;
		}
		
		return lcs;
	}
	public int maxCatched(int n, int x0, int y0, int a, int b, int c, int d, int mod1, int mod2, int offset) {
		int x[] = new int[n];
		int y[] = new int[n];
		
		x[0] = x0;
		for (int i = 1; i < n; ++i)
		    x[i] = (int) (((long)x[i-1] * (long)a + (long)b) % mod1);
		
		for (int i = 0; i < n; ++i)
		    x[i] = x[i] - offset;
		
		y[0] = y0;
		for (int i = 1; i < n; ++i)
		    y[i] = (int) (((long)y[i-1] * (long)c + (long)d) % mod2);
		
		ArrayList<Point> al = new ArrayList<Point>();
		
		for (int i= 0, len = x.length; i < len; ++i) {
			if (y[i] >= 0 && Math.abs(x[i]) <= y[i])
				al.add(new Point(x[i] + y[i], y[i] - x[i]));
		}
		
		Collections.sort(al, new Comparator<Point>() {
			public int compare(Point arg0, Point arg1) {
				if (arg0.x != arg1.x)
					return arg0.x - arg1.x;
				return arg0.y - arg1.y;
			}
		});
		for (int i = 0; i < al.size(); ++i)
		    y[i] = al.get(i).y;
		
		return lcs(y, al.size());
	}
	
	@Test
	public void test()
	{
		assertTrue( maxCatched(3, 0, 0, 1, 1, 1, 1, 100, 100, 1) == 2 );
		assertTrue( maxCatched(1, 0, 1234, 0, 0, 0, 0, 1000000000, 1000000000, 1000	) == 1 );
		assertTrue( maxCatched(1, 0, 999, 0, 0, 0, 0, 1000000000, 1000000000, 1000	) == 0 );
		assertTrue( maxCatched(100, 0, 0, 1, 1, 1, 1, 3, 58585858, 1) == 66 );
		assertTrue( maxCatched(500000, 123456, 0, 1, 0, 1, 1, 1000000000, 1000000000, 0) == 376544 );
		assertTrue( maxCatched(500000, 0, 0, 0, 0, 0, 0, 1, 1, 0) == 500000 );
		assertTrue( maxCatched(10, 999999957, 79, 993948167, 24597383, 212151897, 999940854, 999999986, 999940855, 3404) == 3 );
	}
}
