package com.codeexrcise.learning;

import java.util.*;

public class Superdromes {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noOfQueries = s.nextInt();
		SortedSet<Integer> superDromeList = new TreeSet<Integer>();
		SortedSet<Integer> nonSuperDromeList = new TreeSet<Integer>();
		List<Integer> numberList = new ArrayList<Integer>();
		for (int i = 0; i < noOfQueries; i++) {
			int number = s.nextInt();
			int count = 0;
			for (int j = number; j > 0; j--) {
				if (superDromeList.contains(j)) {
					count++;
				} else if (nonSuperDromeList.contains(j)) {
					continue;
				} else {

					int temp1 = j;
					int k;
					int reversedNum = 0;
					if (j > 9) {

						while (temp1 > 0) {
							k = temp1 % 10;
							temp1 = temp1 / 10;
							reversedNum = (reversedNum * 10) + k;
						}
					} else {
						reversedNum = j;
					}
					if (j == reversedNum) {

						int temp2 = j;
						String binRepInString = "";
						while (temp2 > 0) {
							k = temp2 % 2;
							temp2 = temp2 / 2;
							binRepInString = k + binRepInString;
						}

						int binaryRep = Integer.valueOf(binRepInString);
						int temp3 = binaryRep;
						int k2;
						String reversedBinNum = "";
						while (temp3 > 0) {
							k2 = temp3 % 10;
							temp3 = temp3 / 10;
							reversedBinNum = reversedBinNum + k2;
						}
						if (binRepInString.equalsIgnoreCase(reversedBinNum)) {
							count++;
							superDromeList.add(j);
						} else {
							nonSuperDromeList.add(j);
						}
					}
				}
			}
			System.out.print(count + "");
		}
		s.close();
	}

}
