package com.codeexrcise.learning;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = new int[] { 6, 2, 9, -2, -4, 10, 3, -5, 8, 1, -1, 4, 5, -3 ,7};

		for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex >= 0; lastUnsortedIndex--) {
			for (int i = 0; i < (lastUnsortedIndex - 1); i++) {
				if (array[i] > array[i + 1]) {
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
				}

			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
