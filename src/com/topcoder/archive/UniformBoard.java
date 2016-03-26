package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UniformBoard {
	public int getBoard(String[] board, int K) {
		int res = 0;
		boolean isFull = true;
		int apples = 0;
		for (int i = 0, size = board.length; i < size; ++i) {
			for (int k = 0, size2 = board[i].length(); k < size2; ++k ) {
				if (board[i].charAt(k) == '.')
					isFull = false;
				else if (board[i].charAt(k) == 'A')
					++apples;
			}
		}
		
		for (int i = 0, size = board.length; i < size; ++i) {
			for (int j = i; j < size; ++j) {
				for (int k = 0, size2 = board[i].length(); k < size2; ++k ) {
					for(int l = k; l < size2; ++l) {
						if ( (j - i + 1) * (l - k + 1) > apples ) break;
						
						boolean allApples = true;
						int required = 0;
						for (int ii = i; ii <= j; ++ii) {
							for (int jj = k; jj <= l; ++jj) {
								char piece = board[ii].charAt(jj);
								
								switch(piece) {
								case 'P':
									required += 2;
									allApples = false;
									break;
								case '.':
									++required;
									allApples = false;
									break;
								}
								
							}
						}
						
						if (allApples || !isFull && required <= K) {
							res = Math.max((j - i + 1) * (l - k + 1), res);
						}
						
					}
				}
			}
		}
		
		return res;
	}
	
	@Test
	public void test1()
	{
		assertTrue( getBoard(new String[] {"AP", ".A"}, 0) == 1 );
		assertTrue( getBoard(new String[] {"AP", ".A"}, 1) == 2 );
		assertTrue( getBoard(new String[] {"PPP", "APA", "A.P"}, 2) == 3 );
		assertTrue( getBoard(new String[] {"AAA", "PPP", "AAA"}, 10) == 3 );
	}
}
