package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Highscore {
	public int getRank(int[] scores, int newscore, int places) {
		int same = 0;
		int greater = 0;
		
		for (int i = 0; i < scores.length; ++i) {
			if (newscore < scores[i]) {
				++greater;
			}
			else if (scores[i] == newscore) {
				++same;
			}
		}
		
		if (greater + same >= places) {
			return -1;
		}
		
		return greater + 1;
	}
	@Test
	public void test() {
		assertTrue( getRank(new int[] {1994545937, 1938943236, 1902605580, 1707491184, 1377509761, 1347571835, 1217847778, 1140345403, 1103320943, 856465388}, 496673726, 42 ) == 11);
		assertTrue( getRank(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0}, 0, 10 ) == 1);
		assertTrue( getRank(new int[] {2000000000, 19539, 19466, 19146, 17441, 17002, 16348, 16343,
				15981, 15346, 14748, 14594, 13752, 13684, 13336, 13290, 12939,
				12208, 12163, 12133, 11621, 11119, 10872, 10710, 10390, 9934,
				9296, 8844, 8662, 8653, 8168, 7914, 7529, 7354, 6016, 5428,
				5302, 5158, 4853, 4538, 4328, 3443, 3222, 2107, 2107, 1337,
				951, 586, 424, 31},1337,50 ) == 46);
		assertTrue( getRank(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 3, 0},1,10 ) == 10);
		assertTrue( getRank(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1},1,10 ) == -1);
		assertTrue( getRank(new int[]{},0,50 ) == 1);
		assertTrue( getRank(new int[]{100,90,80},90,10 ) == 2);
	}
}
