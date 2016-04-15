package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LeftOrRight {
	int dist(String sb) {
		int reach = 0;
		int dist = 0;
		
		for (int i = 0; i < sb.length(); ++i) {
			if (sb.charAt(i) == 'L') {
				--dist;
			}
			else {
				++dist;
			}
			reach = Math.max(reach, Math.abs(dist));
		}
		
		return reach;
	}
	public int maxDistance(String program) {
		int reach = 0;

		if (program.contains("?")) {
			for (char ch = 'L'; ch <= 'R'; ch += 'R' - 'L') {
				String sb = new String(program);
				sb = sb.replaceAll("\\?", String.valueOf(ch));
				reach = Math.max(reach, Math.abs(dist(sb)));
			}
		}
		else {
			reach = Math.max(reach, Math.abs(dist(program)));
		}
		return reach;
	}
	@Test
	public void test(){
		assertTrue( maxDistance("L?L?") == 4);
		assertTrue( maxDistance("LL???RRRRRRR???") == 11);
		assertTrue( maxDistance("??????") == 6);
		assertTrue( maxDistance("R???L") == 4);
		assertTrue( maxDistance("LLLRLRRR") == 3);

	}
}
