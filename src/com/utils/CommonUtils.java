package com.utils;

import org.junit.Test;

public class CommonUtils {
	public static int countPrimes(int n) {
		boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes++;
        }
        return primes;
	}

	static public boolean next_permutation(int[] p) {
		for (int a = p.length - 2; a >= 0; --a) {
			if (p[a] < p[a + 1]) {
				for (int b = p.length - 1;; --b) {
					if (p[b] > p[a]) {
						int t = p[a];
						p[a] = p[b];
						p[b] = t;
						for (++a, b = p.length - 1; a < b; ++a, --b) {
							t = p[a];
							p[a] = p[b];
							p[b] = t;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	static public void combinations(int n , int r) {
		for (int mask = 1; mask < (1<<n); ++mask) {
			if (Integer.bitCount(mask) != r) continue;
			System.out.print("(");
			for (int j = 0; j < n; ++j) {
				if ((mask & (1<<j)) != 0) {
					System.out.print(j);
					System.out.print(" ");
				}
			}
			System.out.println(")");
		}
	}
	static public void parans(char[] arr, int n , int open, int close, int idx) {
		if (idx == n) {
			for (char c : arr) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		if (open < n / 2) {
			arr[idx] = '(';
			parans(arr, n, open + 1, close, idx + 1);
		}
		if (close < open) {
			arr[idx] = ')';
			parans(arr, n, open, close + 1, idx + 1);
		}
	}	
	
	static public int gcd (int a, int b) {
		while (b != 0) {
			int z = b;
			b = a % b;
			a = z;
		}
		return a;
	}
	@Test
	public void test(){
		CommonUtils.parans(new char[50], 50, 0, 0 , 0);
		//CommonUtils.combinations(6, 3);
	}
}
