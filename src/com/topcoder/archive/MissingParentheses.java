package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class MissingParentheses {
	public int countCorrections(String par)
	{
		int cc = 0;
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < par.length(); ++i) {
			if (par.charAt(i) == '(') {
				stk.push('(');
			}
			else if (par.charAt(i) == ')') {
				if (stk.isEmpty()) {
					++cc;
				}
				else if (stk.peek() == '(') {
					stk.pop();
				}
			}
		}		
		
		return cc + stk.size();
	}
	@Test
	public void test() {
		assertTrue(countCorrections(")(())((((()()())))(()(())((()(()(((())(()(((((()))") == 12);

	}
}
