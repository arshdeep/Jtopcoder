package com.hackerearth;

import java.util.Scanner;

public class sm {
	public static void main(String args[] ) throws Exception {
		class prob {
			Boolean[][] dp;
			boolean go(int[] in, int sum, int idx) {
				if (idx < 0) {
					return false;
				}
				if (dp[sum][idx] != null) {
					return dp[sum][idx];
				}
				if (sum == 0) {
					return true;
				}
				
				if (in[idx] > sum) {
					return dp[sum][idx] = go(in, sum, idx - 1);
				}
				return dp[sum][idx] = go(in, sum, idx - 1) || go(in, sum - in[idx], idx - 1);
			}
			public void solve() {
				Scanner s = new Scanner(System.in);
		        int T = s.nextInt();
		        s.nextLine();
		        for (int i = 0; i < T; i++) {
		        	int N = s.nextInt();
		        	
		        	int[] in = new int[N];
		        	int sum = 0;
		        	for (int j = 0; j < N; ++j) {
		        		in[j] = s.nextInt();
		        		sum += in[j];
		        	}
		        	if ((sum & 1) == 1) {
		        		System.out.println("NO");
		        	}
		        	else {
			        	dp = new Boolean[sum/2 + 1][in.length + 1];
		        		System.out.println(go(in, sum/2, in.length - 1) ? "YES" : "NO");
		        	}
		        }
		        s.close();
			}
		}
        prob s = new prob();
        s.solve();
    }
}
