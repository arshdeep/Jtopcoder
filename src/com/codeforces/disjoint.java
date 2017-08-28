package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//http://codeforces.com/group/L1Sf9F4uBt/contest/200499/problem/E
//http://codeforces.com/blog/entry/19989
public class disjoint {
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
				int find(int[] in, int x) {
					if (in[x] != x) {
						return in[x] = find(in, in[x]);
					}
					return x;
				}
				void merge(int[] in, int x, int y) {
					in[find(in, x)] = find(in, y);
				}
				public void solve() {
					MyScanner sc = new MyScanner();
					int n = sc.nextInt();
					int m = sc.nextInt();
					
					int[] in  = new int[n + 1];
					int[] box  = new int[n + 1];
					int[] contain  = new int[n + 1];
					for (int i = 1; i <= n; ++i) {
						contain[i] = in[i] = i;
						
					}
					for (int i = 0; i < m; ++i) {
						int x = sc.nextInt();
						int y = sc.nextInt();
						
						if (contain[y] != 0) {
							merge(in, contain[x], contain[y]);
						}
						else {
							contain[y] = contain[x];
						}
						contain[x] = 0;
					}
					for (int i = 1; i <= n; ++i) {
						box[contain[i]] = i;
					}
					for (int i = 1; i <= n; ++i) {
						System.out.print(box[find(in, i)] + " ");
					}
				}
			}
			prob s = new prob();
			s.solve();
		}
}
