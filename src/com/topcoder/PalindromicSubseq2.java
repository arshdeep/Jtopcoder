package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromicSubseq2 {
	public int solve(String s) {
		String rs = new StringBuffer(s).reverse().toString() ; 
	    ; 
	    long[][] dp = new long[s.length() + 1][s.length() + 1]; 
	    int mod = (int) (1e9 + 7) , n = s.length() ; 
	    for(int i = 0 ; i <= n ; ++i) dp[i][0] = 1 ; 
	    for(int j = 0 ; j <= n ; ++j) dp[0][j] = 1 ; 
	    for(int i = 1 ; i <= n ; ++i) {
	        for(int j = 1 ; j <= n ; ++j) {
	            dp[i][j] = (dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mod ) % mod ; 
	            if(s.charAt(i - 1) == rs.charAt(j - 1)) {
	                dp[i][j] += dp[i-1][j-1]; 
	                dp[i][j] %= mod ; 
	            }
	        } 
	    }
	    int ans = 0; 
	    long X[] = new long[3005] ; 
	    for(int i = 1 ; i <= n ; ++i) {
	        int j = n - i + 1 ; 
	        X[i] = dp[i-1][j-1] ; 
	        //X[i] = (X[i] * (i)) % mod ; 
	        //ans ^= X[i] ; 
	    }
	    return ans ; 
	}
	@Test
	public void test() {
		assertTrue(solve("axbcba") == 31);
	}
}
