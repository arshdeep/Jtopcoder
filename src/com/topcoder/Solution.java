package com.topcoder;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t1 = scan.nextInt();
        for (int i = 0 ; i < t1; ++i) {
        	int n = scan.nextInt();
        	int kk = scan.nextInt();
        	int in[] = new int[n];
        	for (int j = 0; j < n; ++j) {
        		in[j] = scan.nextInt();
        	}
        	int[] dp = new int[kk + 1];
        	
        	for (int sum = 1; sum <= kk; ++sum) {
        		dp[sum] = Integer.MAX_VALUE;
        		for (int k = 0; k < in.length; ++k) {
        			if (sum - in[k] >= 0 && dp[sum - in[k]] != Integer.MAX_VALUE) {
        				dp[sum] = Math.min(dp[sum], dp[sum - in[k]] + 1);
        			}
        		}
        	}
        	
        	int res = 0;
        	for (int rr = kk; rr >= 1; --rr) {
        		if (dp[rr] != Integer.MAX_VALUE) {
        			res = rr;
        			break;
        		}
        	}
            System.out.println(res);
        }
        scan.close();
    }
}
