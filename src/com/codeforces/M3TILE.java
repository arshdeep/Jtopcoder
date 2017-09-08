package com.topcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class M3TILE {
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
				final int n = 4;
				int numways(Integer memo[][][], int x, int y, int bitmask) {
					if (x > n) return 0;
					if (y < 0) return bitmask == 0 ? 1 : 0;
					if (x == n) return numways(memo, 0, y - 1, bitmask);
					if (memo[x][y][bitmask] != null) {
						return memo[x][y][bitmask];
					}
					int res= 0;
					if ((bitmask & (1 << x)) != 0) {
						res += numways(memo, x + 1, y, bitmask & ~(1 << x));
					}
					else {
						res += numways(memo, x + 1, y, bitmask | (1 << x));
						if ((bitmask & (1 << (x + 1))) == 0) {
							res += numways(memo, x + 2, y, bitmask);
						}
					}
					
					return memo[x][y][bitmask] = res;
				}
				public void solve() {
					MyScanner sc = new MyScanner();
					Integer[][][] memo = new Integer[n][50][1<<n];
					while (true) {
						int t = sc.nextInt();
						if (t != -1) {
							System.out.println(numways(memo, 0, t - 1, 0));
						}
					}
				}
			}
			prob s = new prob();
			s.solve();
		}
}
