package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class DistinguishableSetDiv2 {
	public int count(String[] answer)
	{
		int res= 0;
		int n = answer.length;
		int m = answer[0].length();
		
		for (int mask = 0; mask < (1 << m); ++mask) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < m; ++i) {
				if ( (mask & (1 << i)) != 0 ){
					set.add(i);
				}
			}
			
			HashSet<String> hs = new HashSet<String>();
			boolean flag = true;
			for (int i = 0; i < n; ++i) {
				String ss = "";
				for(int idx : set) {
					ss += answer[i].charAt(idx);
				}
				if (hs.contains(ss)) {
					flag = false;
					break;
				}
				hs.add(ss);
			}
			
			if (flag) {
				++res;
			}
			
		}
		
		return res;
	}

	@Test
	public void test() {
		assertTrue(count(new String[]{"AAAA","BACA","CDCE"}) == 11);
		assertTrue(count(new String[]{"HGHHGUHUHI","BQHJWOSZMM","NDKSKCNXND","QOEOEIWIDS","IIQIWUNNZM"}) == 1017);
		assertTrue(count(new String[]{"AA","AB","CC"}) == 2);
	}

}
