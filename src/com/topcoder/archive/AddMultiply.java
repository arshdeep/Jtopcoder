package com.topcoder.archive;

public class AddMultiply {
	public int[] makeExpression(int y) {
		//{2, -2, y + 4} works !!!
		
		for (int i = -1000; i < 1001; ++i) if (i != 0 && i != 1) {
			for (int j = -1000; j < 1001; ++j) if (j != 0 && j != 1) {
				for (int k = -1000; k < 1001; ++k) if (k != 0 && k != 1) {
					if ( (1L * i * j) + k == y)
						return new int[] {i, j , k};
				}
				
			}
			
		}
		
		return new int[]{};
	}
}
