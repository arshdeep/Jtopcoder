package com.topcoder.archive;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class DoubleLetter {
	public String ableToSolve(String S) {
		Stack<StringBuffer> dfs = new Stack<StringBuffer>();
		
		dfs.add(new StringBuffer(S));
		
		while (!dfs.isEmpty()) {
			StringBuffer top = dfs.pop();
			boolean found = false;
			
			for (int i = 1; i < top.length(); ++i) {
				if (top.charAt(i - 1) == top.charAt(i)) {
					top.deleteCharAt(i - 1);
					top.deleteCharAt(i - 1);
					found = true;
					if (top.length() > 0) 
						dfs.push(top);
					break;
				}
			}
			if (!found) {
				return "Impossible";
			}
		}
		
		return "Possible";
	}
	
	@Test(timeout=2000)
	//@Test
	public void test() {
		assertTrue( ableToSolve("aabccb").equals("Possible"));
		assertTrue( ableToSolve("aabccbb").equals("Impossible"));
		
	}
}

