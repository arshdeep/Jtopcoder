package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Cross {
	public String exist(String[] board)
	{
		int x[] = {1, 0, -1, 0};
		int y[] = {0, 1, 0, -1};
		for (int i = 1; i < board.length - 1; ++i) {
			for (int j = 1; j < board[0].length() - 1; ++j) {
				boolean found = false;
				if (board[i].charAt(j) == '#') {
					found = true;
					for (int ii = 0; ii < 4; ++ii) {
						found = found & board[i + x[ii]].charAt(j + y[ii]) == '#'; 
					}
				}
				if (found) {
					return "Exits";
				}
			}
		}
		return "Does not exist";
	}
	@Test
	public void test() {
		assertTrue(exist(new String[]{
				".#.#",
				 "#.#.",
				 ".#.#",
				 "#.#."
		}).equals("Does not exist"));
	}
}
