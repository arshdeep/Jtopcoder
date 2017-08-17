package com.topcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
//http://www.spoj.com/problems/GSS1/
public class SegmentTree {
	public static PrintWriter out;
    
	   //-----------MyScanner class for faster input----------
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
	 
	      String nextLine(){
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
					int sum;
					int pre;
					int suff;
					int ans;
					
				}
				state combine(state left, state right) {
					state st = new state();
					st.sum = left.sum + right.sum;
					st.pre = Math.max(left.pre, left.sum + right.pre);
					st.suff = Math.max(right.suff, right.sum + left.suff);
					st.ans = Math.max(Math.max(left.ans, right.ans), left.suff + right.pre);
					return st;
				}
				void build(int in[], state[] seg, int idx, int i, int j) {
					if (i == j) {
						seg[idx] = new state();
						seg[idx].sum = in[i];
						seg[idx].pre = seg[idx].suff = seg[idx].ans = in[i];
					}
					else {
						build(in, seg, idx * 2, i, (j + i)/2);
						build(in, seg, idx * 2 + 1, (j + i)/2 + 1, j);
						seg[idx] = combine(seg[idx * 2], seg[idx * 2 + 1]);
					}
				}
				state query(state[] seg, int idx, int i, int j, int x, int y) {
					if (x == i && y == j) {
						return seg[idx];
					}
					else {
						int mid = (j + i)/ 2;
						if (y <= mid) {
							return query(seg, idx * 2, i, mid, x, y);
						}
						if (x > mid) {
							return query(seg, idx * 2 + 1, mid + 1, j, x, y);
						}

						return combine(query(seg, idx * 2, i, mid, x, mid),
								query(seg, idx * 2 + 1, mid + 1, j, mid + 1, y));
					}
				}
				public void solve() {
					MyScanner sc = new MyScanner();
					int n = sc.nextInt();
					int[] in = new int[n];
					
					for (int i = 0; i < n; ++i) {
						in[i] = sc.nextInt();
					}
					
					int size = (int) (Math.log(n)/Math.log(2)) + 1;
					state[] seg = new state[2 * (1 << size)];
					
					build(in, seg, 1, 0, n - 1);
					int q = sc.nextInt();
					
					for (int i = 0; i < q; ++i) {
						int n1 = sc.nextInt();
						int n2 = sc.nextInt();
						System.out.println(query(seg, 1, 0, n - 1, n1 - 1, n2 - 1).ans);
					}
				}
			}
			prob s = new prob();
			s.solve();
		}
	}

