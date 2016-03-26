package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FourStrings {
	public static String docat(String f, String s) {
		if (f.contains(s))
			return f;
	   if (!f.contains(s.substring(0,1)))
	     return f + s;
	   int idx = s.length();
	   try {
	     while (!f.endsWith(s.substring(0, idx--))) ;
	   } catch (Exception e) { }
	   return f + s.substring(idx + 1);
	}
	boolean next_permutation(int[] p) {
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
	public int shortestLength(String a, String b, String c, String d)
	{
		int res = a.length() + b.length() + c.length() + d.length();
		String[] arr = {a,b,c,d};
		int[] per = {0,1,2,3};
		
		do {
			res = Math.min(res, docat(docat(docat(arr[per[0]], arr[per[1]]), arr[per[2]]), arr[per[3]]).length());

		} while(next_permutation(per));
		

		return res;
	}
	@Test
	public void test() {
		assertTrue(docat("bacac", "acbaa").equals("bacacbaa"));
		assertTrue(docat("acbaa", "acbc").equals("acbaacbc"));
//		assertTrue( shortestLength("thereare", "arelots","lotsof","ofcases") == 19 );
		assertTrue( shortestLength("aba", "b","b","b") == 3 );
		assertTrue( shortestLength("acbc", "abbabcc","bacac","acbaa") == 18 );
	}
}
