package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class market {
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
			class state {
				long k;
				long sum;
				public state(long a, long b) {
					this.k = a;
					this.sum = b;
				}
			}

			state can(int[] in, long k, long m) {
				Long[] temp = new Long[in.length];
				for (int i = 0; i < in.length; ++i) {
					temp[i] = ((long)in[i] + (i+1)*(long)k);
				}
				Arrays.sort(temp);
				state res = new state(0, 0);
				for (int i = 0; i < temp.length; ++i) {
					if (temp[i] > m) {
						break;
					}
					if (m > 0) {
						res.k += 1;
						res.sum += temp[i];
						m -= temp[i];
					}
				}
				return res;
			}
			public void solve() {
				MyScanner s = new MyScanner();
				int n = s.nextInt();
				int m = s.nextInt();
				
				int[] in = new int[n];
				
				for (int i = 0; i < n; ++i) {
					in[i] = s.nextInt();
				}
				
				int lo = 0;
				int hi = n;
				state res = new state(0, 0);
				
				while (lo < hi) {
					int mid = lo + (hi - lo + 1) / 2;
					res = can(in, mid, m);
					if (res.k >= mid) {
						lo = mid;
					}
					else {
						hi = mid - 1;
					}
				}
				if (lo != 0) {
					res = can(in, lo, m);
					System.out.println(res.k + " " + res.sum);
				}
				else {
					System.out.println("0 0");
				}
			}
			
		}
		prob s = new prob();
		s.solve();
	}
}
