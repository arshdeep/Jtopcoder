package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bank {
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
			boolean cansolve(int[][] map, int[] sarr, int ss) {
				int n = sarr.length;
				int[] str2 = new int[sarr.length];
				for (int i = 0; i < n; ++i) {
					str2[i + 1] = sarr[i + 1];
				}
				int count = 0;
				for (int i = 0; i < sarr.length; ++i) {
					if (sarr[i] > ss) {
						return false;
					}
					str2[i + 1] = sarr[i + 1] + 2;
					if (str2[i + 1] > ss) {
						++count;
					}
				}
				if (n == 1 || count == 0) return true;
				for (int i = 0; i < n; ++i) {
					
				}
				return false;
			}
			public void solve() {
				MyScanner s = new MyScanner();
				int n = s.nextInt();
				
				int max = 0;
				int[] str = new int[n + 1];
				for (int i = 0; i < n; ++i) {
					str[i + 1] = s.nextInt();
					max = Math.max(max, str[i + 1]);
				}
				boolean[][] map = new boolean[n][n];
				for (int i = 0; i < n - 1; ++i) {
					int src = s.nextInt();
					int dst = s.nextInt();
					map[src][dst] = true;
					map[dst][src] = true;
				}

				System.out.println(res);

			}
		}
		prob s = new prob();
		s.solve();
	}
}
