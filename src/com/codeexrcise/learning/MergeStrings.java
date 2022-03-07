package com.codeexrcise.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergeStrings {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String str1 = s.nextLine();
		String str2 = s.nextLine();
		String[] a1 = str1.split("");
		String[] a2 = str2.split("");
		List<String> l1 = new ArrayList(Arrays.asList(a1));
		List<String> l2 = new ArrayList(Arrays.asList(a2));
		String op1 = "";
		String op2 = "";
		for (String c : l1) {
			if (!l2.contains(c.toString())) {
				op1 = op1 + c.toString();
			}

		}

		for (String c : l2) {
			if (!l1.contains(c.toString())) {
				op2 = op2 + c.toString();
			}

		}
		System.out.print(op1);
		System.out.print(op2);

	}

}
