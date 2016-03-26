package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LittleElephantAndPermutationDiv2 {
	static public boolean next_permutation(int[] p) {
		for (int a = p.length - 2; a >= 0; --a) {
			if (p[a] < p[a + 1]) {
				for (int b = p.length - 1;; --b) {
					if (p[b] > p[a]) {
						int t = p[a];
						p[a] = p[b];
						p[b] = t;
						for (++a, b = p.length - 1; a < b; ++a, --b) {
							t = p[a];
							p[a] = p[b];
							p[b] = t;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	int magic(int[] per, int[] per2) {
		int res= 0;
		
		for (int i = 0; i < per.length; ++i) {
			res += Math.max(per[i], per2[i]);
		}
		
		return res;
	}
	
	public long getNumber(int N, int K) {
		long res = 0;
		int per[] = new int[N];
		
		for (int i = 0; i < N; ++i) {
			per[i] = i + 1;
		}
		int k = 1;
		for (int i = 1; i <= N; ++i) {
			k *= i;
		}
		int[] prevPre = per.clone();

		do {
			if (magic(prevPre, per) >= K) {
				++res;
			}			
		} while(next_permutation(per));
		
		return res * k;
	}
	@Test
	public void test() {
		assertTrue( getNumber(9,65) == 1881169920);
		assertTrue( getNumber(10,47) == 13168189440000L);
		assertTrue( getNumber(3,8) == 18);
		assertTrue( getNumber(2,1) == 4);
	}
}
