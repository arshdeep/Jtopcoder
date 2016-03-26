package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;

public class Istr {
	public int count(String s, int k)
	{
		int[] ch = new int[26];
		
		for (int i = 0; i < s.length(); ++i) {
			ch[s.charAt(i) - 'a'] += 1;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(s.length(), Collections.reverseOrder());
		for (int i = 25; i >= 0; --i) {
			if (ch[i] > 0) {
				pq.add(ch[i]);
			}
		}
		
		while (k > 0) {
			int top = pq.poll();
			
			pq.add(--top);
			--k;
		}
		
		int res= 0;
		
		for (int no : pq) {
			if (no > 0)
				res += no * no;
		}
		return res;
	}
	
	@Test
	public void test(){
		
		assertTrue( count("wersrsresesrsesrawsdsw", 11) == 23);
		assertTrue( count("abacaba", 1) == 14);
		assertTrue( count("abacaba", 3) == 6);
		assertTrue( count("abacaba", 3) == 6);

		assertTrue( count("aba", 1) == 2);
	}

}
