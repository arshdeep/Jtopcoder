package com.topcoder.archive;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=14060*/
public class Drbalance
{
	
	public int lesscng(String s, int k)
	{
		int ans = 0;
		StringBuilder sb = new StringBuilder(s);
		while (true) {
			int bal = 0;
			int neg = 0;
			
			for (int i = 0, size = sb.length(); i < size; ++i) {
				if (sb.charAt(i) == '+')
					++neg;
				if (sb.charAt(i) == '-')
					--neg;
				if (neg < 0)
					++bal;
			}
			
			if (bal <= k)
				return ans;
			++ans;
			
			for (int i = 0, size = sb.length(); i < size; ++i) {
				if (sb.charAt(i) == '-') {
					sb.setCharAt(i, '+');
					break;
				}
			}
		}
		
	}
	
	@Test
	public void test(){
		assertTrue( lesscng("---", 1) == 1 );
		assertTrue( lesscng("+-+-", 0) == 0 );
		assertTrue( lesscng("-+-+---", 2) == 1 );
		assertTrue( lesscng("-------++", 3) == 3 );
		assertTrue( lesscng("-+--+--+--++++----+", 3) == 2 );
		assertTrue( lesscng("+-----+---------+---+-+-----+-------+--", 6) == 11 );
		assertTrue( lesscng("-++---+-++++------+-+---+++", 8) == 2 );
		assertTrue( lesscng("-+--+--+----++--+++-+++--++-+---+--", 3) == 3 );
		
		
	}
	
}
