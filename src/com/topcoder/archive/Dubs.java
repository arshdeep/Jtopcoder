package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Dubs {
	boolean isDub(long L) {
		long l = (L % 10);
		L = L /10;
		return l == (L %10);
	}
	long getDub(long L) {
		long l = (L % 10);
		L = L /10;
		return (L %10) * 10 + l;
	}
	public long countEx(long L, long R)
	{
		long res = 0;

		while (L <= R && L % 100 != 0) {
			if (isDub(L))
				++res;
			++L;
		}
		if (isDub(L) && L <= R) {
			++res;
		}
		if (L < R) {
			int d[] = {11,22,33,44,55,66,77,88,99,100};
			
			long r = R % 100;
			R -= r;
			long c2 = (R - L) / 100;
			
			res = res + c2 * 10;
			
			for (int i = 0; i < 10; ++i) {
				if (d[i] >= r) {
					res = res + i + ((d[i] > r) ? 0 : 1);
					break;
				}
			}
		}

		return res;
	}
	
	//Efficient
	long getCount(long a) {
		long count = 0;
		
		for (int i = 0; i < 10; ++i) {
			count += ( (a - 11* i + 100) / 100);
		}
		
		return count - 1;
	}
	
	public long count(long L, long R)
	{
		return getCount(R) - getCount(L - 1);
	}
	@Test
	public void test() {
		assertTrue(count(1111111, 111111111) == 11000001 );
		assertTrue(count(50,100) == 6 );
		assertTrue(count(99998, 99999) == 1 );
		assertTrue(count(38545321940L, 106671028225L) == 6812570629L);
		assertTrue(count(10, 1000000000) == 100000000);
		assertTrue(count(49, 101) == 6 );
		
		assertTrue(count(10, 22) == 2 );
		assertTrue(count(91750002841L, 91751522033L) == 151920);
		assertTrue(count(10, 20) == 1 );
		assertTrue(count(10, 10) == 0 );
	}	
	

}
