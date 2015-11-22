package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SortishDiv2 {
	boolean next_permutation(int[] p) {
		for (int a = p.length - 2; a >= 0; --a)
			if (p[a] < p[a + 1])
				for (int b = p.length - 1;; --b)
					if (p[b] > p[a]) {
						int t = p[a];
						p[a] = p[b];
						p[b] = t;
						for (++a, b = p.length - 1; a < b; ++a, --b) {
							t = p[a];
							p[a] = p[b];
							p[b] = t;
						}
						return true;
					}
		return false;
	}
	
	int getSortedness(int[] seq) {
		int sor = 0;
		for (int i = 0; i < seq.length; ++i) {
			for (int j = i + 1; j < seq.length; ++j) {
				if (seq[i] < seq[j])
					++sor;
			}
		}
		
		return sor;
	}

	int[] fill(int[] src, int[] des) {
		int idx = 0;
	
		for (int i = 0; i < src.length; ++i) {
			if (src[i] == 0) {
				src[i] = des[idx++];
			}
		}
		
		return src;
	}
	
	public int ways(int sortedness, int[] seq) {
		int ans = 0;
		boolean[] visited = new boolean[seq.length];
		int size = 0;
		for (int i = 0; i < seq.length; ++i) {
			if (seq[i] != 0) {
				
				visited[seq[i] - 1] = true;
			}
			else ++size;
		}
		int []per = new int[size];
		size = 0;
		for (int i = 0; i < seq.length; ++i) {
			if (visited[i] == false) {
				per[size++] = i + 1;
			}
		}
		
		do {
			int[] res = fill(seq.clone(), per);
			if ( getSortedness(res) == sortedness ) {
				++ans;
			}
		} while(next_permutation(per));
		
		return ans;
	}
	
	@Test
	public void test1()
	{
		assertTrue( ways(5, new int[] {4, 0, 0, 2, 0}) == 2 );
	}
}
