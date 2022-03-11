package com.codeexrcise.learning;

import java.util.Scanner;

public class NoOfWays {

	// Driver Program
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int k = 0; k < tc; k++) {
			int n = s.nextInt();
			int m = s.nextInt();
			int mod = 1000000009;
			if (n < m) {
				System.out.println(0);
			} else {
				int rows = (n - m) + 1;

				int[][] dp = new int[rows][n + 1];
				int num[] = new int[rows];
				num[0] = m;

				for (int y = 1; y < rows; y++) {
					num[y] = num[y - 1] + 1;
				}

				for (int x = 0; x <= n; x++) {
					if (x % m == 0) {
						dp[0][x] = 1;
					} else {
						dp[0][x] = 0;
					}
				}
				for (int i = 1; i < rows; i++) {
					dp[i][0] = 1;
					for (int j = 0; j <= n; j++) {
						if (num[i] > j) {
							dp[i][j] = dp[i - 1][j] % mod;
						} else {
							dp[i][j] = (dp[i - 1][j] + dp[i][j - num[i]]) % mod;
						}
					}
				}

				System.out.println(dp[rows - 1][n]);
			}
		}
		s.close();
	}
}
