package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Div2House402 {
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
			public void solve() {
				MyScanner s = new MyScanner();
		        int N = s.nextInt();
		        int M = s.nextInt();
		        int K = s.nextInt();
		        boolean[] visit = new boolean[N + 1];
		        for (int i = 0; i < M; i++) {
		        	visit[s.nextInt()] = true;
		        }
		        int last = 1;
		        for (int i = 0; i < K; i++) {
	        		if (visit[last]) {
		        		System.out.println(last);

		        		return;
		        	}
		        	int t = s.nextInt();
		        	int t2 = s.nextInt();
		        	if (t == last) {
		        		last = t2;
		        	}
		        	else if (t2 == last) {
		        		last = t;
		        	}
		        }
	        	System.out.println(last);
		        
			}
		}
        prob s = new prob();
        s.solve();
	}
}
