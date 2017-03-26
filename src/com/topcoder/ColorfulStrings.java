package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;

public class ColorfulStrings {
	int[] in;
	HashSet<Integer> res;
	int size;
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		
		arr[i] = arr[j];
		arr[j] = temp;
	}
	int toProduct(String s) {
		int res = s.length() > 1 ? 1 : 0;
		for (int i = 0; i < s.length(); ++i) {
			res *= s.charAt(i) - '0';
		}
		
		return res;
	}
	boolean isColorful() {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int len = 1; len <= size; ++len) {
			for (int i = 0, j = len ; j <= size; ++i, ++j) {
				int res = 1;
				
				for (int k = i; k < j; ++k) {
					res *= in[k];
				}
				if (hs.contains(res)) {
					return false;
				}
				hs.add(res);
			}
		}
		
		return true;
	}
	void permute(int i, int n) {
		if (i == n) {
			int result = 0;
			for (int i1 = 0; i1 < size; ++i1) {
				result = result * 10 + in[i1];
			}
			if (!res.contains(result) &&  isColorful()) {
				this.res.add(result);
			}
		}
		else {
			for (int j = i; j <= n; ++j) {
				swap(in, i, j);
				permute(i + 1, n);
				
				swap(in, i, j);
			}
		}
	}

	public String getKth(int n, int k) {
		if (n > 8) {
			return "";
		}
		if (n == 1) {
			if (k <= 10) {
				return (char)((k - 1) + '0') + "";
			}
		}
		in = new int[]{2,3,4,5,6,7,8,9};
		this.size = n;
		res = new HashSet<Integer>();
		permute(0, in.length - 1);
		if (res.size() < k) {
			return "";
		}
		ArrayList<Integer> al = new ArrayList<Integer>(res);
		Collections.sort(al);
		return String.valueOf(al.get(k - 1));
	}
	@Test
	public void test() {
		assertTrue(getKth(1, 5).equals("4"));
		assertTrue(getKth(8, 2).equals("25346978"));
		assertTrue(getKth(5, 1234).equals("38794"));
		assertTrue(getKth(5, 5514).equals("98765"));
		assertTrue(getKth(5, 1).equals("23457"));
		assertTrue(getKth(3, 4).equals("238"));
	}
}
