package com.topcoder;

import java.math.BigInteger;

public class MagicDiamonds {
	public long minimalTransfer(long n) {
		if (n == 3)
			return 3;
		else if (BigInteger.valueOf(n).isProbablePrime(100))
			return 2;
		else
			return 1;
	}
}	
