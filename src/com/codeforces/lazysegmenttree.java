package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lazysegmenttree {
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
			int[] in;
			int[] out;
			int time = 0;
			void dfs(ArrayList<Integer> tree[], int[] eular, int idx) {
				in[idx] = ++time;
				eular[time] = idx;
				for (int v : tree[idx]) {
					dfs(tree, eular, v);
				}

				out[idx] = time;
			}
			
			void push_down(int[] seg, int[] lazy, int l, int r, int idx) {
				if (lazy[idx] != 0) {
					int mid = (r + l) >> 1;
					lazy[idx << 1] ^= 1;
					lazy[idx << 1 | 1] ^= 1;
					seg[idx << 1] = (mid - l + 1) - seg[idx << 1];
					seg[idx << 1 | 1] = (r - mid) - seg[idx << 1 | 1];
					lazy[idx] = 0;
				}
			}
			
			void update(int[] seg, int[] lazy, int l, int r, int ql, int qr, int idx) {
				if (ql <= l && r <= qr) {
					lazy[idx] ^= 1;
					seg[idx] = (r - l + 1) - seg[idx];
				}
				else {
					push_down(seg, lazy, l, r, idx);
					int mid = (l + r) >> 1;
					if (mid >= ql) {
						update(seg, lazy, l, mid, ql, qr, idx << 1);
					}
					if (qr > mid) {
						update(seg, lazy, mid + 1, r, ql, qr, idx << 1 | 1);
					}
					seg[idx] = seg[idx << 1] + seg[idx << 1 | 1];
				}
			}
			
			int query(int[] seg, int[] lazy, int l, int r, int ql, int qr, int idx) {
				if (ql <= l && r <= qr) {
					return seg[idx];
				}
				else {
					push_down(seg, lazy, l, r, idx);
					int mid = (l + r) >> 1;
					int ans = 0;
					if (mid >= ql) {
						ans += query(seg, lazy, l, mid, ql, qr, idx << 1);
					}
					if (qr > mid) {
						ans += query(seg, lazy, mid + 1, r, ql, qr, idx << 1 | 1);
					}
					return ans;
				}
			}
			
			void build(int[] seg, int[] eular, int[] lights, int l, int r, int idx) {
				if (l == r) {
					seg[idx] = lights[eular[l]];
				}
				else {
					int mid = (r + l) >> 1;
					build(seg, eular, lights, l, mid, idx << 1);
					build(seg, eular, lights, mid + 1, r, idx << 1 | 1);
					seg[idx] = seg[idx << 1] + seg[idx << 1 | 1];
				}
			}
			public void solve() {
				MyScanner sc = new MyScanner();
				int n = sc.nextInt() + 1;
				ArrayList<Integer> tree[] = new ArrayList[n];
				time = 0;
				int[] eular = new int[n];
				int[] light = new int[n];
				int[] lazy = new int[n << 2];
				in = new int[n << 1];
				out = new int[n << 1];
				int[] seg = new int[n << 2];
				for (int i = 0; i < n; ++i) {
					tree[i] = new ArrayList<Integer>();
					
				}
				for (int i = 2; i < n; ++i) {
					int p = sc.nextInt();
					tree[p].add(i);
				}
				for (int i = 1; i < n; ++i) {
					light[i] = sc.nextInt();
				}
				dfs(tree, eular, 1);
				build(seg, eular, light, 1, n - 1, 1);
				
				int q = sc.nextInt();
				
				while (q-- > 0) {
					String query = sc.next();
					int x = sc.nextInt();
					if (query.trim().equals("pow")) {
						update(seg, lazy, 1, n - 1, in[x], out[x], 1);
					}
					else {
						int res = query(seg, lazy, 1, n - 1, in[x], out[x], 1);
						System.out.println(res);
					}
				}
			}
		}
		
		prob s = new prob();
		s.solve();
	}
}
