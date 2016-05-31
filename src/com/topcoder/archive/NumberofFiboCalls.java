package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.Arrays;

import org.junit.Test;

public class NumberofFiboCalls {
	Point[] memo;
	int memoCount;
	Point solve(int n) {
		if (n < 0) {
			return new Point(0,0);
		}
		else if (n == 0) {
			return new Point(1,0);
		}
		else if (n == 1) {
			return new Point(0,1);
		}
		if (memo[n] != null) {
			++memoCount;
			System.out.println("memo hit: " + n);
			return memo[n];
		}
		Point fib1 = solve(n - 1);
		Point fib2 = solve(n - 2);
		
		return memo[n] = new Point(fib1.x + fib2.x, fib1.y + fib2.y);
	}
	public int[] fiboCallsMade(int n) {
		memo = new Point[n + 1];
		memoCount = 0;
		Point pt = solve(n);
		int[] ret = {pt.x, pt.y};
		System.out.println(memoCount);
		return ret;
	}
	@Test
	public void test() {
		assertTrue( Arrays.equals(fiboCallsMade(17), new int[]{987, 1597}) );
		assertTrue( Arrays.equals(fiboCallsMade(25), new int[]{46368, 75025}) );
		assertTrue( Arrays.equals(fiboCallsMade(39), new int[]{39088169, 63245986}) );
		assertTrue( Arrays.equals(fiboCallsMade(40), new int[]{63245986, 102334155}) );
		assertTrue( Arrays.equals(fiboCallsMade(0), new int[]{1, 0}) );
		assertTrue( Arrays.equals(fiboCallsMade(3), new int[]{1,2}) );
		assertTrue( Arrays.equals(fiboCallsMade(6), new int[]{5,8}) );
		assertTrue( Arrays.equals(fiboCallsMade(22), new int[]{10946, 17711}) );

	}	
}
