package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class ICPCBalloons {
	int accumulate(ArrayList<Integer> al) {
		int acc = 0;
		for (int i : al) {
			acc += i;
		}
		
		return acc;
	}
	int getCost(ArrayList<Integer> colors, ArrayList<Integer> req) {
		int x = accumulate(colors);
		int n = accumulate(req);
		
		if (x < n) {
			return Integer.MAX_VALUE;
		}
		
		Collections.sort(colors, Collections.reverseOrder());
		Collections.sort(req, Collections.reverseOrder());
		
		for (int i = 0; i < colors.size() && i < req.size(); ++i) {
			n -= Math.min(colors.get(i), req.get(i));
		}
		
		return n;
	}
	public int minRepaintings(int[] balloonCount, String balloonSize, int[] maxAccepted) {
		ArrayList<Integer> m = new ArrayList<Integer>();
		ArrayList<Integer> l = new ArrayList<Integer>();
		int best = Integer.MAX_VALUE;
		for (int i = 0; i < balloonSize.length(); ++i) {
			if (balloonSize.charAt(i) == 'L') {
				l.add(balloonCount[i]);
			}
			else {
				m.add(balloonCount[i]);
			}
		}
		
		int n = maxAccepted.length;
		
		for (int mask = 0; mask < (1<<n); ++mask) {
			ArrayList<Integer> set1 = new ArrayList<Integer>();
			ArrayList<Integer> set2 = new ArrayList<Integer>();
			for (int i = 0; i < n; ++i) {
				if ((mask & (1<<i)) != 0 ) {
					set1.add(maxAccepted[i]);
				}
				else {
					set2.add(maxAccepted[i]);
				}
			}
			
			int x = getCost(m, set1);
			int y = getCost(l, set2);
			if (x != Integer.MAX_VALUE && y != Integer.MAX_VALUE) {
				best = Math.min(best, x + y);
			}
		}
		
		return best == Integer.MAX_VALUE ? -1 : best;
	}
	@Test
	public void test() {
		assertTrue(minRepaintings(new int[]{5,6,1,5,6,1,5,6,1}, "MLMMLMMLM", new int[]{7,7,4,4,7,7}) == 6);
	}
	
}
