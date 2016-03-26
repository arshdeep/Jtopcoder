package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class DNASequence {
	public int longestDNASequence(String sequence)
	{
		HashSet<Character> hs = new HashSet<Character>();
		hs.add('A');
		hs.add('C');
		hs.add('G');
		hs.add('T');
		int res = 0;
		
		for (int i = 0; i < sequence.length(); ++i) {
			for (int j = i + 1; j <= sequence.length(); ++j) {
				String sub = sequence.substring(i, j);
				boolean flag = true;
				
				for (int k = 0; k < sub.length(); ++k) {
					if (!hs.contains(sub.charAt(k))) {
						flag = false;
					}
				}
				
				if (flag) {
					res = Math.max(sub.length(), res);
				}
			}
		}
		
		return res;
	}
	@Test
	public void test(){
		
		assertTrue( longestDNASequence("SUSHI") == 0);
		assertTrue( longestDNASequence("GATTACA") == 7);
	}

}
