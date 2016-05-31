package com.topcoder.archive;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RGBTree {
	Boolean [][][][]dp;
	int n;
	int k;
	String[] G;
	boolean solve(int mask, int r, int g, int b) {
		if (r > k || g > k || b >k) {
			return false;
		}
		boolean res = false;
		
		if (dp[mask][r][g][b] != null) {
			return dp[mask][r][g][b];
		}

		if (mask == ((1<<n) - 1) && r == k && b == k && g == k) {
			res = true;
		}
		else {
			for (int i = 0; i < n; ++i) if ( (mask & (1<<i) ) != 0 ) {

				for (int j = 0; j < n; ++j) if ( (mask & (1<<j)) == 0 && G[i].charAt(j) != '.' ) {
					int rc = 0, gc = 0, bc = 0;

					switch (G[i].charAt(j)) {
						case 'R':
							++rc;
							break;
						case 'G':
							++gc;
							break;
						case 'B':
							++bc;
							break;
					}
					res = (res || solve(mask | (1<<j), r + rc, g + gc, b + bc));
					
				}

			}
		}

		return dp[mask][r][g][b] = res;
	}
	public String exist(String[] G) {
		this.G = G;
		n = G.length;
		k = (n - 1)/3;
		dp = new Boolean[1<<n][n + 1][n + 1][n + 1];
		return solve(1, 0, 0, 0) ? "Exist" : "Does not exist";
	}
	
	@Test
	public void test() {
		assertTrue(exist(new String[]{".RGRR.R", "R.G.R.B", "GG..R..", "R.....G", "RRR..GR", "....G.R", "RB.GRR."}).equals("Does not exist") );		
		assertTrue(exist(new String[]{".............",".......BB.R..",".......RR....",".....G.G....R","........BB...","...G.........","........B...R",".BRG.......G.",".BR.B.B...GB.","....B......GR",".R......G....",".......GBG..B","...R..R..R.B."}).equals("Does not exist") );		

		assertTrue(exist(new String[]{"..B.BB...RB..","......R..B.G.","B.......BB...",".......R...G.","B....GRB..R..","B...G.RG.R...",".R..RR..B.RB.","...RBG...G...","..B...B......","RBB..R.G....R","B...R.R......",".G.G..B.....R",".........R.R."}).equals("Exist") );	
		assertTrue(exist(new String[]{".R..BG..G..RG","R...GG..BR.G.","...G.GG.RR.BB","..G.RR.B..GRB","BG.R.G.BRRR.G","GGGRG.R....RR","..G..R.BGRR..","...BB.B.RB.G.","GBR.R.GR.B.R.",".RR.R.RBB.BRB","...GR.R..B...","RGBR.R.GRR...","G.BBGR...B..."}).equals("Exist") );	
		assertTrue(exist(new String[]{".RRB",
				 "R...",
				 "R...",
				 "B..."}).equals("Does not exist") );		
		assertTrue(exist(new String[]{".RGB",
				 "R...",
				 "G...",
				 "B..."}).equals("Exist") );
	}
}
