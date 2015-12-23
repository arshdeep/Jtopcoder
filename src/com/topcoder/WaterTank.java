package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WaterTank {
	int []t;
	int []x;
	int C;
	boolean isPossible(double limit) {
		double res = 0.0;
		
		for (int i = 0; i < t.length; ++i) {
			res = Math.max(0.0, res + t[i] * (x[i] - limit));
			
			if (res >= C)
				return false;
		}
		
		return true;
	}
	public double minOutputRate(int[] t, int[] x, int C) {
		this.t = t;
		this.x = x;
		this.C = C;
		
		double lo = 0.0;
		double hi = 10e9;
		
		while (hi - lo > 1e-6) {
			double mid = lo + (hi - lo) / 2.0;

			if (isPossible(mid)) {
				hi = mid;
			}
			else {
				lo = mid;
			}
		}
		return lo;
	}
	
	@Test
	public void test() {
		//assertTrue( 0.9999999999999999 - minOutputRate(new int[]{3,3}, new int[]{1, 2}, 3) <= 1e-7 );
		//assertTrue( minOutputRate(new int[]{1,2,3,4,5}, new int[]{5,4,3,2,1}, 10) - 1.9999999999999996 > 1e-6 );
		//assertTrue( minOutputRate(new int[]{9,3,4,8,1,2,5,7,6}, new int[]{123,456,789,1011,1213,1415,1617,1819,2021}, 11) - 2019.1666666666665 >= 1e-6 );
		assertTrue( minOutputRate(new int[]{294152, 659431, 773807, 984996, 178320, 433743, 190533, 214507, 596274, 783487, 525293, 525524, 188188, 216499, 40428, 189387, 366211, 299892, 520361, 51754, 860151, 343536, 683132, 688463, 32295, 839749, 884813, 132499, 181982, 589029, 140667, 690285, 893552, 407497, 398005, 534456, 720529, 933780, 813081}
		, new int[]{563428, 849126, 205858, 523741, 536602, 385138, 677872, 795730, 480743, 819747, 750918, 641588, 331302, 125843, 212319, 491912, 23823, 696418, 250965, 343599, 494835, 657525, 954974, 958256, 885669, 973114, 115254, 298353, 314581, 97971, 757488, 205893, 985898, 783666, 431505, 505169, 464455, 397279, 49682}
		, 804472) - 985897.0996920157 > 1e-6 );
	}
}
