package com.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Amir {
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
		        int front = 1;
		        int back = s.nextInt();
		        int n = back + 1;
		        boolean flag = true;
		        long res = 0;
		        while (Math.abs(back - front) > 1) {
		        	res += (front + back) % n;
		        	if (flag) {
		        		int temp = back;
		        		back = front + 1;
		        		front = temp;
		        	}
		        	else {
		        		int temp = back;
		        		back = front - 1;
		        		front = temp;
		        	}
		        	flag = !flag;
		        }
		        res += (front + back) % n;
	        	System.out.println(res);
		        
			}
		}
     prob s = new prob();
     s.solve();
	}
}
