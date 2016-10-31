package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class ThreeTeleports {
	public class state {
		Point pt1;
		Point pt2;
		public state(Point p, Point p2) {
			this.pt1 = p;
			this.pt2 = p2;
		}
	}
	state[] in;
	long solve(Point st, Point end, int flag) {
		long temp = Math.abs(st.x - end.x) + Math.abs(st.y - end.y);
		for (int i = 0; i < 6; ++i) {
			if ((flag & (1<<i)) == 0) {
				long res = solve(in[i].pt2, end, flag | (1<<i)) + 10;
				
				long tt = Math.abs(st.x - in[i].pt1.x) + Math.abs(st.y - in[i].pt1.y);
				temp = Math.min(temp, tt + res);
			}
		}
		
		return temp;
	}
	public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports) {
		in = new state[6];
		int i = 0;
		for (String s : teleports) {
			String[] sp = s.split(" ");
			Point st = new Point(Integer.valueOf(sp[0]), Integer.valueOf(sp[1]));
			Point e = new Point(Integer.valueOf(sp[2]), Integer.valueOf(sp[3]));
			
			in[i++] = new state(st, e);
			in[i++] = new state(e, st);
		}
		int res = (int)solve(new Point(xMe, yMe), new Point(xHome, yHome), 0);
		return res;
	}
	@Test
	public void test() {
		assertTrue(shortestDistance(272910313, 968932248, 211109133, 454430785,new String[] {"276284707 433053339 420117411 756213781", "463896611 622885230 316291167 744006274", "882163211 914764017 201629599 992297292"}) == 446478595);
		assertTrue(shortestDistance(0,0,20,20, new String[] {"1000 1003 1000 1004", "18 20 1 1", "1000 1005 1000 1006"}) == 14);
		assertTrue(shortestDistance(10, 10, 10000, 20000,new String[] {"1000 1003 1000 1004", "3 3 10004 20002", "1000 1005 1000 1006"}) == 30);
		assertTrue(shortestDistance(0,0,20,20, new String[]{"1 1 18 20", "1000 1003 1000 1004", "1000 1005 1000 1006"}) == 14);
		assertTrue(shortestDistance(3, 3, 4, 5, new String[]{"1000 1001 1000 1002", "1000 1003 1000 1004", "1000 1005 1000 1006"}) == 3);
	}
}
