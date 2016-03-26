package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.HashSet;

import org.junit.Test;

public class ExplodingRobots {

	public String canExplode(int x1, int y1, int x2, int y2, String instructions)
	{
		int x11 = 0;
		int y11 = 0;
		int x22 = 0;
		int y22 = 0;
		for (int j = 0; j < instructions.length(); ++j) {

			if (instructions.charAt(j) == 'U') {
				y11 += 1;
			}
			else if (instructions.charAt(j) == 'D') {
				y22 += 1;
			}
			else if (instructions.charAt(j) == 'L') {
				x11 += 1;
			}
			else if (instructions.charAt(j) == 'R') {
				x22 += 1;
			}

		}
		
		int deltaX = Math.abs(x2 - x1);
		int deltaY = Math.abs(y2 - y1);

		if (x11 + x22 >= deltaX && y11 + y22 >= deltaY)
			return "Explosion";
		return "Safe";
	}
	@Test
	public void test(){
		assertTrue( canExplode(10, 5, -9, -10, "LULULULLLUULRULULULULULULLULULLULD").equals("Explosion"));
		assertTrue( canExplode(3, 3, 5, 5, "LURLL").equals("Safe"));
		assertTrue( canExplode(1, 0, 2, 0, "U").equals("Safe"));
		assertTrue( canExplode(1, 0, 2, 0, "L").equals("Explosion"));
	}
}
