package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Crossroads {
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
				int [][]in = new int[4][4];
				for (int i = 0; i < 4; ++i) {
					for (int j = 0; j < 4; ++j) {
						in[i][j] = s.nextInt();
					}
				}
				
				for (int i = 0; i < 4; ++i) {
					if ((in[i][0] == 1 || in[i][1] == 1 || in[i][2] == 1) && in[i][3] == 1) {
						System.out.print("YES");
						return;
					}
					int oIndx = (i + 2) % 4; 
					if (in[i][1] == 1 && in[oIndx][3] == 1) {
						System.out.print("YES");
						return;
					}
					if (in[i][0] == 1) {
						// i + 3 % 4 || 3 - i % 4
						int idx = (i + 3) % 4;
						if (idx != i) {
							if (in[idx][3] == 1) {
								System.out.print("YES");
								return;
							}
						}
					}
					if (in[i][2] == 1) {
						int idx = (i + 1) % 4;
						if (idx != i) {
							if (in[idx][3] == 1) {
								System.out.print("YES");
								return;
							}
						}
					}					
				}
				System.out.print("NO");
			}
			
		}
		prob s = new prob();
		s.solve();
	}
}
