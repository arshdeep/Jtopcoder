package com.hackerearth;

import java.util.Scanner;

public class APPLES {
	public static void main(String args[] ) throws Exception {
		class prob {
			Long[][] dp;
			long go(int[] apples, int[] milk, int en, int idx) {
				if (idx >= apples.length || en < 0) {
					return 0;
				}
				if (dp[en][idx] != null) {
					return dp[en][idx];
				}
				if (en > 0) {
					return dp[en][idx] = Math.max(apples[idx] + go(apples, milk, en - 1, idx + 1), go(apples, milk, Math.min(en + milk[idx] - 1,apples.length), idx + 1));
				}
				else if (milk[idx] != 0) {
					return dp[en][idx] = Math.max(go(apples, milk, Math.min(en + milk[idx] - 1,apples.length), idx + 1), apples[idx]);
				}
				else {
					return dp[en][idx] = (long) apples[idx];
				}
			}
			public void solve() {
				Scanner s = new Scanner(System.in);
		        int T = s.nextInt();
		        s.nextLine();
		        for (int i = 0; i < T; i++) {
		        	int N = s.nextInt();
		        	int e = s.nextInt();
		        	int[] in1 = new int[N];
		        	int[] in2 = new int[N];
		        	int sum = e;
		        	for (int j = 0; j < N; ++j) {
		        		in1[j] = s.nextInt();
		        		sum += in1[j];
		        	}
		        	
		        	for (int j = 0; j < N; ++j) {
		        		in2[j] = s.nextInt();
		        	}
		        	dp = new Long[sum + 1][N + 1];
		        	System.out.println(go(in2, in1, e - 1, 0));
		        }
		        s.close();
			}
		}
        prob s = new prob();
        s.solve();
    }
}
