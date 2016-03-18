package com.topcoder.div2;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class DivideByZero {
	boolean[] visited;
	void solve(ArrayList<Integer> al) {
		int nsize = 0;
		Collections.sort(al, Collections.reverseOrder());
		for (int i = 0; i < al.size(); ++i) {
			for (int j = i + 1; j < al.size(); ++j) {
				if (al.get(i) >= al.get(j) && al.get(j) > 0) {
					int no = al.get(i) / al.get(j);
					if (!visited[no]) {
						visited[no] = true;
						++nsize;
						al.add(no);
					}
				}
			}
		}
		if (nsize > 0) {
			solve(al);
		}
	}
	public int CountNumbers(int[] numbers) {
		visited = new boolean[101];
		//int res = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int no : numbers) {
			visited[no] = true;
			al.add(no);
		}
		solve(al);
//		for (int i = 0; i < 101; ++i) {
//			if (visited[i]) {
//				++res;
//			}
//		}
		return al.size();
	}
	
	@Test
	public void test() {
		assertTrue( CountNumbers(new int[]{6, 2, 18}) == 7 );
		assertTrue( CountNumbers(new int[]{9, 2}) == 3 );
	}
}
