package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sparsetable {
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
				void GenSparseTable(int[][] mx, int[][] mn, int[] in) {
					int n = in.length;
					int sq = (int) (Math.log(n)/Math.log(2));
					
					for (int j = 1; j <= sq; ++j) {
						for (int i = 0; i + (1 << j) - 1 < n; i++) {
				              if (mx[i][j - 1] > mx[i + (1 << (j - 1))][j - 1])
				                  mx[i][j] = mx[i][j - 1];
				              else
				                  mx[i][j] = mx[i + (1 << (j - 1))][j - 1];
				              if (mn[i][j - 1] < mn[i + (1 << (j - 1))][j - 1])
				                  mn[i][j] = mn[i][j - 1];
				              else
				                  mn[i][j] = mn[i + (1 << (j - 1))][j - 1];
						}
					}
				}
				int query(int[][] mx, int[][] mn, int l , int r) {
					// 2^x >= (r - l) + 1
					int k = (int) (Math.log(r - l + 1)/ Math.log(2));
					return Math.max(mx[l][k], mx[r - (1 << k) + 1][k]) - Math.min(mn[l][k], mn[r - (1 << k) + 1][k]);
				}
				public void solve() {
					MyScanner sc = new MyScanner();
					int n = sc.nextInt();
					int s = sc.nextInt();
					int l = sc.nextInt();
					int sq = (int) (Math.log(n)/Math.log(2));
					int[] in = new int[n];
					int[][] mx = new int[n][sq + 1];
					int[][] mn = new int[n][sq + 1];
					
					for (int i = 0; i < n; ++i) {
						in[i] = sc.nextInt();
						mx[i][0] = in[i];
						mn[i][0] = in[i];
					}
					GenSparseTable(mx, mn, in);
					int out[] = new int[n + 1];
					
					Arrays.fill(out, Integer.MAX_VALUE);
					out[0] = 0;
					int count = 0;

					for (int i = l; i <= n; ++i) {
						while (i - count >= l && (query(mx, mn, count, i - 1) > s || out[count] == Integer.MAX_VALUE)) {
							++count;
						}
						if (i - count >= l) {
							out[i] = Math.min(out[i], out[count] + 1);
						}
					}
					
					System.out.println(out[n] == Integer.MAX_VALUE ? -1 : out[n]);
				}
			}
			prob s = new prob();
			s.solve();
		}
	}
