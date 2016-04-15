package com.topcoder.archive;

import java.util.Arrays;

public class Quorum {
	public int count(int[] arr, int k)
	{
		Arrays.sort(arr);
		
		int sum = 0;
		
		for (int i = 0; i < k; ++i) {
			sum += arr[i];
		}
		
		return sum;
	}	
}
