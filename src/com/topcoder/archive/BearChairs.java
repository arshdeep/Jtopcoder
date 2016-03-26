package com.topcoder.archive;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class BearChairs {
	public int[] findPositions(int[] atLeast, int d)
	{
		int n = atLeast.length;
		int res[] = new int[n];
		ArrayList<Point> al = new ArrayList<Point>();

		for (int i = 0; i < n; ++i) {
			int tt = atLeast[i];
			for (Point pt : al) {
				if (pt.x <= tt && pt.y >= tt) {
					tt = pt.y + 1;
				}
			}
			res[i] = tt;
			al.add(new Point(tt - d + 1, tt + d - 1));
			Collections.sort(al, new Comparator<Point>() {

				@Override
				public int compare(Point arg0, Point arg1) {
					// TODO Auto-generated method stub
					if (arg0.y > arg1.y)
						return 1;
					else if (arg0.x > arg1.x)
						return 1;
					else return -1;
				}
				
			});
		}
		
		return res;
	}
	
	@Test
	public void test(){
		
//		findPositions(new int[]{1,21,11,7}, 11);
//		findPositions(new int[]{1000000,1000000,1000000,1}, 999999);
//		findPositions(new int[]{1000000,1000000,1000000,1}, 1000000);
		findPositions(new int[]{1,21,11,7}, 10);
		//assertTrue( bigDistance(new StringBuffer("xxyyxyxyyyyyyxxxyxyxxxyxyxyyyyyxxxxxxyyyyyyyyxxxxx").reverse().toString()) == 47);

	}

}
