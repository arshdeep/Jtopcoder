package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class ContestScoreboard {
	String[] scores;
	Set<Integer> getAllTimes(String[] scores) {
		Set<Integer> hs = new TreeSet<Integer>();

		for (String str : scores) {
			String[] ss = str.split("\\s+");
			
			for (int i = 1; i < ss.length; ++i) {
				int time = Integer.parseInt(ss[i].split("/")[1]);
				
				hs.add(time);
				hs.add(time + 1);
				if (time > 1)
					hs.add(time - 1);
			}
		}
		return hs;
	}
	
	int getWinner(int time) {
		int idx = 0;
		int res = Integer.MIN_VALUE;
		String winner = "";
		for (int i = 0; i < scores.length; ++i) {
			String str = scores[i];
			String[] ss = str.split("\\s+");
			int score = 0;
			for (int j = 1; j < ss.length; ++j) {
				int sub = Integer.parseInt(ss[j].split("/")[1]);
				
				if (sub < time) {
					score += Integer.parseInt(ss[j].split("/")[0]);
				}
			}
			
			if (res < score) {
				res = score;
				idx = i;
				winner = ss[0];
			}
			else if (res == score) {
				if (ss[0].compareTo(winner) < 0) {
					idx = i;
					winner = ss[0];
				}
			}
			
		}

		return idx;
	}
	
	public int[] findWinner(String[] scores) {
		this.scores = scores;
		int[] res = new int[scores.length];
		Set<Integer> alltimes = getAllTimes(scores);
		
		for (int time : alltimes) {
			int index = getWinner(time);
			res[index] = 1; 
		}
		return res;
	}
	
	@Test
	public void test() {
		assertTrue( Arrays.equals(findWinner( new String[]{"UBA 10/2 30/4 25/3 999/1000", "UNC 1/3 3/20 40/50", "UNLP 2/2 3/3 4/4 100/100", "UNR 999/1000000 999/999999", "UNS 999/100000000"}), new int[]{1, 0, 1, 1, 0}) );
		assertTrue( Arrays.equals(findWinner( new String[]{"AAA 248/2 495/5 993/7","BBB 244/6 493/7 990/10", "CCC 248/2 495/5 993/10"}), new int[]{1, 0,0 }) );
		assertTrue( Arrays.equals(findWinner( new String[]{"GLP 1/114 1/195 1/171 1/19 1/146 1/29","BKPF 1/57 1/187 1/277 1/21 1/223 1/35"}), new int[]{1, 1 }) );
		assertTrue( Arrays.equals(findWinner( new String[]{"TVG 1/1 1/2 1/3", "AJI 1/4 1/5 1/6"}), new int[]{1, 1 }) );
	}
}
