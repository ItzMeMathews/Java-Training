package com.codeexrcise.learning;

import java.util.ArrayList;
import java.util.List;

public class UniquePairs {

	public static void main(String[] args) {
		//Test Comment
		String[][] a = { { "U1", "U2" }, { "U3", "U4" }, { "U1", "U5" }, { "U2", "U1" }, { "U3", "U4" } };
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();

		List<String> lr1 = new ArrayList<String>();
		List<String> lr2 = new ArrayList<String>();
		for (int i = 0; i < a.length; i++) {

			l1.add(a[i][0]);
			l2.add(a[i][1]);

		}
		for (int i = 0; i < l1.size(); i++) {
			if (lr1.isEmpty()) {

				lr1.add(l1.get(i));
				lr2.add(l2.get(i));

			} else {
				if (l2.contains(l1.get(i))) {
					int index = l2.indexOf(l1.get(i));
					if (!(l1.size() > index && l1.get(index).equalsIgnoreCase(l2.get(i)))) {
						lr1.add(l1.get(i));
						lr2.add(l2.get(i));
					}
				} else if (l1.contains(l1.get(i))) {
					if (lr1.contains(l1.get(i))) {
						int index = lr1.indexOf(l1.get(i));
						if (!(lr2.size() > index && lr2.get(index).equalsIgnoreCase(l2.get(i)))) {
							lr1.add(l1.get(i));
							lr2.add(l2.get(i));
						}
					} else {
						lr1.add(l1.get(i));
						lr2.add(l2.get(i));
					}

				}
			}

		}

		for (int i = 0; i < lr1.size(); i++) {
			for (int j = i; j <= i; j++) {
				System.out.println(lr1.get(i) + "," + lr2.get(j));
			}

		}

	}

}
