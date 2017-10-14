package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimalLabels {
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
				class node {
					int v;
					ArrayList<Integer> adj = new ArrayList<Integer>();
					int incount;
					int label;
					public void add(int x) {
						this.adj.add(x);
					}
				}
				void dfs(node[] in, boolean[] visit, int label, PriorityQueue<Integer> bfs) {
					while (!bfs.isEmpty()) {
						int top = bfs.poll();
						if (visit[top]) {
							continue;
						}
						in[top].label = label--;
						visit[top] = true;
						
						for (int x :in[top].adj) {
							in[x].incount--;
							if (in[x].incount == 0) {
								bfs.add(x);
							}
						}
					}
				}
				public void solve() {
					MyScanner sc = new MyScanner();
					int n = sc.nextInt();
					int m = sc.nextInt();
					
					node[] in = new node[n];
					boolean[] visit = new boolean[n];
					
					for (int i = 0; i < n; ++i) {
						in[i] = new node();
						in[i].v = i;
					}
					for (int i = 0; i < m; ++i) {
						int x = sc.nextInt() - 1;
						int y = sc.nextInt() - 1;
						
						in[y].add(x);
						++in[x].incount;
					}
					int label = n;
					PriorityQueue<Integer> bfs = new PriorityQueue<Integer>(n, Collections.reverseOrder());
					for (int i = 0; i < n; ++i) {
						if (in[i].incount == 0) {
							bfs.add(i);
						}
					}
					dfs(in, visit, label, bfs);
					for (int i = 0; i < n; ++i) {
						System.out.print(in[i].label + " ");
					}
				}
			}
			prob s = new prob();
			s.solve();
		}
}
