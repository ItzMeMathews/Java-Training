package com.codeexrcise.learning;

public class StringEquals {

	public static void main(String[] args) {
		String s1= "Apple";
		String s2= "Apple";
		String s3= new String("Apple");
		String s4= new String("Apple");
		
		//== Matches address
        System.out.println(s1==s2);
        System.out.println(s2==s3);
        System.out.println(s3==s4);
        System.out.println(s2==s4);
        //equals() Matches content of the string
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s2.equals(s4));
        //Test
	}

}
