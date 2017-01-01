package com.topcoder.archive;

import java.util.ArrayList;
import java.util.Collections;

public class GridSort {
	public String sort(int n, int m, int[] grid) {
		
		for (int i = 0; i < m; ++i) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int j = 0; j < n; ++j) {
				al.add(grid[j * m + i]);
			}
			Collections.sort(al);
			int val = al.get(0);
			for (int i1 = 1; i1 < al.size(); ++i1) {
				if (val + m != al.get(i1)) {
					return "Impossible";
				}
				val = al.get(i1);
			}
		}
		
		for (int i = 0; i < n; ++i) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int j = 0; j < m; ++j) {
				al.add(grid[i * m + j]);
			}
			Collections.sort(al);
			int val = al.get(0);
			for (int i1 = 1; i1 < al.size(); ++i1) {
				if (val != al.get(i1) - 1) {
					return "Impossible";
				}
				val = al.get(i1);
			}
		}
		
		return "Possible";
	}
}
