package com.topcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QTREE2 {
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
				class edge {
					int v;
					int d;
					public edge(int a, int b) {
						v = a;
						d = b;
					}
				}
				void dfs(ArrayList<ArrayList<edge>> al, int[] level, long[] weight, int[] parent, int idx, int l, long w) {
					level[idx] = l;
					weight[idx] = w;
					ArrayList<edge> cv = al.get(idx);
					for (edge eg : cv) {
						if (eg.v == parent[idx]) continue;
						
						parent[eg.v] = idx;
						dfs(al, level, weight, parent, eg.v, l + 1, w + eg.d);
					}
				}
				void build_lca(int[][] lca, int[] parent) {
					for (int i = 0; i < lca.length; ++i) {
						lca[i][0] = parent[i];
					}
					
					for (int j = 1; j < lca[0].length; ++j) {
						for (int i = 0; i < lca.length; ++i) {
							if (lca[i][j - 1] != -1) {
								lca[i][j] = lca[lca[i][j - 1]][j - 1];
							}
						}
					}
				}
				int query_lca(int[][] lca, int[] level, int x, int y) {
					if (level[x] > level[y]) {
						int temp = x;
						x = y;
						y = temp;
					}
					for (int j = lca[0].length - 1; j >= 0; --j) {
						if (lca[y][j] != -1 && level[lca[y][j]] >= level[x]) {
							y = lca[y][j];
						}
					}
					if (x == y) {
						return x;
					}
					for (int j = lca[0].length - 1; j >= 0; --j) {
						if (lca[x][j] != - 1 && lca[y][j] != -1 && lca[x][j] != lca[y][j]) {
							x = lca[x][j];
							y = lca[y][j];
						}
					}
					
					return lca[x][0];
				}
				public void solve() {
					MyScanner sc = new MyScanner();
					int t = sc.nextInt();
					
					while (t-- > 0) {
						int n = sc.nextInt();
						ArrayList<ArrayList<edge>> al = new ArrayList<ArrayList<edge>>(n);
						for(int i = 0; i < n; ++i) {
							al.add(new ArrayList<edge>());
						}
						for(int i = 0; i < n - 1; ++i) {
							int e1 = sc.nextInt();
							int e2 = sc.nextInt();
							int w = sc.nextInt();
							--e1;
							--e2;
							al.get(e1).add(new edge(e2, w));
							al.get(e2).add(new edge(e1, w));
						}
						int[] level = new int[n];
						long[] weight = new long[n];
						int[] parent = new int[n];
						
						Arrays.fill(parent, -1);
						parent[0] = 0;
						dfs(al, level, weight, parent, 0, 0 , 0);
						int ln = (int) (Math.log(n)/Math.log(2)) + 1;
						int[][] lca = new int[n][ln];
						//build
						build_lca(lca, parent);
						
						while (true) {
							String ins = sc.next();
							
							if (ins.equals("DIST")) {
								int x = sc.nextInt();
								int y = sc.nextInt();
								--x;
								--y;
								int clca = query_lca(lca, level, x, y);
								
								long res = weight[x] + weight[y] - 2 * weight[clca];
								System.out.println(res);
							}
							else if (ins.equals("KTH")) {
								
							}
							else break;
						}
					}
				}
			}
			prob s = new prob();
			s.solve();
		}
}
