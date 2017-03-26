package com.topcoder.archive;

public class SquareMaking {
	public int getMinimalPrice(int a, int b, int c, int d)
	{
		int res = Integer.MAX_VALUE;
		int in[] = {a,b,c,d};
		for (int i = 0; i < 4; ++i) {
			int coin = in[i];
			int temp = 0;
			for (int j = 0; j < 4; ++j) if (i != j) {
				temp += Math.abs(coin - in[j]);
				
			}
			res = Math.min(temp, res);
		}
		
		return res;
	}
}
