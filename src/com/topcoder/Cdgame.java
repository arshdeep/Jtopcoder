package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

/* http://community.topcoder.com/stat?c=problem_statement&pm=14062 */
public class Cdgame
{
	public int rescountEx(int[] a, int[] b)
	{
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < b.length; ++j) {
				int s1 = a[i];
				int s2 = 0;

				s2 = b[j];
				
				for (int k = 0; k < a.length; ++k) {
					if (k != j) {
						s1 += b[k];
					}
					if (k != i)
						s2 += a[k];
				}
				int p = s1*s2;
				
				if (!hs.contains(p))
					hs.add(p);
				
			}
		}
		return hs.size();
	}
	
	public int rescount(int[] a, int[] b)
	{
		HashSet<Integer> hs = new HashSet<Integer>();
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < a.length; ++i) {
			sum1 += a[i];
			sum2 += b[i];
		}		
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < b.length; ++j) {
				int p = (sum1 - a[i] + b[j]) * (sum2 - b[j] + a[i]);
				
				if (!hs.contains(p))
					hs.add(p);
				
			}
		}
		return hs.size();
	}
	@Test
	public void test(){
		assertTrue( rescount(new int[]{1,2},new int[]{3,4}) == 2 );
		assertTrue( rescount(new int[]{1, 1, 1},new int[]{1, 1, 1}) == 1 );
		assertTrue( rescount(new int[]{1, 2, 3},new int[]{5, 5, 5}) == 3 );
		assertTrue( rescount(new int[]{3, 3, 4, 1},new int[]{2, 2, 2, 100}) == 4 );
		assertTrue( rescount(new int[]{31, 34, 55, 56, 57},new int[]{1, 2, 3, 4, 5}) == 15 );
	}
}
//Powered by [KawigiEdit] 2.0!