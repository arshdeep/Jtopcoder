package com.hackerearth;

import java.util.Scanner;

public class Xsquare {

	public static void main(String args[] ) throws Exception {
		class prob {
			long go(int[] coins, int k) {
				long res = 0;
				long temp  = 0;
				for (int i = 0; i < coins.length; ++i) {
					if (coins[i] <= k) {
						temp += coins[i];
					}
					else {
						res = Math.max(res, temp);
						temp = 0;
					}
				}
				return Math.max(res, temp);
			}
			public void solve() {
				Scanner s = new Scanner(System.in);
		        int T = s.nextInt();

		        for (int i = 0; i < T; i++) {
		        	int n = s.nextInt();
		        	int k = s.nextInt();
		        	int[] coins = new int[n];
		        	
		        	for (int j = 0; j < n; ++j) {
		        		coins[j] = s.nextInt();
		        	}
		        	System.out.println(go(coins, k));
		        }
		        s.close();
			}
		}

        prob s = new prob();
        s.solve();
    }
}
