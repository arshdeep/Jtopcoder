package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class CatchTheBeatEasy {
	class PointSort implements Comparator<Point> {

		@Override
		public int compare(Point arg0, Point arg1) {
			return arg0.y - arg1.y;
		}
		
	}
	public String ableToCatchAll(int[] x, int[] y) {
		Point[] al = new Point[x.length];
		
		for (int i= 0, len = x.length; i < len; ++i) {
			al[i] = (new Point(x[i], y[i]));
		}
		
		Arrays.sort(al, new PointSort());
		int ptX = 0, ptY = 0;
		for (Point pt : al) {
			int dx = Math.abs(pt.x - ptX);
			int dy = Math.abs(pt.y - ptY);
			
			if (dx > dy) {
				return "Not able to catch";
			}
			
			ptX = pt.x;
			ptY = pt.y;
		}
		
		return "Able to catch";
	}
	
	@Test
	public void test1()
	{
		assertTrue( ableToCatchAll(new int[] {-1, 1, 0}, new int[] {1, 3, 4}).equals("Able to catch") );
		assertTrue( ableToCatchAll(new int[] {-3}, new int[] {2}).equals("Not able to catch") );
		assertTrue( ableToCatchAll(new int[] {-1, 1, 0}, new int[] {1, 2, 4}).equals("Not able to catch") );
		assertTrue( ableToCatchAll(new int[] {0, -1, 1}, new int[] {9, 1, 3}).equals("Able to catch") );
		assertTrue( ableToCatchAll(new int[] {70,-108,52,-70,84,-29,66,-33}, new int[] {141,299,402,280,28,363,427,232}).equals("Not able to catch") );
		assertTrue( ableToCatchAll(new int[] {0, -1, 1}, new int[] {9, 1, 3}).equals("Able to catch") );
	}
}
