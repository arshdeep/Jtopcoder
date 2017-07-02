package com.topcoder;

public class Permutiple {
	static public boolean next_permutation(int[] p) {
		for (int a = p.length - 2; a >= 0; --a) {
			if (p[a] < p[a + 1]) {
				for (int b = p.length - 1;; --b) {
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
				}
			}
		}
		return false;
	}
	public String isPossible(int x)
	{
		String in = String.valueOf(x);
		int buf[] = new int[in.length()];
		for (int i = 0; i < in.length(); ++i) {
			buf[i] = i;
		}
		
		while (next_permutation(buf)) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < in.length(); ++i) {
				sb.append(in.charAt(buf[i]));
			}
			int val = Integer.valueOf(sb.toString(), 10);
			
			if (val > x && val % x == 0) {
				return "Possible";
			}
		}
		return "Impossible";
	}
}
