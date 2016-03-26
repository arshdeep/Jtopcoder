package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class RGBColor {
	int[] get(int[] rgb) {
		int[] com = new int[rgb.length];
		
		com[0] = 255 - rgb[0];
		com[1] = 255 - rgb[1];
		com[2] = 255 - rgb[2];
		
		return com;
	}
	boolean isValid(int[] rgb, int[] com) {
		if (rgb[0] > 255 || rgb[1] > 255 || rgb[2] > 255 || rgb[0] < 0 || rgb[1] < 0 || rgb[2] < 0
				|| com[0] > 255 || com[1] > 255 || com[2] > 255 || com[0] < 0 || com[1] < 0 || com[2] < 0) {
			return false;
		}
		if (!(Math.abs(rgb[0] - com[0]) > 32 || Math.abs(rgb[1] - com[1]) > 32 ||  Math.abs(rgb[2] - com[2]) > 32)) {
			return false;
		}
		return true;
	}
	
	int[] getAlternate(int[] rgb) {
		
		for (int mask = 0; mask < (1 << 3); ++mask) {
			int[] cl = rgb.clone(); 
			for (int i = 0; i < 3; ++i) {
				if ((mask & (1<<i)) != 0) {
					cl[i] += 128;
				}
				else {
					cl[i] -= 128;
				}
			}
			if (isValid(rgb, cl)) {
				return cl;
			}
		}
	
		return rgb;
	}
	
	public int[] getComplement(int[] rgb) {
		int[] com = get(rgb);
		
		if (!isValid(rgb, com)) {
			return getAlternate(rgb);
		}
		
		return com;
	}
	@Test
	public void test() {
		assertTrue(Arrays.equals( getComplement(new int[]{115,115,144}), new int[]{140,  140,  111}) );
		assertTrue(Arrays.equals( getComplement(new int[]{115,115,143}), new int[]{243,  243,  15}) );
		assertTrue(Arrays.equals( getComplement(new int[]{255,0,0}), new int[]{0,255,255}) );

	}
}
