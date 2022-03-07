package com.codeexrcise.learning;

import java.util.ArrayList;
import java.util.HashSet;

public class DuplicateElemInList {
    //Test Comment
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList();

		l.add(12);
		l.add(23);
		l.add(45);
		l.add(67);
		l.add(89);
		l.add(56);
		l.add(23);
		l.add(90);
		l.add(91);
		l.add(92);
		l.add(23);
		l.add(34);
		l.add(12);
		l.add(65);
		l.add(54);
		l.add(12);
		l.add(78);
		l.add(12);
		ArrayList<Integer> r = new ArrayList<Integer>();
		HashSet<Integer> d = new HashSet<Integer>();

		for (Integer i : l) {
			if (!r.contains(i)) {
				r.add(i);
			} else {
				d.add(i);
			}
		}

		System.out.println(d);

	}

}
