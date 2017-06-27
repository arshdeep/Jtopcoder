package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ComplicatedBook {
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
				int []in = new int[n];
				for (int i = 0; i < n; ++i) {
					in[i] = s.nextInt();
				}
				
				for (int i = 0; i < m; ++i) {
					int x = s.nextInt();
					int y = s.nextInt();
					int z = s.nextInt();
					
					int val  = in[z - 1];
					int count = 0;
					for (int j = x - 1; j < y; ++j) {
						if (in[j] < val) {
							++count;
						}
					}
					if (val == in[x + count - 1]) {
						System.out.println("YES");
					}
					else {
						System.out.println("NO");
					}
				}
			}
		}
		prob s = new prob();
		s.solve();
	}
}
