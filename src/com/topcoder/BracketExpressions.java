package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class BracketExpressions {
	boolean isValid(String expression) {
		LinkedList<Character> stk = new LinkedList<Character>(); 
		for( int i = 0; i < expression.length(); ++i) {
			char ch = expression.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stk.add(ch);
			}
			else if (ch == ')') {
				if (stk.isEmpty())
					return false;
				char top = stk.pollLast();
				if (top != 'X' && top != '(')
					return false;
			}
			else if (ch == ']') {
				if (stk.isEmpty())
					return false;
				char top = stk.pollLast();
				if (top != 'X' && top != '[')
					return false;
			}
			else if (ch == '}') {
				if (stk.isEmpty())
					return false;
				char top = stk.pollLast();
				if (top != '{')
					return false;
			}			
		}
		return stk.isEmpty();
	}
	//backtrack
	boolean isPossibleEx(String exp) {
		if (!exp.contains("X")) {
			return isValid(exp);
		}
		else {
			if (isPossibleEx(exp.replaceFirst("X", "("))) {
				return true;
			}
			if (isPossibleEx(exp.replaceFirst("X", ")"))) {
				return true;
			}
			if (isPossibleEx(exp.replaceFirst("X", "{"))) {
				return true;
			}
			if (isPossibleEx(exp.replaceFirst("X", "}"))) {
				return true;
			}
			if (isPossibleEx(exp.replaceFirst("X", "["))) {
				return true;
			}
			if (isPossibleEx(exp.replaceFirst("X", "]"))) {
				return true;
			}
		}
		
		return false;
	}
	boolean isPossibleEx2(String exp) {
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		for( int i = 0; i < exp.length(); ++i) {
			if (exp.charAt(i) == 'X') {
				al.add(i);
			}
		}
		
		int dp[] = new int[6];
		dp[0] = 1;
		for (int i = 1; i < 6; ++i) {
			dp[i] = dp[i - 1] * 6;
		}
		
		String brackets = "(){}[]";
		
		for (int m = 0, size = dp[al.size()]; m < size; ++m) {
			StringBuffer temp = new StringBuffer(exp);
			
			for(int i = 0; i < al.size(); ++i) {
				temp.setCharAt(al.get(i), brackets.charAt( (m / dp[i]) % 6));
				
			}
			if (isValid(temp.toString()))
				return true;
		}
		return false;
	}
	public String ifPossible(String expression) {
		return isPossibleEx2(expression) ? "possible" : "impossible";
	}
	@Test
	public void test(){

		assertTrue( ifPossible("[[{}{X[]][X][{()(){}[]}[(X[{}{}X()()][{}X{[]}()]()").equals("possible"));
		assertTrue( ifPossible("()}{[]").equals("impossible"));
		assertTrue( ifPossible("()X").equals("impossible"));
		assertTrue( ifPossible("([]X()[()]XX}[])X{{}}]").equals("possible"));
	}
}
