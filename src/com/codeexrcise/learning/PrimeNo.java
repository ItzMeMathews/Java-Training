package com.codeexrcise.learning;

public class PrimeNo {

	public static void main(String[] args) {
       // Test comment for pushing to git hub
		for (int i = 2; i <= 100; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {

				if (i % j == 0) {
					count++;
				}

			}
			if (count == 2) {
				System.out.println(i);
			}

		}
		//Test For Merge Conflict

	}

}
