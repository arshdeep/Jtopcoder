package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Div2MikeStrings {
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


	public static void main(String args[] ) throws Exception {
		class prob {
			int go(StringBuffer[] in) {
				int N = in.length;
				int s = in[0].length() / 2; 
				int[][] dp = new int[N + 1][s + 1];
				
				for (int i = 0; i < N;++i) {
					Arrays.fill(dp[i], Integer.MAX_VALUE);
				}
				for (int i = 0; i < s;++i) {
					dp[0][i] = i;
				}				
				for (int i = 1; i < N; ++i) {
					for (int j = 0; j < s; ++j) {
						String source = in[i].substring(j, j+ s);
						int idx = in[i - 1].indexOf(source);
						if (idx == -1) {
							return -1;
						}
						dp[i][j] = Math.min(dp[i - 1][idx] + j, dp[i][j]);
					}
				}
				int res = Integer.MAX_VALUE;
				
				for (int i = 0; i < s; ++i) {
					res = Math.min(res, dp[N - 1][i]);
				}
				
				return res;
			}
			public void solve() {
				MyScanner s = new MyScanner();
		        int N = s.nextInt();
		        StringBuffer[] in = new StringBuffer[N];
		        for (int i = 0; i < N; ++i) {
		        	in[i] = new StringBuffer(s.next());
		        	in[i] = in[i].append(in[i]);
		        }
		        System.out.println(go(in));
		        
			}
		}
     prob s = new prob();
     s.solve();
	}
}
