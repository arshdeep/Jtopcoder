package com.topcoder;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;
/*http://community.topcoder.com/stat?c=problem_statement&pm=13779*/

public class FilipTheFrog {
	
	public int countReachableIslands(int[] positions, int L) {
		int res = 0;

		Stack<Integer> stk = new Stack<Integer>();
		boolean [] seen = new boolean[1000];
		stk.push(positions[0]);
		seen[positions[0]] = true;
		
		Arrays.sort(positions);		
		
		while (!stk.empty()) {
			int top = stk.pop();
			++res;
			
			for (int i = 1; i <= L; ++i) {
				int l = top - i;
				int r = top + i;
	
				if (Arrays.binarySearch(positions, l) >= 0 && !seen[l]) {
					seen[l] = true;
					stk.push(l);
				}
				if (Arrays.binarySearch(positions, r) >= 0 && !seen[r]) {
					seen[r] = true;
					stk.push(r);
				}			
			}
		}
		
		return res;
	}

	@Test
	public void test() {
		assertTrue( countReachableIslands( new int[]{4, 7, 1, 3, 5}, 1) == 3 );
		assertTrue( countReachableIslands( new int[]{100, 101, 103, 105, 107}, 2) == 5 );
		assertTrue( countReachableIslands( new int[]{17, 10, 22, 14, 6, 1, 2, 3}, 4) == 7 );
		assertTrue( countReachableIslands( new int[]{0}, 1000) == 1 );
		assertTrue( countReachableIslands( new int[]{131, 326, 78, 439, 476, 744, 72, 333, 792, 826, 28, 749, 399, 958, 551, 929, 144, 564, 434, 347, 655, 324, 60, 375, 989, 296, 866, 602, 726, 425, 596, 793, 117, 251, 361, 519, 583, 299, 284, 638, 994, 105, 385, 6, 152, 734, 805, 230, 398, 803}, 155) == 50 );
		assertTrue( countReachableIslands( new int[]{511, 15, 409, 667, 205, 23, 772, 212, 375, 944, 527, 98, 758, 273, 244, 803, 593, 857, 80, 126, 982, 10}, 157) == 22 );
		assertTrue( countReachableIslands( new int[]{633, 430, 611, 191, 5, 727, 111, 412, 626, 805, 50, 0, 217, 807, 704, 260, 434, 709, 16, 850, 959, 445, 305, 579, 896, 201, 965, 492, 406, 227, 54, 456, 622, 91, 586, 578, 895, 215, 279, 650}, 103) == 40 );
		assertTrue( countReachableIslands( new int[]{330, 696, 245, 827, 303, 601, 58, 379, 849, 970, 339, 911, 548, 399, 118, 49, 784, 863, 781, 287, 284, 540, 952, 592, 177, 342, 670, 560, 541, 554, 173, 491, 931, 706, 905, 75, 644, 543, 378, 641, 772, 273, 803, 628, 971}, 90) == 17 );
		assertTrue( countReachableIslands( new int[]{803, 496, 886, 634, 954, 335, 356, 761, 783, 109, 550, 907, 996, 647, 941, 274, 681, 248, 246, 229, 606, 513, 230, 834, 961, 735, 644, 235, 91, 197, 432, 521, 562, 178, 191, 569, 63, 571, 708, 893, 74, 390, 906, 400, 696, 380, 340, 515, 411, 546}, 98) == 50 );
	}
}
