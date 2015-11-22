package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class NarrowPassage2Easy {
	Set<List<Integer>> visited;
	int [] size;
	int maxSizeSum;
	
	void dfs(ArrayList<Integer> in) {
		if (!visited.contains(in)) {
			visited.add(in);
			
			for (int  i = 0; i < in.size() - 1; ++i) {
				if (size[in.get(i)] + size[in.get(i + 1)] <= maxSizeSum) {
					ArrayList<Integer> clone = (ArrayList<Integer>)in.clone();

					clone.set(i + 1, in.get(i));
					clone.set(i, in.get(i + 1));
					dfs(clone);
				}
			}
		}
	}
	
	public int count(int[] size, int maxSizeSum) {
		this.maxSizeSum = maxSizeSum;
		this.size = size;
		visited = new HashSet<List<Integer>>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int  i = 0; i < size.length; ++i) {
			al.add(i);
		}
		dfs(al);
		return visited.size();
	}
	
	@Test
	public void test1()
	{
		assertTrue( count(new int[]{1, 2, 3}, 3) == 2 );
		assertTrue( count(new int[]{1, 2, 3}, 4) == 3 );
		assertTrue( count(new int[]{1,1,1,1,1,1}, 2) == 720 );
	}
}
