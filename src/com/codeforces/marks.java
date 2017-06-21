package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class marks {
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
				int k = s.nextInt();
				double res = 0;
				for (int i = 0; i < n; ++i) {
					res += s.nextInt();
				}
				int count = 0;
				do {
					if ((int)((res / (n + count)) + 0.5) == k) {
						System.out.println(count);
						return; 
					}
					++count;
					res += k;
				}
				while(true);

			}
		}
		prob s = new prob();
		s.solve();
	}
}
