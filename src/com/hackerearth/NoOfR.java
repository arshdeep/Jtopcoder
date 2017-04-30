package com.hackerearth;

import java.util.Scanner;

public class NoOfR {
	public static void main(String args[] ) throws Exception {
		class prob {
			long go(String in) {
				long res = 0;
				int len = 0;
				int j = 0;
				int r = 0;
				int k = 0;
				while (j < in.length()) {
					if (in.charAt(j) == 'R') {
						++r;
						res = Math.max(res, len);
						--len;
						if (len < 0) {
							len = 0;
						}
						
					}
					else {
						++k;
						res = Math.max(res, ++len);
					}

					++j;
				}
				if (k == 0) {
					res = 0;
				}
				return r + res;
			}
			public void solve() {
				Scanner s = new Scanner(System.in);
		        int T = s.nextInt();
		        String  s1 = s.nextLine();
		        for (int i = 0; i < T; i++) {
	        		System.out.println(go(s.nextLine()));
		        }
		        s.close();
			}
		}

        prob s = new prob();
        s.solve();
    }
}
