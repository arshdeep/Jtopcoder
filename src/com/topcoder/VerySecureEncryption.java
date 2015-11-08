package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VerySecureEncryption {
	public String encrypt(String message, int[] key, int K) {
		StringBuffer sb = new StringBuffer(message);
		
		while(K > 0) {
			String temp = sb.toString();
			for (int i = 0, len = message.length(); i < len; ++i) {
				sb.setCharAt(key[i], temp.charAt(i));
			}
			--K;
		}
		
		return sb.toString();
	}
	@Test
	public void test() {
		assertTrue( encrypt("abc", new int[]{1,2,0}, 1).equals("cab") );
		assertTrue( encrypt("abcde", new int[]{4, 3, 2, 1, 0}, 1).equals("edcba") );
		assertTrue( encrypt("abcde", new int[]{4, 3, 2, 1, 0}, 2).equals("abcde") );
		assertTrue( encrypt("uogcodlk", new int[]{4, 3, 6, 2, 5, 1, 0, 7}, 44).equals("goodluck") );
	}
}
