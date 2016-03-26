package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=14059*/
public class Bracket107 {
	boolean correct(String s) {
	    int bal = 0;
	    for (char c : s.toCharArray()) {
	      if (c == '(') {
	        bal++;
	      } else {
	        bal--;
	      }
	      if (bal < 0) {
	        return false;
	      }
	    }
	    return bal == 0;
	  }
	  public int yetanother(String s) {
	    Set<String> result = new HashSet<String>();
	    
	    for (int i = 0; i < s.length(); i++) {
	      String x = s.substring(0, i) + s.substring(i + 1);
	      char c = s.charAt(i);
	      for (int j = 0; j <= x.length(); j++) {
	        String t = x.substring(0, j) + c + x.substring(j);
	        //System.out.println(t);
	        if (correct(t) && !t.equals(s)) {
	          result.add(t);
	        }
	      }
	    }
	    return result.size();
	  }	
	@Test
	public void test(){
		assertTrue( yetanother("(())()") == 3 );
		//assertTrue( yetanother("(())") == 1 );
	}

}
