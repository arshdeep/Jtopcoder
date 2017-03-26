package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

public class MagicalGirlLevelTwoDivTwo {
	public String isReachable(int[] jumpTypes, int x, int y) {
		//(n, 1), (n, -1), (-n, 1), (-n, -1), (1, n), (-1, n), (1, -n) or (-1, -n)
		LinkedList<Point> bfs = new LinkedList<Point>();
		HashSet<Point> hs = new HashSet<Point>();
		bfs.add(new Point(0, 0));
		
		while (!bfs.isEmpty()) {
			Point top = bfs.pollFirst();
			
			if (top.x == x && top.y == y) {
				return "YES";
			}

			if (hs.contains(top)) {
				continue;
			}
			hs.add(top);
			if (top.x < -30 || top.x > 30 || top.y < -30 || top.y > 30) {
				continue;
			}
			
			for (int i = 0; i < jumpTypes.length; ++i) {
				bfs.add(new Point(top.x + jumpTypes[i], top.y + 1));
				bfs.add(new Point(top.x + jumpTypes[i], top.y - 1));
				bfs.add(new Point(top.x - jumpTypes[i], top.y + 1));
				bfs.add(new Point(top.x - jumpTypes[i], top.y - 1));

				bfs.add(new Point(top.x + 1, top.y + jumpTypes[i]));
				bfs.add(new Point(top.x - 1, top.y + jumpTypes[i]));
				bfs.add(new Point(top.x + 1, top.y - jumpTypes[i]));
				bfs.add(new Point(top.x - 1, top.y - jumpTypes[i]));
			}
		}
		return "NO";
	}
	@Test
	public void test() {
		assertTrue(isReachable(new int[]{29}, 29, 0).equals("NO"));
		assertTrue(isReachable(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -30, 27).equals("YES"));
		assertTrue(isReachable(new int[]{2}, 5, 4).equals("YES"));

	}
}
