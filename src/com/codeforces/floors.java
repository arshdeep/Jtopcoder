package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class floors {
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
			public void solve() {
				MyScanner s = new MyScanner();
				int n = s.nextInt();
				int m = s.nextInt();
				
				String[] in = new String[n];
				int topIdx = -1;
				int lastIdx = -1;
				int[][] dp = new int[n][2];
				for (int i = 0; i < n; ++i) {
					in[i] = s.next();
					if (topIdx == -1 && in[i].contains("1")) {
						topIdx = i;
					}
					
					if (in[i].contains("1")) {
						lastIdx = i;
					}
				}
				if (lastIdx != -1) {
					dp[lastIdx][0] = in[lastIdx].lastIndexOf("1");
					dp[lastIdx][1] = m + 1;
					if (lastIdx != topIdx) {
						dp[lastIdx][0] += dp[lastIdx][0];
					}
				}
				if (topIdx != -1) {
					for (int i = n - 2; i >= topIdx; --i) {
						int idx = in[i].lastIndexOf("1");
						int idx2 = in[i].indexOf("1");
						
						if (idx != -1) {
							dp[i][0] = Math.min(idx * (topIdx == i ? 1 : 2) + dp[i+1][0], m + 1 + dp[i+1][1]);
							dp[i][1] = Math.min((topIdx == i ? 1 : 2) * (m + 1 - idx2) + dp[i+1][1], m + 1 + dp[i+1][0]);
						}
						else {
							dp[i][0] = dp[i + 1][0];
							dp[i][1] = dp[i + 1][1];
						}
					}
					System.out.print(Math.min(dp[topIdx][0], dp[topIdx][1]) + n - topIdx - 1);
					return;
				}
				System.out.print(0);
			}
			
		}
		prob s = new prob();
		s.solve();
	}
}
