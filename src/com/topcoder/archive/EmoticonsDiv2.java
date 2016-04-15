package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.LinkedList;

import org.junit.Test;

public class EmoticonsDiv2 {
	class state implements Comparator<state>{
		int time;
		int cb;
		int sm;
		
		public state(int a, int b, int c) {
			sm = a;
			cb = b;
			time = c;
		}

		@Override
		public int compare(state paramT1, state paramT2) {
			// TODO Auto-generated method stub
			return paramT1.time - paramT2.time;
		}
	}
	public int printSmiles(int smiles) {
		LinkedList<state> bfs = new LinkedList<state>();
		
		bfs.add(new state(1,0,0));
		boolean visited[][] = new boolean[smiles + 1][smiles + 1];
		while (!bfs.isEmpty()) {
			state top = bfs.pollFirst();
			if (visited[top.sm][top.cb])
				continue;
			if (top.sm == smiles) {
				return top.time;
			}
			visited[top.sm][top.cb] = true;
			if (top.sm + top.cb <= smiles)
				bfs.add(new state(top.sm + top.cb, top.cb, top.time + 1));
			bfs.add(new state(top.sm, top.sm, top.time + 1));

		}
		
		return 0;
	}
	
	@Test
	public void test(){
		assertTrue( printSmiles(971) == 971);
		assertTrue( printSmiles(49) == 14);
		assertTrue( printSmiles(400) == 18);
		assertTrue( printSmiles(955) == 196);
		assertTrue( printSmiles(11) == 11);
		assertTrue( printSmiles(16) == 8);
		assertTrue( printSmiles(1000) == 21);

		assertTrue( printSmiles(6) == 5);

		assertTrue( printSmiles(2) == 2);

	}
}
