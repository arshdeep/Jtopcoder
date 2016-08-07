package com.topcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BearPasswordAny {
	public String findPassword(int[] x) {
		String res = "";
		char ch = 'a';
		int n = x.length;
		int pos = 0;
        for(int i = n-1; i >= 0; --i)
        {
			while(x[i] != 0)
			{

	       		for(int k = 0; k <= i; ++k) 
	       		{
	       		    res += ch;
	       		    ++pos;
	       		    if(pos > n) return "";
	       		}
	       		ch = (ch == 'a')? 'b': 'a';
	
	       		int tmp = 1;
	       		for(int j = i; j >= 0; --j)
	       		{
	       		    x[j] -= tmp;
	       		    if(x[j] < 0) return "";
	       		    tmp++;
	       		}
			}
        }
 
	    if(pos != n) return "";
		return res;
	}
	@Test 
	public void test() {
		assertTrue(findPassword(new int[]{4,0,0,0}).equals("aaaa"));
		assertTrue(findPassword(new int[]{4,2,1,0}).equals("aaab"));
	}

}
