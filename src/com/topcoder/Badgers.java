package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class Badgers {
	boolean can(int mid, ArrayList<state> al, int totalFood) {
		int hg = 0;
		for (int i = 0; i < mid; ++i) {
			hg += al.get(i).hunger + (mid - 1) * al.get(i).greed;
		}
		
		return hg <= totalFood;
	}
	class state {
		public int hunger;
		public int greed;
		public state(int a, int b) {
			hunger = a;
			greed = b;
		}
	}
	public int feedMost(int[] hunger, int[] greed, int totalFood) {
		ArrayList<state> al = new ArrayList<state>();
		
		for (int i = 0; i < hunger.length; ++i) {
			al.add(new state(hunger[i], greed[i]));
		}
		
		Collections.sort(al, new Comparator<state>() {

			@Override
			public int compare(state arg0, state arg1) {
				// TODO Auto-generated method stub
				if (arg0.greed != arg1.greed) {
					return arg0.greed - arg1.greed;
				}
				else {
					return arg0.hunger - arg1.hunger;
				}
				
			}
			
		});
		int lo = 0;
		int hi = hunger.length;
		
		while (lo < hi) {
			int mid = lo + (hi - lo + 1) / 2;
			
			if (can(mid, al, totalFood)) {
				lo = mid;
			}
			else {
				hi = mid - 1;
			}
		}
		
		return lo;
	}
	@Test
	public void test() {
		assertTrue(feedMost(new int[]{5,2,1,5}, new int[]{0,2,4,1}, 19) == 3);
		assertTrue(feedMost(new int[]{5,2,1,5}, new int[]{0,2,4,1}, 19) == 3);
		assertTrue(feedMost(new int[]{1,2,3}, new int[]{2,2,1}, 7) == 2);
	}
}
