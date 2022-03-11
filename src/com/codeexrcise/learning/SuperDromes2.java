package com.codeexrcise.learning;

import java.util.*;

public class SuperDromes2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noOfQueries = s.nextInt();
		List<Integer> nonPalindromic = new ArrayList<Integer>();
		Map<Integer, Integer> noSuperDromeMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < noOfQueries; i++) {
			int number = s.nextInt();
			int count = 0;
			if (noSuperDromeMap.get(number) != null) {
				count = noSuperDromeMap.get(number);
			} else {
				for (int j = 1; j <= number; j++) {
					if (nonPalindromic.contains(j)) {
						continue;
					} else {
						if (noSuperDromeMap.get(j) != null) {
							count = noSuperDromeMap.get(j);
							continue;
						} else {
							Integer tempNumber = j;
							StringBuilder string = new StringBuilder();
							if (j == Integer.valueOf(string.append(j).reverse().toString())) {
								StringBuilder string1 = new StringBuilder();
								string1.append(Integer.toBinaryString(tempNumber));
								if (string1.toString().equalsIgnoreCase(string1.reverse().toString())) {
									count++;
									noSuperDromeMap.put(j, count);
								}
							} else {
								nonPalindromic.add(j);
							}
						}
					}
				}
			}
			System.out.print(count + " ");
		}
		s.close();
	}

}
