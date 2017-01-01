package com.topcoder.archive;

import java.util.Arrays;

public class SortingSubsets {
	public int getMinimalSize(int[] a)
	{
		int dup[] = Arrays.copyOf(a, a.length);
		
		Arrays.sort(dup);
		
		int ret = 0;
		for (int i = 0; i < a.length; ++i) {
			if (dup[i] != a[i]) {
				++ret;
			}
		}
		
		return ret;
	}
}
