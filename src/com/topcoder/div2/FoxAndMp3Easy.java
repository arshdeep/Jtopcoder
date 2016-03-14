package com.topcoder.div2;

import java.util.ArrayList;
import java.util.Collections;

public class FoxAndMp3Easy {
	public String[] playList(int n) {
		ArrayList<String> al = new ArrayList<String>();
		
		for (int i = 1; i <= n; ++i) {
			al.add(String.valueOf(i));
		}
		Collections.sort(al);
		int size = Math.min(50, al.size());
		
		String[] ret = new String[size];
		
		for (int i = 0; i < size; ++i) {
			ret[i] = al.get(i) + ".mp3";
		}
		return ret;
	}
}
