package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MysteriousRestaurant {
	int getPrice(char a) {
		if (a >= '0' && a <= '9') {
			return a - '0';
		}
		else if (a >= 'A' && a <= 'Z') {
			return a - 'A' + 10;
		}
		else {
			return a - 'a' + 36;
		}
	}
	boolean ok(int d, String[] prices, int budget) {
		int cbudget = 0;
		for (int day = 0; day < 7; ++day) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < prices[0].length(); ++i) {
				int max = 0;

				for (int j = day; j < d; j += 7) {
					max += getPrice(prices[j].charAt(i));
				}
				min = Math.min(min, max);
			}
			cbudget += min;
		}
		return cbudget <= budget;
	}
	public int maxDays(String[] prices, int budget) {
		for (int i = prices.length; i >= 0 ; --i) {
			if (ok(i, prices, budget)) {
				return i;
			}
		}
		return 0;
	}
	@Test
	public void test() {
		assertTrue(maxDays(new String[]{"26", "14", "72", "39", "32", "85", "06"}, 13) == 5);
		assertTrue(maxDays(new String[]{"97", "97", "97", "97", "97", "97", "97", "19", "19", "19", "19", "19", "19", "19"}, 15) == 2);
		assertTrue(maxDays(new String[]{"Dear", "Code", "rsHa", "veFu", "nInT", "heCh", "alle", "ngeP", "hase", "andb", "ecar", "eful"}, 256) == 10);
		assertTrue(maxDays(new String[]{"26", "14", "72", "39", "32", "85", "06", "91"}, 20) == 8);
	}
}
