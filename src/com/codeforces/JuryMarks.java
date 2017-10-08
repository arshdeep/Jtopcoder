package com.topcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class JuryMarks {
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
				public void solve() {
					MyScanner sc = new MyScanner();
					int k = sc.nextInt();
					int n = sc.nextInt();
					
					int[] in = new int[k];
					int tempSum = 0;
					HashSet<Integer> sum = new HashSet<Integer>();
					for (int i = 0; i < k; ++i) {
						tempSum += in[i] = sc.nextInt();
						sum.add(tempSum);
						
					}
					HashSet<Integer> num = new HashSet<Integer>();
					for (int i = 0; i < n; ++i) {
						num.add(sc.nextInt());
					}
					boolean flag = true;
					HashSet<Integer> hs3 = new HashSet<Integer>();
					for (int j : num) {
						HashSet<Integer> hs = new HashSet<Integer>();
						for (int ii : sum) {
							int temp = j - ii;
							hs.add(temp);
						}
						if (flag) {
							flag = false;
							hs3 = hs;
						}
						else {
							hs3.retainAll(hs);
						}
 					}
					
					
					System.out.println(hs3.size());
				}
			}
			prob s = new prob();
			s.solve();
		}

}
