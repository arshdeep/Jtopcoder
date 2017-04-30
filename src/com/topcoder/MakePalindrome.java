package com.topcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class MakePalindrome {
	public String[] constructMinimal(String card) {
		int[] count = new int[26];
		
		for (int i = 0; i < card.length(); ++i) {
			count[card.charAt(i) - 'a']++;
		}
		
		String res = "";
		
		for (int i = 0; i < 26; ++i) {
			if ((count[i] & 1) != 0) {
				count[i]--;
				res = String.valueOf((char)(i + 'a'));
				break;
			}
		}
		
		for (int i = 0; i < 26; ++i) {
			if (count[i] > 1) {
				char[] rep = new char[count[i]/2];
				Arrays.fill(rep, (char)(i + 'a'));
				String t = new String(rep);
				res = t + res + t;
				count[i] = count[i] % 2;
			}
		}
		
		ArrayList<String> result = new ArrayList<String>();
		
		result.add(res);
		for (int i = 0; i < 26; ++i) {
			if (count[i] > 0) {
				result.add(String.valueOf((char)(i + 'a')));
			}
		}
		String[] paramArrayOfT = new String[result.size()];
		return result.toArray(paramArrayOfT);
	}
}
