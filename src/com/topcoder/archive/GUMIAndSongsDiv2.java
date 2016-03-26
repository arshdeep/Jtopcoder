package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class GUMIAndSongsDiv2 {
	public int maxSongsDiv2(int[] duration, int[] tone, int T) {
		int n = duration.length;
		
		int res = 0;
		
		for (int mask = 1; mask < (1<<n); ++mask) {
			int time = 0;
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < n; ++j) {
				
				if ((mask & (1<<j)) != 0) {
					time += duration[j];
					min = Math.min(min, tone[j]);
					max = Math.max(max, tone[j]);
				}
			}

			if (time + max - min <= T) {
				res = Math.max(Integer.bitCount(mask), res);
			}
		}
		
		return res;
	}
	
	//div 1
	public int maxSongs(int[] duration, int[] tone, int T) {
		int n = duration.length;
		int res = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int delta = 0;
				
				delta = T - Math.abs(tone[i] - tone[j]);
				
				ArrayList<Integer> al = new ArrayList<Integer>();
				if (delta > 0) {
					int count = 0;
					
					for (int k = 0; k < n; ++k) {
						if (tone[i] <= tone[k] && tone[j] >= tone[k])
							al.add(duration[k]);
					}
					Collections.sort(al);
					
					for (int d : al) {
						if (delta - d >= 0) {
							delta -= d;
							++count;
						}
						else break;
					}
					
					res = Math.max(res, count);
				}
			}
		}
		return res;
	}

	@Test
	public void test() {
		assertTrue( maxSongs(new int[]{8, 11, 7, 15, 9, 16, 7, 9}, new int[]{3, 8, 5, 4, 2, 7, 4, 1}, 14) == 1 );
		assertTrue( maxSongs(new int[]{3, 5, 4, 11}, new int[]{2, 1, 3, 1}, 17) == 3 );
		assertTrue( maxSongs(new int[]{184, 719, 2, 642, 508}, new int[]{5, 4, 3, 4, 3}, 696) == 3 );
		assertTrue( maxSongs(new int[]{81303, 59661, 78826, 43408, 39012, 54304, 58373, 53291, 86129, 86024}, new int[]{688, 42, 398, 783, 421, 475, 116, 777, 531, 558}, 468919) == 8 );
		assertTrue( maxSongs(new int[]{5611,39996,20200,56574,81643,90131,33486,99568,48112,97168,5600,49145,73590,3979,94614},
				new int[]{2916,53353,64924,86481,44803,61254,99393,5993,40781,2174,67458,74263,69710,40044,80853}, 302606) == 8 );
	}
}
