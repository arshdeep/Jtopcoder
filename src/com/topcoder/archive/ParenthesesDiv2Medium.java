package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ParenthesesDiv2Medium {
	public int[] correct(String s)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		int open = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				++open;
			}
			else {
				if (open == 0) {
					al.add(i);
					++open;
				}
				else {
					--open;
				}
			}
		}
		
		open = 0;
		for (int i = s.length() - 1; i >= 0; --i) {
			if (s.charAt(i) == ')') {
				++open;
			}
			else {
				if (open == 0) {
					al.add(i);
					++open;
				}
				else {
					--open;
				}
			}
		}
		
		int ret[] = new int[al.size()];
		for (int i = 0; i < al.size(); ++i) {
			ret[i] = al.get(i);
		}
		
		return ret;
	}
	
	@Test
	public void test() {
		assertTrue(Arrays.equals(correct("((()"), new int[]{}));
		assertTrue(Arrays.equals(correct(")(((((((()((((((((((((()(((((((((("), new int[]{3, 5, 7, 11, 13, 15, 17, 19, 21, 25, 27, 29, 31, 33, 0, 1}));
	}
}
