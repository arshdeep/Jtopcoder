package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class ChooseTheBestOne {
	public int countNumber(int N) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (N == 1)
			return 1;
		for (int i = 2; i <= N; ++i) {
			al.add(i);
		}
		int turn = 2;
		int delta = 0;
		while (al.size() > 1) {
			double th = Math.pow(turn++, 3);
			
			int rem = (int) (th % al.size());
			int idx = ((rem % al.size()) + delta) % al.size();
			
			if (idx == 0) {
				al.remove(al.get(al.size() - 1));
				delta = 0;
			}
			else {
				al.remove( al.get(idx - 1) );
				delta = idx - 1;
			}
			
		}
		
		return al.get(0);
	}
	
	@Test
	public void test(){
		assertTrue( countNumber(3) == 2 );
		assertTrue( countNumber(6) == 6 );
		assertTrue( countNumber(10) == 8 );
		assertTrue( countNumber(1234) == 341 );
	}
}
