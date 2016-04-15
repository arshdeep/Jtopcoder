package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class Quacking {
	char next(char ch) {
		if (ch == 'q') {
			return 'u';
		}
		else if (ch == 'u') {
			return 'a';
		}
		else if (ch == 'a') {
			return 'c';
		}
		else if (ch == 'c') {
			return 'k';
		}
		
		return 'q';
	}
	public int quack(String s)
	{
		ArrayList<StringBuffer> al = new ArrayList<StringBuffer>();
		
		for (int i = 0; i < s.length(); ++i) {
			char cc = s.charAt(i);
			
			if ("quack".indexOf(cc) < 0) {
				return -1;
			}
			
			boolean flag = true;
			for (StringBuffer sb : al) {
				if (next(sb.charAt(sb.length() - 1)) == cc) {
					sb.insert(sb.length(), cc);
					flag = false;
					break;
				}
			}
			if (flag && cc == 'q') {
				al.add(new StringBuffer(String.valueOf(cc)));
			}
			else if (flag && cc != 'q') {
				return -1;
			}
			
			Collections.sort(al, new Comparator<StringBuffer>() {

				@Override
				public int compare(StringBuffer arg0, StringBuffer arg1) {
					// TODO Auto-generated method stub
					return arg1.length() - arg0.length();
				}
				
			});
		}
		for (StringBuffer sb : al) {
			int len = sb.length() / 5;
			String t = "quack";
			
			while (len > 1) {
				t += "quack";
				--len;
			}
			if (!sb.toString().equals(t)) {
				return -1;
			}
		}		
		return al.size();
	}
	@Test
	public void test(){
		assertTrue(quack("kcauq") ==  -1);
		assertTrue(quack("quqacukqauackck") ==  2);
		assertTrue(quack("quackquackquackquackquackquackquackquackquackquack") ==  1);
		assertTrue(quack("quackqauckquack") ==  -1);
		assertTrue(quack("quqaquuacakcqckkuaquckqauckack") ==  3);

	}	
}
