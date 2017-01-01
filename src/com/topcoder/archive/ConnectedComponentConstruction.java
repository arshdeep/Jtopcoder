package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class ConnectedComponentConstruction {
	HashMap<Integer, HashSet<Integer>> hm;
	void add(int i , int j) {
		if (hm.containsKey(i)) {
			hm.get(i).add(j);
		}
		else {
			HashSet<Integer> hs = new HashSet<Integer>();
			hs.add(j);
			hm.put(i, hs);
		}
	}
	public String[] construct(int[] s)
	{
		hm = new HashMap<Integer, HashSet<Integer>>();
		int n = s.length;
		for (int i = 0; i < n; ++i) if (s[i] > 1) {
			for (int j = i + 1; j < n; ++j) {
				if (s[j] == s[i]) {
					if (hm.containsKey(i)) {
						if (hm.get(i).size() + 1 >= s[i]) {
							continue;
						}
					}
					if (hm.containsKey(j)) {
						if (hm.get(j).size() + 1 >= s[j]) {
							continue;
						}
					}

					add(i, j);
					add(j, i);
				}
				
			}
			if (!hm.containsKey(i) || hm.containsKey(i) && hm.get(i).size() + 1 != s[i]) {
				return new String[]{};
			}
		}
		
		String[] ret = new String[n];
		
		for (int i = 0; i < n; ++i) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < n; ++j) {
				sb.append("N");
			}
			
			HashSet<Integer> hs = hm.get(i);
			if (hs != null) {
				for (int x : hs) {
					sb.setCharAt(x, 'Y'); 
				}
			}
			ret[i] = sb.toString();
		}		
		return ret;
	}
	@Test
	public void test() {
		assertTrue(Arrays.equals(construct(new int[]{4,4,4,4,4}), new String[]{}));
		assertTrue(Arrays.equals(construct(new int[]{2,1,1,2,1}), new String[]{"NNNYN", "NNNNN", "NNNNN", "YNNNN", "NNNNN" }));
	}

}
