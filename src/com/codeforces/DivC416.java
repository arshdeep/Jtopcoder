
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DivC416 {
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
					long k;
					long sum;
					public state(long a, long b) {
						this.k = a;
						this.sum = b;
					}
				}

				state can(int[] in, long k, long m) {
					Long[] temp = new Long[in.length];
					for (int i = 0; i < in.length; ++i) {
						temp[i] = ((long)in[i] + (i+1)*(long)k);
					}
					Arrays.sort(temp);
					state res = new state(0, 0);
					for (int i = 0; i < k; ++i) {
						if (temp[i] > m) {
							break;
						}
						if (m > 0) {
							res.k += 1;
							res.sum += temp[i];
							m -= temp[i];
						}
					}
					return res;
				}
				public void solve() {
					class state {
						int start;
						int end;
						public state(int a, int b) {
							start = a;
							end = b;
						}
					}
					MyScanner s = new MyScanner();
					int n = s.nextInt();
					
					int[] in = new int[n];
					
					for (int i = 0; i < n; ++i) {
						in[i] = s.nextInt();
					}
					HashMap<Integer, state> hm = new HashMap<Integer, state>();
					for (int i = 0; i < n; ++i) {
						if (hm.containsKey(in[i])) {
							hm.get(in[i]).end = i;
						}
						else {
							hm.put(in[i], new state(i, i));
						}	
					}
					
					int[] dp = new int[n + 1];
					for (int i = 0; i < n; ++i) {
						dp[i + 1] = dp[i];
						state st = hm.get(in[i]);
						if (st.end == i) {
							int result = in[i];
							HashSet<Integer> hs = new HashSet<Integer>();
							hs.add(result);
							int left = st.start;
							int right = st.end;
							for (int j = i; j >= st.start; --j) {
								state target = hm.get(in[j]);
								if (!hs.contains(in[j])) {
									hs.add(in[j]);
									result = result ^ in[j];
									left = Math.min(left, target.start);
									right = Math.max(right, target.end);
								}
							}
							for (int j = st.start - 1; j >= left; --j) {
								if (!hs.contains(in[j])) {
									hs.add(in[j]);
									result = result ^ in[j];
								}
							}
							if (st.end >= right) {
								dp[i + 1] = Math.max(dp[i + 1], result + dp[left]);
							}
						}
					}
					
					System.out.println(dp[n]);
				}
				
			}
			prob s = new prob();
			s.solve();
		}
	}
