package com.codeexrcise.learning;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int noOfElements = s.nextInt();
			int noOfSteps = s.nextInt();
			int[] array = new int[noOfElements];
			int index = 0;
			while (s.hasNextInt()) {
				array[index] = s.nextInt();
				index++;
			}
			for (int k = 0; k < noOfSteps; k++) {
				int currentLastNum = array[(array.length) - 1];
				for (int j = (array.length) - 1; j >= 0; j--) {
					if (j > 0) {

						array[j] = array[j - 1];
					} else {
						array[j] = currentLastNum;
					}
				}
			}
			for (int z = 0; z < array.length; z++) {
				System.out.print(array[z] + " ");
			}
		}
		s.close();

	}

}
