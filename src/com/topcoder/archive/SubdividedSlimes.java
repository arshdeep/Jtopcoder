package com.topcoder.archive;

import static org.junit.Assert.*;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=13946*/
public class SubdividedSlimes {
	public int needCut(int S, int M) {
		for (int i = 1; i <= S; ++i) {
			int current = 0;
			int rem = S;
			
			for (int j = 0; j < i; ++j) {
				int take = rem / (i - j + 1);
				rem -= take;
				current += take * rem;
			}
			
			if (current >= M)
				return i;
		}
		return -1;
	}
	
	@Test
	public void test() {
		assertTrue( needCut(3, 2) == 1 );
		assertTrue( needCut(3, 3) == 2 );
		assertTrue( needCut(3, 4) == -1 );
		assertTrue( needCut(870, 377550) == 424 );
		assertTrue( needCut(1000, 499359) == 858 );
		assertTrue( needCut(765, 271828) == 14 );
		assertTrue( needCut(1000, 999) == 1 );
		assertTrue( needCut(1000, 499500) == 999 );
		
	}
}
