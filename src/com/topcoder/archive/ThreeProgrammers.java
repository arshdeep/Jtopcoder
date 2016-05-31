package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ThreeProgrammers {
	String[][][][][] memo;
	int n;
	String solve(String str, int a, int b, int c, int sb, int sc) {
		if (str.length() == n) {
			return str;
		}
		if (memo[a][b][c][sb][sc] != null) {
			return memo[a][b][c][sb][sc];
		}
		
		if (a > 0) {
			boolean skipc = str.length() > 0 ? (str.charAt(str.length() - 1) == 'C') : false;
			String ret = solve(str + 'A', a - 1, b , c, 0, skipc ? 2 : 0);
			
			if (ret != "impossible") {
				return memo[a][b][c][sb][sc] = ret;
			}
		}
		if (b > 0 && sb == 0) {
			boolean skipc = str.length()  > 0 ? (str.charAt(str.length() - 1) == 'C') : false;
			String ret = solve(str + 'B', a, b - 1, c, 1, skipc ? 2 : 0);
			
			if (ret != "impossible") {
				return memo[a][b][c][sb][sc] = ret;
			}
		}	
		if (c > 0 && sc == 0) {
			String ret = solve(str + 'C', a, b, c - 1, 0, 1);
			
			if (ret != "impossible") {
				return memo[a][b][c][sb][sc] = ret;
			}
		}			
		return memo[a][b][c][sb][sc] = "impossible";
	}
	public String validCodeHistory(String code) {
		
		int a = 0;
		int b = 0;
		int c = 0;
		this.n = code.length();
		
		for (int i = 0; i < n; ++i) {
			switch (code.charAt(i)) {
			case 'A':
				++a;
				break;
			case 'B':
				++b;
				break;
			case 'C':
				++c;
				break;

			default:
				break;
			}
		}
		memo = new String[a + 1][b + 1][c + 1][3][3];
		String ret = solve("", a,b,c,0,0);
		return ret;
	}
	
	@Test
	public void test() {
		assertTrue( validCodeHistory("ACABC").equals("ACABC") );
		assertTrue( validCodeHistory("BAABCABBCCACBAACABAABABBCCAACABCCAACCABCACACCBABAB").equals("BACBABCAACBACABCBACBACABCBACBACABCABCAACBACAACABCA") );
		assertTrue( validCodeHistory("CAC").equals("impossible") );
		assertTrue( validCodeHistory("ACAC").equals("CAAC") );
		assertTrue( validCodeHistory("CBB").equals("BCB") );
		assertTrue( validCodeHistory("CAB").equals("BCA") );
	}
}
