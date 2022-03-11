package com.codeexrcise.learning;

import java.math.BigInteger;
import java.util.Scanner;

public class APlusB {

    public static void main(String args[] ) throws Exception { 
       Scanner s = new Scanner(System.in);
       while(s.hasNextBigInteger()){
       BigInteger a = s.nextBigInteger();
       BigInteger b = s.nextBigInteger();

       System.out.println(a.add(b));
       }
       
    }

}
