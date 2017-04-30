package com.hackerearth;

import java.util.Scanner;

public class ig {
	public static void main(String args[] ) throws Exception {
		class prob {
			long[] dp;
			void go(String str) {
				int n = str.length();
				dp = new long[n];
				dp[n - 1] = Integer.valueOf(str.charAt(n - 1)) % 2 == 0 ? 1 : 0;
				for (int i = str.length() - 2; i >= 0; --i) {
					dp[i] = dp[i + 1] + (Integer.valueOf(str.charAt(i)) % 2 == 0 ? 1 : 0);
				}
				System.out.print(dp[0]);
				for (int j = 1; j < dp.length; ++j) {
					System.out.print(" " + dp[j]);
				}
			}
			public void solve() {
				Scanner s = new Scanner(System.in);
		        String str = s.nextLine();
		        go(str);
		        s.close();
			}
		}

        prob s = new prob();
        s.solve();
    }
}
