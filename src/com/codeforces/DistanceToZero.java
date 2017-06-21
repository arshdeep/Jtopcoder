package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DistanceToZero {
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
				Long[] in = new Long[n];
				Long[] zeros = new Long[n + 1];
				Arrays.fill(zeros, Long.MAX_VALUE);
				for (int i = 0; i < n; ++i) {
					in[i] = s.nextLong();
					if (in[i] == 0) {
						zeros[i] = 0L;
					}
				}
				for (int i = 1; i < n; ++i) {
					if (zeros[i - 1] != Long.MAX_VALUE) {
						zeros[i] = Math.min(zeros[i - 1] + 1, zeros[i]);
					}
				}
				for (int i = n - 2; i >= 0; --i) {
					if (zeros[i + 1] != Long.MAX_VALUE) {
						zeros[i] = Math.min(zeros[i + 1] + 1, zeros[i]);
					}
				}
				System.out.print(zeros[0]);
				for (int i = 1; i < n; ++i) {
					System.out.print(" " + zeros[i]);
				}
			}
		}
		prob s = new prob();
		s.solve();
	}
}
