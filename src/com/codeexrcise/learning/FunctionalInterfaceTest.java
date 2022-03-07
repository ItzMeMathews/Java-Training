package com.codeexrcise.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalInterfaceTest {

	private static void Sum(int a, int b) {
		System.out.println(a + b);
	}

	public static void main(String[] args) {

		Predicate<Integer> p = i -> i % 2 == 0;
		System.out.println(p.test(10));

		Function<Integer, Integer> f = i -> i * 2;
		System.out.println(f.apply(10));

		Consumer<Integer> c = i -> System.out.println(10);
		c.accept(10);

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);

		List<Integer> filtered = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(filtered);

		List<Integer> mapped = l.stream().map(i -> i * 2).collect(Collectors.toList());
		System.out.println(mapped);

		List<Integer> defaultSorted = l.stream().sorted().collect(Collectors.toList());
		System.out.println(defaultSorted);

		List<Integer> customSorted = l.stream().sorted((i1, i2) -> (i1 > i2) ? -1 : (i1 < i2) ? 1 : 0)
				.collect(Collectors.toList());
		System.out.println(customSorted);

		Integer omax = l.stream().max((i1, i2) -> (i1 > i2) ? -1 : (i1 < i2) ? 1 : 0).get();
		System.out.println(omax);

		Integer omin = l.stream().min((i1, i2) -> (i1 > i2) ? -1 : (i1 < i2) ? 1 : 0).get();
		System.out.println(omin);

		l.stream().forEach(System.out::println);

		Interef i = FunctionalInterfaceTest::Sum;
		i.add(10, 20);

		Runnable r = () -> {
			System.out.println(5);
		};

		Thread t = new Thread(r);
		t.start();
		byte b = 1;
		b += 1;
		System.out.println("Value : " + b);

		FunctinalInterfaceWithoutAnnotation fi = (j, m) -> System.out.println(j + m);
		fi.sum(10, 20);
		

        List <Integer> listOfIntegers = Arrays.asList(20, 50, 99, 12, 94);
 
        OptionalDouble average = listOfIntegers
            .stream()
            .mapToInt(number -> number.intValue())
            .average();
 
        System.out.println("Average of Numbers: " + average);
        
        
        int[] arr = new int[10];
        
        arr[0] = 20;
        arr[1] = 50;
        arr[2] = 99;
        arr[3] = 12;
        arr[4] = 94;
        arr[5] = 22;
        arr[6] = 43;
        arr[7] = 56;
        arr[8] = 55;
        arr[9] = 78;
 
        IntStream streamOfNumbers = Arrays.stream(arr);
 
        OptionalDouble averageOfNumbers = streamOfNumbers.average();
 
        System.out.println("Average of Numbers: " + averageOfNumbers);
 
	}

}
