package com.topcoder;

import static org.junit.Assert.*;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=13814*/
public class Cyclemin {
	public 	String bestmod(String s, int k) {
		String ret = s;
		StringBuilder sub = new StringBuilder(s);
		
		for (int i = 1, size = s.length(); i < size; ++i) {
			sub = new StringBuilder(sub.toString().substring(size - 1) + sub.toString().substring(0, size - 1));
			
			StringBuilder sub2 = new StringBuilder(sub);
			int count = k;
			
			for (int j = 1; j <= sub2.length() && count > 0; ++j) {
				if (sub2.charAt(j - 1) != 'a') {
					sub2.setCharAt(j - 1, 'a');
					--count;
				}
			}
			
			if (sub2.toString().compareTo(ret) < 0) {
				ret = sub2.toString();
			}
		}
		
		return ret;
	}
	
	@Test
	public void test() {
		assertTrue( bestmod("abacaba", 1).equals("aaaabac"));
		assertTrue( bestmod("bbb", 2).equals("aab"));
		assertTrue( bestmod("sgsgaw", 1).equals("aasgsg"));
		assertTrue( bestmod("isgbiao", 2).equals("aaaisgb"));
		assertTrue( bestmod("aaajaqafaaoaxkaj", 4).equals("aaaaaaaaaaaaoaxk"));
		assertTrue( bestmod("ahaaaaarkaaaaaamaaaravahaizgqawasaaa", 29).equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		assertTrue( bestmod("vaanaarsaahjaaaacaakaaapaoafasaaaafaaaaaaaofcaah", 0).equals("aaaaaaaofcaahvaanaarsaahjaaaacaakaaapaoafasaaaaf"));
		assertTrue( bestmod("bzjpvdrsmfeirvconzumjpmtuikrelshsygfbcyyfq", 21).equals("aaaaaaaaaaaaaaaaaaaaabcyyfqbzjpvdrsmfeirvc"));
		assertTrue( bestmod("pyoirqjghmvxfynqmszdbzgrnnjkjowg", 3).equals("aaabzgrnnjkjowgpyoirqjghmvxfynqm"));
		assertTrue( bestmod("pyoirqjghmvxfynqmszdbzgrnnjkjowg", 3).equals("aaabzgrnnjkjowgpyoirqjghmvxfynqm"));
		assertTrue( bestmod("aacaaaaasftbaaactplkmfoagazntaraargubsaaraekhars", 44).equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		assertTrue( bestmod("miqgbambkedajeeyskbtbmetaapizdhejwahalyxnakakqnjap", 5	).equals("aaaaaaaakakqnjapmiqgbambkedajeeyskbtbmetaapizdhejw"));
	}
}
