package com.topcoder;

import java.util.Scanner;

public class FARIDA {
	static long solve(int []buf) {
		if (buf.length == 0) {
			return  0;
		}
		if (buf.length == 2) {
			return Math.max(buf[0], buf[1]);
		}
		long dp[] = new long[buf.length];
		
		dp[0] = buf[0];
		for (int i = 1; i < buf.length; ++i) {
			if (i == 1) {
				dp[i] = buf[i];
			}
			else {
				dp[i] = Math.max(dp[i - 1], buf[i] + dp[i - 2]);
			}
		}
		return dp[buf.length - 1];
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			if (sc.hasNext()) {
				int noofcase = sc.nextInt();
				if (noofcase > 0) {
					int buf[] = new int[noofcase];
					for (int j = 0; j < noofcase; ++j) {
						buf[j] = sc.nextInt();
					}
					System.out.println(String.format("Case %d: ", i +1) + solve(buf));
				}
				else {
					System.out.println(String.format("Case %d: 0", i +1));
				}
			}
		}
		sc.close();
	}
}
