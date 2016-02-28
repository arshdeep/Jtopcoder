package com.topcoder.div2;

public class CoinFlipsDiv2 {
	public int countCoins(String state)
	{
		int res = 0;
		
		for (int i = 0; i < state.length(); ++i) {
			if (i > 0 && state.charAt(i - 1) != state.charAt(i)) {
				++res;
			}
			else if (i + 1 < state.length() && state.charAt(i) != state.charAt(i + 1)) {
				++res;
			}
		}
		
		return res;
	}
}
