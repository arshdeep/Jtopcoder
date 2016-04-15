package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AlienAndGame {
	public int getNumber(String[] board) {
		int res = 1;
		int h = board.length;
		int w = board[0].length();
		
		for (int len = Math.min(h, w); len > 1; --len) {
			for (int ii = 0; ii + len <= h; ++ii) {
				for (int jj = 0; jj + len <= w; ++jj) {

				boolean isValid = true;
					for (int j = ii; j < ii + len; ++j) {
						int mask = 0x0;
						for (int k = jj; k < jj + len; ++k) {
							if (board[j].charAt(k) == 'B') {
								mask |= 1;
							}
							else {
								mask |= 2;
							}
						}
						if (mask == 3) {
							isValid = false;
							break;
						}
					}
					if (isValid) {
						res = Math.max(res, len * len);
						break;
					}
				}
			}
		}
		return res;
	}
	
	@Test
	public void test(){
		assertTrue( getNumber(new String[]
				{"BWBBWBB",
				 "WWBWWBW",
				 "BBBBBBW",
				 "WBBBBWB",
				 "BBWWWWB",
				 "WWWWWWW",
				 "BBWWBBB"}) == 9 );
		assertTrue( getNumber(new String[]{"W","B"}) == 1 );	
		assertTrue( getNumber(new String[]{"WBBB",
				 "WBBB",
				 "WWWW"}) == 9 );	
		assertTrue( getNumber(new String[]{"BB",
				 "WW"}) == 4 );
	
	}
}
