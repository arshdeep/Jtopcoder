package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.LinkedList;

import org.junit.Test;

public class XorTravelingSalesman {
	
	public int maxProfit(int[] cityValues, String[] roads) {
		boolean visited[][] = new boolean[60][2000];
		int maxProfit = 0;

		LinkedList<Point> bfs = new LinkedList<Point>();
		
		bfs.add(new Point(0, cityValues[0]));
		
		while (!bfs.isEmpty()) {
			Point top = bfs.pollFirst();
			
			maxProfit = Math.max(maxProfit, top.y);
			for (int i = 0; i < roads[0].length(); ++i) {
				if (roads[top.x].charAt(i) == 'Y') {
					if (!visited[i][top.y ^ cityValues[i]]) {
						visited[i][top.y ^ cityValues[i]] = true;
						bfs.add( new Point(i, top.y ^ cityValues[i]) );
					}
				}
			}
		}
		return maxProfit;
	}
	@Test
	public void test() {
		assertTrue(maxProfit(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 359, 966, 105, 115, 81, 255, 74, 236, 809, 205, 186, 939, 498, 763, 483, 326, 124, 706, 84, 1016, 795, 488, 487, 909, 886, 346, 302, 611, 563, 927, 201, 922, 870, 306, 13, 951, 561, 88, 163, 346}, new String[]	{"NYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNY", "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYN"}) == 1023 );
		assertTrue(maxProfit(new int[]{0, 7, 11, 5, 2}, new String[]{"NYNYY",
				 "YNYNN",
				 "NYNNN",
				 "YNNNN",
				 "YNNNN"}) == 14 );
		assertTrue(maxProfit(new int[]{0, 4, 8, 32, 512}, new String[]{"NYYYY",
				 "YNNNN",
				 "YNNNN",
				 "YNNNN",
				 "YNNNN"}) == 556 );	
		assertTrue(maxProfit(new int[]{37, 1, 19, 64, 42, 41, 64, 64, 54, 16, 256, 36, 64, 2, 4, 2, 62, 29, 58, 64, 1, 32, 16,
				 256, 17, 2, 17, 4, 1, 64, 21, 8, 256, 63, 3, 1, 43, 15, 8, 39, 41, 8, 16, 8, 16, 256, 64, 512, 45, 64}, new String[]{"NNNNNNYYYYNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNNNNN",
						 "NNNNNNNNNNNNNNNNYNNNNNNNYNNNNNNNNNNNNNNNNYYNNNYYNN",
						 "NNNNNYYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
						 "NNNNNNNYNNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
						 "NNNNNNNNNNNNNNNYNNYNYNNNNNNYNNNNNNNNNNYNNNNNNNNNNN",
						 "NNYNNNYNNNNNNNNYNNYNNNYYNNNYNYNNNNYNNNNNNNNYNNNNNN",
						 "YNYNNYNYNNNNNNNYNNNNNNNNNNNNNNNNNNNYNNNNNNNNYNNYNN",
						 "YNNYNNYNYNYYNNNNNNNNNNNNNNNNNNNNNNYNNYNNNNNNNNNNNN",
						 "YNNNNNNYNNNNNNNNNNNNNNYNYNNNNNNNNNNYYYNNNNNNNYNNNY",
						 "YNNNNNNNNNNNNNNNNYNYNYNYYNNNYNNNNYNNNNNNNNNNNNNNNY",
						 "NNNNNNNYNNNNYNNNNNNNNYYNNNYYNNNNYNYYNNNNNNNNNNNNNN",
						 "NNNNNNNYNNNNNNYNNNNYYNNNYNNYYNNNNNNNNNNNNNYNYNNNNN",
						 "NNNNNNNNNNYNNNNNYNNNNYNNNNNNNNNNYNYNNYNYNNNYNYNNNN",
						 "NNNNNNNNNNNNNNNYNNNNNNNNNYNNNNNNNNNNNNYNNNNNNNNYNN",
						 "NNNNNNNNNNNYNNNNNYNYNNYYNNNNNYNNNNNNNNNYNNYNNYNNNN",
						 "NNNNYYYNNNNNNYNNNYYNNYNNNYNYYNNNNNNNNNYYYNNYNNYNYN",
						 "NYNNNNNNNNNNYNNNNNNNYNNNYYNNNYNNNNYNNNNNNNNNNNNNNN",
						 "NNNNNNNNNYNNNNYYNNNNNNYNNNYNNNNNYNNYNYYNNNNYNNNYNN",
						 "NNNYYYNNNNNNNNNYNNNNNYNYNYNNNNNNNNYNNNNNNNNNNNNNNN",
						 "NNNNNNNNNYNYNNYNNNNNNYNYYYNNNNNNNNNNNYNNYNNNNNYNNN",
						 "NNNNYNNNNNNYNNNNYNNNNYNNNYYNNNYNNNYNNNNNNNNNNYNYNY",
						 "NNNNNNNNNYYNYNNYNNYYYNYNNNNNNNNYNYNNNNNNNNNNYNNNNN",
						 "NNNNNYNNYNYNNNYNNYNNNYNNNNNNNNNNNYNNYNYNNYNNNNNNNN",
						 "NNNNNYNNNYNNNNYNNNYYNNNNNNNNNNNNNNNNNNNNNNYNNNYNNN",
						 "NYNNNNNNYYNYNNNNYNNYNNNNNNNNNNYNNNNNNYNNNYNNYNNNNN",
						 "NNNNNNNNNNNNNYNYYNYYYNNNNNNYNNNNNNNNNNNYYNNNNNNNYN",
						 "NNNNNNNNNNYNNNNNNYNNYNNNNNNNNYNNNNYNNNNNNYYNNNNYNN",
						 "NNNNYYNNNNYYNNNYNNNNNNNNNYNNNYYNYNNNNNNNNNNNNNNNNN",
						 "NNNNNNNNNYNYNNNYNNNNNNNNNNNNNYNNNNYNNNNNNNNYNNYNYN",
						 "NNNNNYNNNNNNNNYNYNNNNNNNNNYYYNNNNNNNNYNNNNYNNNNNNN",
						 "NNNNNNNNNNNNNNNNNNNNYNNNYNNYNNNNNYNNNNNNNNNNNNNNNY",
						 "NNNNNNNNNNNNNNNNNNNNNYNNNNNNNNNNYNNNNNNNNNYNNNNNNN",
						 "NNNNNNNNNNYNYNNNNYNNNNNNNNNYNNNYNNNYYNNNNNYNNNYNNN",
						 "NNNNNNNNNYNNNNNNNNNNNYYNNNNNNNYNNNNNNNYNNYNNNNNNNN",
						 "NNNNNYNYNNYNYNNNYNYNYNNNNNYNYNNNNNNYYNYNYNYNNNNNYN",
						 "YNNNNNYNYNYNNNNNNYNNNNNNNNNNNNNNYNYNNNNNYNNYNNNYNN",
						 "NNNNNNNNYNNNNNNNNNNNNNYNNNNNNNNNYNYNNNNNNYNNNNNNYN",
						 "NNNNNNNYYNNNYNNNNYNYNNNNYNNNNYNNNNNNNNNNNYNNNNYNNN",
						 "NNNNYNNNNNNNNYNYNYNNNNYNNNNNNNNNNYYNNNNYNNNNNNNNNY",
						 "NNNNNNNNNNNNYNYYNNNNNNNNNYNNNNNNNNNNNNYNNNNNYNYYNN",
						 "NNNNNNNNNNNNNNNYNNNYNNNNNYNNNNNNNNYYNNNNNNNNNNNNNN",
						 "NYNNNNNNNNNNNNNNNNNNNNYNYNYNNNNNNYNNYYNNNNNNNNNNNN",
						 "NYNNNNNNNNNYNNYNNNNNNNNYNNYNNYNYYNYNNNNNNNNNYNNNNN",
						 "NNNNNYNNNNNNYNNYNYNNNNNNNNNNYNNNNNNYNNNNNNNNNNNNNY",
						 "NNNNNNYNNNNYNNNNNNNNNYNNYNNNNNNNNNNNNNNYNNYNNYNNNY",
						 "NNNNNNNNYNNNYNYNNNNNYNNNNNNNNNNNNNNNNNNNNNNNYNNNNN",
						 "NYNNNNNNNNNNNNNYNNNYNNNYNNNNYNNNYNNNNYNYNNNNNNNNNN",
						 "NYNNNNYNNNNNNYNNNYNNYNNNNNYNNNNNNNNYNNNYNNNNNNNNNN",
						 "NNNNNNNNNNNNNNNYNNNNNNNNNYNNYNNNNNYNYNNNNNNNNNNNNN",
						 "NNNNNNNNYYNNNNNNNNNNYNNNNNNNNNYNNNNNNNYNNNNYYNNNNN"}) == 895 );		
	}		
}