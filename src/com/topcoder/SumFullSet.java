package com.topcoder;

import java.util.HashSet;

public class SumFullSet {
	String isSumFullSet(int[] elements) {
		HashSet<Integer> seen = new HashSet<Integer>();
		
		for (int i : elements) {
			seen.add(i);
		}
		int n = elements.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) if (j != i) {
				if (!seen.contains(elements[i] + elements[j])) {
					return "not closed";
				}
			}
		}
		return "closed";
	}
}
