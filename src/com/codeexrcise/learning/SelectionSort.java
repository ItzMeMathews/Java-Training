package com.codeexrcise.learning;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = new int[] { 6, 2, 9, -2, -4, 10, 3, -5, 8, 1, -1, 4, 5, -3 ,7 };

		for (int lastUnsortedIndex = (array.length) - 1; lastUnsortedIndex >= 0; lastUnsortedIndex--) {

			int largest = 0;
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (array[i] > array[largest]) {
					largest = i;
				}

			}

			int tmp = array[largest];
			array[largest] = array[lastUnsortedIndex];
			array[lastUnsortedIndex] = tmp;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
