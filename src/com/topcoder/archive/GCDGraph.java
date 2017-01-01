package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GCDGraph {
	int gcd (int a, int b) {
		while (b != 0) {
			int z = b;
			b = a % b;
			a = z;
		}
		return a;
	}
	int parent[];
	int getParent(int i) {
		if (parent[i] != i) {
			return parent[i] = getParent(parent[i]);
		}
		return i;
	}
	public String possible(int n, int k, int x, int y)
	{
		parent = new int[1000005];
		
		for (int i = 1; i <= n; ++i) {
			parent[i] = i;
		}
		
		for (int i = k + 1; i <= n; ++i) {
			int p = getParent(i);
			
			for (int j = i; j <= n; j += i) {
				if (gcd(i,j) > k) {
					int pp = getParent(j);
					parent[pp] = p;
				}
			}
		}
		return getParent(x) == getParent(y) ? "Possible" : "Impossible";
	}
	@Test
	public void test() {
		assertTrue(possible(12,2,11,12).equals("Impossible"));
	}
}
