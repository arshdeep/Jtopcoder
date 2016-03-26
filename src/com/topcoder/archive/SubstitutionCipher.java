package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SubstitutionCipher {

	public String decode(String a, String b, String y) {
		int[] table = new int[26];
		int[] table2 = new int[26];
		Arrays.fill(table, -1);
		Arrays.fill(table2, -1);
		StringBuffer out = new StringBuffer(a.length());
		
		for (int i = 0, size = a.length(); i < size; ++i) {
			table[b.charAt(i) - 'A'] = a.charAt(i) - 'A';
			table2[a.charAt(i) - 'A'] = b.charAt(i) - 'A';
		}
		int idx1 = -1;
		int idx2 = -1;
		int count = 0;
		for (int i = 0; i < 26; ++i) {
			if (table[i] == -1) {
				idx1 = i;
				++count;
			}
			if (table2[i] == -1) {
				idx2 = i;
			}
		}
		
		if (count == 1)
			table[idx1] = idx2;

		for (int i = 0, size = y.length(); i < size; ++i) {
			int c = table[y.charAt(i)  - 'A'];
			if (c != -1)
				out.insert(i, (char)(c + 'A') );
			else
				return "";
			
		}		
		return out.toString();
	}
	
	@Test
	public void test() {
		assertTrue( decode("CAT", "DOG", "GOD").equals("TAC") );
		assertTrue( decode("ABCDEFGHIJKLMNOPQRSTUVWXY", "ABCDEFGHIJKLMNOPQRSTUVWXY", "ABCDEFGHIJKLMNOPQRSTUVWXYZ").equals("ABCDEFGHIJKLMNOPQRSTUVWXYZ") );
		assertTrue( decode("BANANA", "METETE", "TEMP").equals("") );
		assertTrue( decode("THEQUICKBROWNFOXJUMPSOVERTHELAZYHOG", "UIFRVJDLCSPXOGPYKVNQTPWFSUIFMBAZIPH", "DIDYOUNOTICESKIPPEDLETTER")
				.equals("CHCXNTMNSHBDRJHOODCKDSSDQ"));
		assertTrue( decode("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
				"BCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXY",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX").equals("ZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVW") );
		assertTrue( decode(	"ABCDEFGHIJKLMNOQRSTUVWXYZABCDEFGHIJKLMNOQRSTUVWXYZ", "ABCDEFHIJKLMNOPQRSTUVWXYZABCDEFHIJKLMNOPQRSTUVWXYZ",
				"GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG").equals("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP") );
	}
}
