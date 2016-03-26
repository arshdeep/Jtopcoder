package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class LittleElephantAndString {
	public int getNumber(String A, String B) {
		int[] count = new int[26];
		
		for (int i = 0; i < A.length(); ++i) {
			++count[A.charAt(i) - 'A'];
		}
		for (int i = 0; i < B.length(); ++i) {
			--count[B.charAt(i) - 'A'];
		}
		for (int i = 0; i < 26; ++i) {
			if (count[i] != 0)
				return -1;
		}
		
		int tail = A.length() - 1;
		for (int i = A.length() - 1; i >= 0; --i) {
			while (tail >= 0 && A.charAt(i) != B.charAt(tail)) {
				--tail;
			}
			if (tail <= 0) {
				return i;
			}
			--tail;
		}
		
		return 0;
	}
	@Test
	public void test(){
		
		assertTrue( getNumber("ABC", "CBA") == 2);
	}
	
}
