package com.codeexrcise.learning;

import java.util.Scanner;

class MinimumNumber {
	public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		int numberOfInt = s.nextInt();
		int values[] = new int[numberOfInt];
		int tempMinVal = 0;
		for (int t = 0; t < numberOfInt; t++) {

			values[t] = s.nextInt();
		}
		if (values == null || values.length < 1) {
			System.out.println("No input received");
		} else {
			tempMinVal = values[0];
			for (int i = 0; i < numberOfInt; i++) {
				if (values[i] < tempMinVal) {
					tempMinVal = values[i];
				}
			}
		}
		System.out.println("Min Value : " + tempMinVal);
		s.close();
	}
}
