package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class ListeningSongs {
	public int listen(int[] durations1, int[] durations2, int minutes, int T)
	{
		int time = minutes * 60;
		Arrays.sort(durations1);
		Arrays.sort(durations2);
		int count = 0;
		for (int i = 0; i < durations1.length; ++i) {
			if (count >= T) break;
			if (time >= durations1[i]) {
				time -= durations1[i];
				++count;
			}
		}
		if (count < T) return -1;
		count = 0;
		
		for (int i = 0; i < durations2.length; ++i) {
			if (count >= T) break;
			if (time >= durations2[i]) {
				time -= durations2[i];
				++count;
			}
		}
		if (count < T) return -1;
		
		int res = T * 2;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = count; i < durations1.length; ++i) {
			al.add(durations1[i]);
		}
		for (int i = count; i < durations2.length; ++i) {
			al.add(durations2[i]);
		}
		Collections.sort(al);
		

		for (int i = 0; i < al.size(); ++i) {
			if (al.get(i) > time)
				break;
			time -=al.get(i);
			++res;
		}

		return res < T ? -1 : res;
	}
	
	@Test
	public void test() {
		
		assertTrue( listen(new int[]{120,120,120,120,120}, new int[]{60,60,60,60,60,60}, 10, 3) == 7);
		assertTrue( listen(new int[]{100,200,300}, new int[]{100,200,300}, 2, 1) == -1);
		assertTrue( listen(new int[]{100,200,300,400,500,600}, new int[]{100,200}, 1000, 3) == -1);
		assertTrue( listen(new int[]{300,200,100}, new int[]{400,500,600}, 10, 1) == 2);
		assertTrue( listen(new int[]{60,60,60}, new int[]{60,60,60}, 5, 2) == 5);
		assertTrue( listen(new int[]{300,200,100}, new int[]{400,500,600}, 17, 1) == 4);
	}
}
