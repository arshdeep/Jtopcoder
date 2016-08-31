package com.topcoder.archive;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class InternetSecurity {
	HashSet<String> hm;
	String[] address;
	String[] keyword;
	String[] dangerous;
	int threshold;
	boolean[] bad;
	void find() {
		for (int i = 0; i < address.length; ++i) {
			if (!bad[i]) {
				String[] kw = keyword[i].split(" ");
				int count = 0;
				for (String d : kw) {
					if (hm.contains(d)) {
						++count;
					}
				}
				
				if (count >= threshold) {
				
					for (String s : kw) {
						hm.add(s);
					}
					bad[i] = true;
					find();
				}
			}
		}
	}
	public String[] determineWebsite(String[] address, String[] keyword, String[] dangerous, int threshold) {
		this.address = address;
		this.keyword = keyword;
		this.dangerous = dangerous;
		this.threshold = threshold;
		bad = new boolean[address.length];
		
		ArrayList<String> al = new ArrayList<String>();
		
		hm = new HashSet<String>();
		
		for (String str: dangerous) {
			hm.add(str);
		}
		
		find();
		for (int i = 0; i < address.length; ++i) {
			String[] kw = keyword[i].split(" ");
			int count = 0;
			for (String d : kw) {
				if (hm.contains(d)) {
					++count;
				}
				
			}
			
			if (count >= threshold) {
				al.add(address[i]);
			}
		}
		
		String[] ret = new String[al.size()];
		
		for (int i = 0; i < al.size(); ++i) {
			ret[i] = al.get(i);
		}
		
		return ret;
	}
	
	@Test
	public void test() {
		assertTrue(Arrays.equals(determineWebsite(new String[]{"www.topcoder.com",
				"www.sindicate_of_evil.com",
		"www.happy_citizens.com"}, new String[]{"hack encryption decryption internet algorithm",
				"signal interference evil snake poison algorithm",
		"flower baloon topcoder blue sky sea"},
		new String[]{"hack","encryption","decryption","interference","signal","internet"}, 3),
		new String[]{"www.topcoder.com", "www.sindicate_of_evil.com" }));
	}
}
