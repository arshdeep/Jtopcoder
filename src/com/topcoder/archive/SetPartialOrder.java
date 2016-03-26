package com.topcoder.archive;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SetPartialOrder {
	public String compareSets(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		
		int len1 = a.length;
		int len2 = b.length;
		int match = 0;
		int i = 0, j = 0;
		
		while (i < len1 && j < len2) {
			if ( a[i] > b[j] ) {
				++j;
			}
			else if ( a[i] < b[j] ) {
				++i;
			}
			else {
				++match;
				++i;
				++j;
			}
		}
		
		if (match == len1 && match == len2) {
			return "EQUAL";
		}
		else if (match == len1) {
			return "LESS";
		}
		else if (match == len2) {
			return "GREATER";
		}
		else return "INCOMPARABLE";
	}
	
	@Test
	public void test() {
		assertTrue( compareSets(new int[]{1, 2, 3, 5, 8}, new int[]{8, 5, 1, 3, 2} ).equals("EQUAL"));
		assertTrue( compareSets(new int[]{1, 2}, new int[]{1, 2} ).equals("EQUAL"));
		assertTrue( compareSets(new int[]{2, 3, 5, 7}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10} ).equals("LESS"));
		assertTrue( compareSets(new int[]{2, 4, 6, 8, 10, 12, 14, 16}, new int[]{2, 4, 8, 16} ).equals("GREATER"));
		assertTrue( compareSets(new int[]{42, 23, 17}, new int[]{15, 23, 31}).equals("INCOMPARABLE"));
		assertTrue( compareSets(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98}, new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98}).equals("EQUAL"));
		assertTrue( compareSets(new int[]{1, 2, 3, 5, 8, 100}, new int[]{8, 5, 1, 3, 2, 100, 99}).equals("LESS"));
		assertTrue( compareSets(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98},
		new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61, 63, 65, 67, 69, 71, 73, 75, 77, 79, 81, 83, 85, 87, 89, 91, 93, 95, 97, 99}).equals("INCOMPARABLE"));
	}
}
