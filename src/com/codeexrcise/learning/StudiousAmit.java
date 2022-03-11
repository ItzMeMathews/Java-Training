package com.codeexrcise.learning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StudiousAmit {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int noOfCourses = s.nextInt();
			int noOfPairs = s.nextInt();
			int isPossible = 1;
			Map<Integer, Integer> distinctPreReqPair = new HashMap<Integer, Integer>();
			for (int j = 0; j < noOfPairs; j++) {
				distinctPreReqPair.put(s.nextInt(), s.nextInt());
			}
			Iterator<Entry<Integer, Integer>> iterator = distinctPreReqPair.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, Integer> entry = iterator.next();
				if (distinctPreReqPair.containsKey(entry.getValue())) {
					if (distinctPreReqPair.get(entry.getValue()).equals(entry.getKey())) {
						isPossible = 0;
						break;
					}
				}
			}
			System.out.println(isPossible);
		}
	}

}
