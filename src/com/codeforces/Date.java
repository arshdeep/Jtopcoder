package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Date {
	public static PrintWriter out;

	// -----------MyScanner class for faster input----------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	public static void main(String args[]) throws Exception {

		class prob {
			final long mod = (long) (1e9+7);
			public void solve() {
				MyScanner s = new MyScanner();
				int n = s.nextInt();
				Long[] in = new Long[n];
				for (int i = 0; i < n; ++i) {
					in[i] = s.nextLong();
				}
				long res = 0;
				Arrays.sort(in);
				long[] dp = new long[n + 1];
				dp[0] = 1;
				for (int i = 1; i <= n; ++i) {
					dp[i] = (dp[i - 1] * 2) % mod;
				}
				
				for (int i = 0; i < n; ++i) {
					long temp = dp[i] - dp[n - 1 - i];
					temp = (in[i] * temp) % mod;
					res = (res + temp) % mod;
				}
				System.out.println(res);
			}
		}
		prob s = new prob();
		s.solve();
	}
}
