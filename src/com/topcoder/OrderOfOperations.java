package com.topcoder;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/*http://community.topcoder.com/stat?c=problem_statement&pm=13987*/

public class OrderOfOperations {
	int [] mInstructions;
	int [] mResult;
	public int minTime(String[] s)
	{
		mInstructions = new int[s.length];
		
		for (int idx = 0, size = s.length; idx < size; ++idx) {
			String str = s[idx];
			
			int op = 0;
			for (int ch = 0, len = str.length(); ch < len; ++ch) {
				if (str.charAt(ch) == '1')
					op |= (1 << ch);
			}
			mInstructions[idx] = op;
		}
		mResult = new int[1 << s[0].length()];
		Arrays.fill(mResult, -1);

		return go(0);
	}
	int go(int current) {
		if (mResult[current] != -1) {
			return mResult[current];
		}
		int res = Integer.MAX_VALUE;
		
		for (int i : mInstructions) {
			if ((i | current) == current) {
				continue;
			}
			int bc = Integer.bitCount(i & (~current));
			
			res = Math.min(res, bc * bc + go(i | current));
		}
		
		return mResult[current] = res == Integer.MAX_VALUE ? 0 : res;
	}
	@Test
	public void test1()
	{
		String[] test = {
				 "111",
				 "001",
				 "010"
				};
		
		assertTrue( minTime(test) == 3 );
	}
	
	@Test
	public void test2()
	{
		String[] test = {
				 "11101",
				 "00111",
				 "10101",
				 "00000",
				 "11000"
				};
		
		assertTrue( minTime(test) == 9 );
	}

	@Test
	public void test3()
	{
		String[] test = {
				  "11111111111111111111"
		};
		
		assertTrue( minTime(test) == 400 );
	}
	@Test
	public void test4()
	{
		String[] test = {
				  "1000",
				  "1100",
				  "1110"
				};
		
		assertTrue( minTime(test) == 3 );
	}
	@Test
	public void test5()
	{
		String[] test = {
				  "1000",
				  "1100",
				  "1110"
				};
		
		assertTrue( minTime(test) == 3 );
	}
	
	@Test
	public void test6()
	{
		String[] test = {"10010000000000000000", "01001100110000000011", "10000000100000000011", "01100101000000000101", "00000000000000100100", "00011000110100000000", "00000010000101000000", "11000000000010000000", "00000001000000000000", "00100010000100111110", "00100000010100000000", "00000000100000000000", "00011111001000000010", "00010001000000000011", "00000001001000000000", "00000010011100000010", "00000000010011000000", "00000001100100100100", "10000100001000000000", "10010000000000000000", "00010000011100000101", "01010001100000101000", "00100000001000001000", "00000000000000000000", "11000000001100100001", "00000100010010000001", "00000000000001010100", "00000010001001110110", "00000000100000100000", "00000001010001000000", "01001000000000000000", "11010000000110000000", "10000000010000010101", "10010010000100101000", "10000000100000001100", "10000001000000000000", "00000000000000000101", "01011011000101010000", "01000000000010000000", "01001000100010000000", "00000000110010001000", "01101000100000000000", "00000001010110000000", "00001101000001010001", "00000001001100010000", "00000010110000000000", "00010001001000000000", "10000001001000101001", "00000000001010100000", "00001001001011000010"};
		
		assertTrue( minTime(test) == 20 );
	}
	
	@Test
	public void test7()
	{
		String[] test = {"01111001100000101001", "00011001011111111000", "00010100011001000101", "01100100111111001011", "10000001101111101100", "01000100100101101001", "11110110110010110000", "01010001100110101110", "10101110000100110110", "10011111111111111100", "10001100101011111000", "10011000001101110110", "11111111100110111101", "01011010011001100100", "00111001110001111110", "10010001110101010011", "11100010110001111111", "01010110100011001110", "10001111100111100011", "10110111011110011011", "01111000110000101010", "01000000110011001100", "10001000111011111110", "11010111011011011101", "11100100011011101011", "10011110011010010111", "01010000101111100110", "10100011101000111101", "11101110100000000011", "01100101011101011010", "00110101101101110010", "01100000011001111100", "00101111111010001011", "11000001111111110101", "11001011100100010000", "11101101000100101011", "10110011100111111111", "11111111111101100111", "10010100001111010110", "01011001000011101110", "11010001010001001011", "00111111111110011111", "11010010101010001101", "01011111101010011011", "10010110101101111101", "00111010101011111111", "01110101110110101110", "10011111011011111010", "10010101101100011000", "01101011111110001111"};
		
		assertTrue( minTime(test) == 76 );
	}

	@Test
	public void test8()
	{
		String[] test = {"1111", "1111", "1011", "0111", "1111", "1111", "1111", "1011", "1111", "1111", "1111", "1100", "1111", "0110", "1111", "1101", "0111", "1111", "1111", "0111", "0111", "1111", "1111", "1111", "1110", "1111", "1010", "1111", "1011", "1100", "0110", "1101", "0111", "1111", "1011", "1111", "1111", "1111", "1111", "1110", "1111", "1111", "1111"};
		
		assertTrue( minTime(test) == 6 );
	}

	@Test
	public void test9()
	{
		String[] test = {"00001010011101100100", "00001111101000101101", "01100011111100110111", "01101010101110100101", "10000111110101110011", "00000110111011111100", "00110011010001111110", "01101101001001001111", "00111101111111100110", "01000000110100010010", "10011011111101000111", "01111010101101111010", "01011011100100101110", "01101000000000110110", "00110111110110001111", "00100011111001111001", "11000110100111111111", "00011010000111101110", "11001110101010000111", "11000010111000001001", "11110011010101001000", "01110110111111010000", "00010000101101101110", "01101111111110100001", "11010100111100011110", "11011000111011011000", "00011100110110011111", "11111101001110101111", "11110011001000010001", "11101101111001011000", "10101100101111000000", "10010011011101011010", "00100011011000001111", "11001110010010110111", "11111001111010010110", "11101001000101110101", "01101110011110101011", "01010100011110001111", "01010110011110101110", "00011100110010010001", "01111101101111110110", "01011011001110111100", "01110110110010110010", "11000100010000001111", "00000101011001110011", "11101011100011110011", "10100110011011010011", "01101101100000111101", "01100110001000111100", "11111000011010111100"};
		
		assertTrue( minTime(test) == 70 );
	}	
	@Test
	public void test10()
	{
		String[] test = {"11111110110111111001", "11111111111111010111", "01111111111111111100", "11111011111011111001", "01110110000111111101", "11111111111111111111", "11111111111111011110", "01101111111110001011", "11011111111111111001", "11111110111111111110", "01011011111111111011", "11101111111111111111", "11111111010110111111", "10111110011111100001", "10111110011111101110", "11101111111111111111", "11100111101101111111", "10111111111011111111", "11110111111111111111", "11101111011111111010", "11011111010111111111", "01111111111101111011", "11010110111111111101", "11011111111111111111", "11111011010011111001", "01001111111111111110", "11111111111111110111", "11111110011111111010", "11111111011111011101", "11011111111111111111", "11111110101100111111", "11111011111111110101", "11111101111100111111", "10111110111111110100", "11111111011011110111", "10111110111111101110", "11111011111011111111", "11111111111111111110", "01010111111011110111", "11111011111110111111", "11110111111111111111", "11111111110111111011", "11111111111111110111", "01101101111011000010", "01111111111111110011", "11111111111111111111", "11111010110010101011", "11110101111101010101", "11111111011011000111", "11011111111111111111"};
		
		assertTrue( minTime(test) == 148 );
	}	
}
