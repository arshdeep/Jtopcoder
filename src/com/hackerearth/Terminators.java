package com.hackerearth;

import java.util.Scanner;

public class Terminators {
	public static void main(String args[] ) throws Exception {
		class prob {
			long[][] dp;
			long go(int[] in1, int[] in2) {
				for (int i = 1;i <= in1.length; ++i) {
					for (int j = 1; j <= in2.length; ++j) {
						if (in1[i - 1] == in2[j - 1]) {
							dp[i][j] = dp[i - 1][j - 1] + 1;
						}
						else {
							dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
						}
					}
				}
				
				return dp[in1.length][in2.length];
			}
			public void solve() {
				Scanner s = new Scanner(System.in);
		        int T = s.nextInt();
		        s.nextLine();
		        for (int i = 0; i < T; i++) {
		        	int N = s.nextInt();
		        	dp = new long[N + 2][N + 2];
		        	int[] seq1 = new int[N];
		        	int[] seq2 = new int[N];
		        	for (int j = 0; j < N; ++j) {
		        		int num1 = s.nextInt();
		        		int num2 = s.nextInt();
		        		seq1[num1 - 1] = j;
		        		seq2[num2 - 1] = j;
		        	}
	        		System.out.println(go(seq1, seq2));
		        }
		        s.close();
			}
		}

        prob s = new prob();
        s.solve();
    }
}
