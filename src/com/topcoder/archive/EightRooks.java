package com.topcoder.archive;

public class EightRooks {
	public String isCorrect(String[] board) {
		for (int i = 0; i < board.length; ++i) {
			int rcount = 0;
			int colcount = 0;
			for (int j = 0; j < board[0].length(); ++j) {
				if (board[i].charAt(j) == 'R') {
					++rcount;
				}
				if (board[j].charAt(i) == 'R') {
					++colcount;
				}
			}
			
			if (rcount != 1 || colcount != 1)
				return "Incorrect";
		}
		
		return "Correct";
	}
}
