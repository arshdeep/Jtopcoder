package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class selloff {
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
		class state implements Comparable<state>{
			long items;
			long customers;
			public state(long a, long b) {
				this.items = a;
				this.customers = b;
			}

			@Override
			public int compareTo(state o) {
				// TODO Auto-generated method stub
				long a = Math.min(o.items * 2, o.customers) - Math.min(o.items, o.customers);
				long b = Math.min(this.items * 2, this.customers) - Math.min(this.items, this.customers);
				
				if (a > b) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}
		class prob {

			public void solve() {
				MyScanner s = new MyScanner();
				PriorityQueue<state> pq = new PriorityQueue<state>();
				long n = s.nextLong();
				long k = s.nextLong();
				
				for (int i = 0; i < n; ++i) {
					long items = s.nextLong();
					long customers = s.nextLong();
					state ss = new state(items, customers);
					pq.add(ss);
				}
				long res = 0;
				while(k != 0) {
					state top = pq.poll();
					res += Math.min(top.customers, top.items * 2);
					--k;
				}
				while (!pq.isEmpty()) {
					state top = pq.poll();
					res += Math.min(top.customers, top.items);
				}
				System.out.println(res);
			}
		}
		prob s = new prob();
		s.solve();
	}
}
