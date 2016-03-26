package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BichromeBoard {

	public String ableToDraw(String[] board) {
		for (int k = 0; k < 2; ++k) {
			char color = k == 0 ? 'W' : 'B';
			boolean valid = true;
			for (int i = 0; i < board.length && valid; ++i) {
				for (int j = 0; j < board[0].length() && valid; ++j) {
					if (board[i].charAt(j) != '?') {
						if ((i + j) % 2 == 0 && board[i].charAt(j) != color) {
							valid = false;
						}
						else if ((i + j) % 2 != 0 && board[i].charAt(j) == color) {
							valid = false;
						}
					}
				}
			}
			if (valid) 
				return "Possible";
		}
		
		
		return "Impossible";
	}
	
	@Test
	public void test() {
		assertTrue( ableToDraw(new String[] {"W?W", "??B",
 "???"}).equals("Possible") );
		
		assertTrue( ableToDraw(new String[] {"W??W"}
).equals("Impossible") );
	}
}
