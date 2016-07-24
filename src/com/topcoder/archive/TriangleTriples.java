package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

public class TriangleTriples {
	public class Triple<F, S, T> {

	    public final F first;
	    public final S second;
	    public final T third;

	    public Triple(F first, S second, T third) {
	        this.first = first;
	        this.second = second;
	        this.third = third;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (!(o instanceof Triple)) {
	            return false;
	        }
	        Triple<?, ?, ?> p = (Triple<?, ?, ?>) o;
	        return first.equals(p.first) && second.equals(p.second) && third.equals(p.third);
	    }

	    private boolean equals(Object x, Object y) {
	        return (x == null && y == null) || (x != null && x.equals(y));
	    }

	    @Override
	    public int hashCode() {
	        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode()) ^ (third == null ? 0 : third.hashCode());
	    }

	    public <F, S, T> Triple <F, S, T> create(F f, S s, T t) {
	        return new Triple<F, S, T>(f, s, t);
	    }
	}
	int mod = (int)1e9 + 7;
	HashSet<Triple<Integer,Integer,Integer>> hs;
	boolean valid(int A, int B, int C) {
		if (A < B + C && B < A + C && C < A + B)
			return true;

		return false;
	}
	
	public int count(int A, int B, int C) {
		long res = 0;
		hs = new HashSet<Triple<Integer,Integer,Integer>>();

		LinkedList<Triple<Integer,Integer,Integer>> bfs = new LinkedList<Triple<Integer,Integer,Integer>>();
		bfs.add(new Triple<Integer,Integer,Integer>(A,B,C));
		while (!bfs.isEmpty()) {
			Triple<Integer,Integer,Integer> top = bfs.pollFirst();
			if (hs.contains(new Triple<Integer,Integer,Integer>(top.first, top.second, top.third)) || top.first == 0 || top.second == 0 || top.third == 0) {
				continue;
			}
			hs.add(new Triple<Integer,Integer,Integer>(top.first, top.second, top.third));
			if (valid(top.first, top.second, top.third)) {
				res = (res + 1) % mod;
			}
			bfs.add(new Triple<Integer,Integer,Integer>(top.first - 1, top.second, top.third));
			bfs.add(new Triple<Integer,Integer,Integer>(top.first, top.second - 1, top.third));
			bfs.add(new Triple<Integer,Integer,Integer>(top.first, top.second, top.third - 1));
		}
		return (int)res;
	}
	
	@Test
	public void test() {
		assertTrue(count(2,2,1000000000) == 6 );
		assertTrue(count(10,10,10) == 505 );
		assertTrue(count(1,10,20) == 10 );
	}
}
