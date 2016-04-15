package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TreeAndVertex {
	public int get(int[] tree)
	{
		int ans = 1;
		for (int i = 0; i <= tree.length; ++i) {
			int res = i != 0 ? 1 : 0;
			for (int j = 0; j < tree.length; ++j) {
				if (tree[j] == i) {
					++res;
				}
			}
			
			ans = Math.max(res, ans);
		}
		
		return ans;
	}
	@Test
	public void test(){
		assertTrue( get(new int[]{0, 0, 0, 1, 1, 1}) == 4);
		assertTrue( get(new int[]{0,0,0}) == 3);
	}
}
