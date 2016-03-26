package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class FallingSand {
	public String[] simulate(String[] board) {
		StringBuffer[] sb = new StringBuffer[board.length];
		
		int idx1 = 0;
		for (String str : board) {
			sb[idx1++] = new StringBuffer(str);
		}
		
		/* O(n^3)
		 * for (int i = 0, size = board.length; i < size; ++i) {
			for (int j = 0, strLen = sb[0].length(); j < strLen; ++j) {
				if (sb[i].charAt(j) == 'o') {
					int idx = i + 1;
					int pIdx = i;
					while( idx < size) {
						if (sb[idx].charAt(j) == 'x')
							break;
						else if (sb[idx].charAt(j) == '.') {
							sb[idx].setCharAt(j, 'o');
							sb[pIdx++].setCharAt(j, '.');
						}
						++idx;
					}
					
				}
			}
		}*/
		
		// O(m)		
		for (int j = 0, strLen = sb[0].length(); j < strLen; ++j)
		{
			int lastCol = board.length - 1;
			for (int i = board.length - 1; i >= 0; --i) {
				if (sb[i].charAt(j) == 'x') {
					lastCol = i - 1;
				}
				else if (sb[i].charAt(j) == 'o') {
					sb[i].setCharAt(j, sb[lastCol].charAt(j));
					sb[lastCol--].setCharAt(j, 'o');
				}
			}
			
		}
		
		idx1 = 0;
		for (StringBuffer str : sb) {
			board[idx1++] = new String(str.toString());
		}
		
		return board;
	}
	
	@Test
	public void test1()
	{
		assertTrue( Arrays.equals(simulate(new String[] {"..o..o..o..o..o..o..o..o..o..o..o",
				 "o..o..o..o..o..o..o..o..o..o..o..",
				 ".o..o..o..o..o..o..o..o..o..o..o.",
				 "...xxx...xxx...xxxxxxxxx...xxx...",
				 "...xxx...xxx...xxxxxxxxx...xxx...",
				 "...xxx...xxx......xxx......xxx...",
				 "...xxxxxxxxx......xxx......xxx...",
				 "...xxxxxxxxx......xxx......xxx...",
				 "...xxxxxxxxx......xxx......xxx...",
				 "...xxx...xxx......xxx............",
				 "...xxx...xxx...xxxxxxxxx...xxx...",
				 "...xxx...xxx...xxxxxxxxx...xxx...",
				 "..o..o..o..o..o..o..o..o..o..o..o",
				 "o..o..o..o..o..o..o..o..o..o..o..",
				 ".o..o..o..o..o..o..o..o..o..o..o."}), new String []{".................................",
".................................",
"...ooo...ooo...ooooooooo...ooo...",
"...xxx...xxx...xxxxxxxxx...xxx...",
"...xxx...xxx...xxxxxxxxx...xxx...",
"...xxxoooxxx......xxx......xxx...",
"...xxxxxxxxx......xxx......xxx...",
"...xxxxxxxxx......xxx......xxx...",
"...xxxxxxxxx......xxx......xxx...",
"...xxx...xxx......xxx............",
"...xxx...xxx...xxxxxxxxx...xxx...",
"...xxx...xxx...xxxxxxxxx...xxx...",
".................................",
"ooo.........ooo.........ooo...ooo",
"ooooooooooooooooooooooooooooooooo" }
) );
	}
}
