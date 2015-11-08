package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.LinkedList;

import org.junit.Test;

public class PairGameEasy {
	public String able(int a, int b, int c, int d) {
		LinkedList<Point> bfs = new LinkedList<Point>();
		
		bfs.add(new Point(a, b));
		
		while (!bfs.isEmpty()) {
			Point top = bfs.poll();
			
			if (top.x == c && top.y == d)
				return "Able to generate";
			if (top.x + top.y <= c) {
				bfs.offer(new Point(top.x + top.y, top.y));
			}
			if (top.x + top.y <= d) {
				bfs.offer(new Point(top.x, top.x + top.y));
			}
			
		}
		
		return "Not able to generate";
	}
	
	@Test
	public void test1()
	{
		assertTrue( able(1, 2, 3, 5).equals("Able to generate") );
		assertTrue( able(1, 2, 2, 1).equals("Not able to generate") );
		assertTrue( able(2, 2, 2, 99).equals("Not able to generate") );
		assertTrue( able(2,2,2,1000).equals("Able to generate") );
		assertTrue( able(47, 58, 384, 221).equals("Able to generate") );
		assertTrue( able(1000, 1000, 1000, 1000).equals("Able to generate") );
		assertTrue( able(29, 874, 29, 874).equals("Able to generate") );
		assertTrue( able(79, 67, 362, 583).equals("Not able to generate") );
		assertTrue( able(1, 1000, 1000, 1000).equals("Not able to generate") );
	}
}
