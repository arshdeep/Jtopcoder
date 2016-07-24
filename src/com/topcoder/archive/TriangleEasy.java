package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class TriangleEasy {
	boolean[] flag;
	HashMap<Integer, ArrayList<Integer>> t;
	
	int go (int idx, int start, int count, int level) {
		if (flag[idx] && count == 3) {
			int cc = 0;
			for (boolean b : flag) {
				if (b) {
					++cc;
				}
			}
			return idx == start ? Math.min(3, cc) : 2;
		}
		if (flag[idx] || level < 0 || count >= 3) {
			return 0;
		}
		flag[idx] = true;

		if (t.containsKey(idx)) {
			ArrayList<Integer> al = t.get(idx);

			for (int in : al) {
				count = Math.max(count, go(in, start, count + 1, level - 1));
			}
			if (level == 2 && al.size() > 1 && count < 2) {
				count = 2;
			}
		}
		flag[idx] = false;
		return count;
	}
	public int find(int n, int[] x, int[] y)
	{
		t = new HashMap<Integer, ArrayList<Integer>>();
		
		for (int i = 0; i < x.length; ++i) {
			ins(x, y, i);
			ins(y, x, i);

		}
		int res = 0;
		
		for (int i : t.keySet()) {
			flag = new boolean[51];
			res = Math.max(res, go(i, i, 0, 2));
		}
		
		return 3 - res;
	}
	private void ins(int[] x, int[] y, int i) {
		if (t.containsKey(x[i])) {
			t.get(x[i]).add(y[i]);
		}
		else {
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			al.add(y[i]);
			t.put(x[i], al);
		}
	}
	@Test
	public void test() {
		assertTrue(find(20, new int[]{16,4,15,6,1,0,10,12,7,15,2,4,8,1,10,15,13,10,1,16,3,19,8,7,13,1,15,15,15,5,16,7,5,6,4,18,3,8,6,2,16,8,19,14,17,16,4,6,9,17,4,10,8,12,2,3,18,9,13,17,4,7,10,0,13,11,15,17,11,15,11,19,19,4,10,14,16,6,3,17,1,4,14,9,7,18,10,11,5,0,5,9,9,7,16,12,4,10,17,3},
				new int[]{17,18,6,16,18,6,11,2,15,10,1,15,17,8,5,9,7,0,0,4,16,1,9,0,9,5,17,14,1,12,14,11,9,18,0,12,11,3,19,14,7,6,3,19,0,1,19,5,11,19,2,13,12,0,6,2,14,16,14,18,5,5,19,3,6,14,12,5,17,3,1,12,7,11,8,8,10,11,13,2,13,13,0,18,2,7,2,12,14,9,3,19,2,8,12,13,8,18,13,18}) == 1);
		assertTrue(find(6, new int[]{0,0,2}, new int[]{3,1,4}) == 1);
		assertTrue(find(4, new int[]{0,2,1,2}, new int[]{3,0,2,3}) == 0);
		assertTrue(find(3, new int[]{}, new int[]{}) == 3);
	}
}
