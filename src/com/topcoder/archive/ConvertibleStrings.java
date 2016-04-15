package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConvertibleStrings {
	char[] p;
	int min;
	String A;
	String B;
	void solve(int idx, int e) {
		if (idx == e) {
			int diff = 0;
			for (int i = 0; i < A.length(); ++i) {
				if (p[A.charAt(i) - 'A'] != B.charAt(i)) {
					++diff;
				}
			}
			
			min = Math.min(min, diff);
		}
		else {
			for (int i = idx; i < e; ++i) {
				char t = p[idx];
				p[idx] = p[i];
				p[i] = t;
				
				solve(idx + 1, e);
				
				t = p[i];
				p[i] = p[idx];
				p[idx] = t;
			}
		}
		
	}
	
	public int leastRemovals(String A, String B) {
		this.A = A;
		this.B = B;
		p = new char[9];
		min = A.length();
		
		for (int i = 0; i < 9; ++i) {
			p[i] = (char) ('A' + i);
		}
		
		solve(0, 9);
		
		return min;
	}
	
	@Test
	public void test(){
		assertTrue( leastRemovals("FHA", "III") == 2 );
		assertTrue( leastRemovals("FEDEIGCGHFFAHIEBIHFEED", "DCFAGGBCBAFABAIGGIAFBD") == 13 );
		assertTrue( leastRemovals("GAFCBDHACBGCFAICCICGHEDEHE", "IABCIAHIBIEAAFCDFDAHAACHGF") == 15 );
		assertTrue( leastRemovals("ABACDCECDCDAAABBFBEHBDFDDHHD", "GBGCDCECDCHAAIBBFHEBBDFHHHHE") == 9 );
		assertTrue( leastRemovals("AAIAIA", "BCDBEE") == 3 );
		assertTrue( leastRemovals("AAAA", "ABCD") == 3 );
		assertTrue( leastRemovals("DD", "FF") == 0 );

	}
}
