
package com.codeexrcise.learning;
import java.util.Scanner;


public  class BasicInputOutput {
	public static void main(String args[]) throws Exception {

		// Scanner
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		s.nextLine();
		String name = s.nextLine();
		System.out.println(a * 2);
		System.out.println(name);
		s.close();
		APlusB ab = new APlusB();
	}
}
