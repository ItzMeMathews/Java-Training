package com.codeexrcise.learning;

public class InsertionSrot {

	public static void main(String[] args) {
		int[] array = new int[] { 6, 2, 9, 5};

		for (int unsortedIndex = 1; unsortedIndex < array.length; unsortedIndex++) {
			int unSortedElement = array[unsortedIndex];
			int sortedIndex;
			for (sortedIndex = unsortedIndex; sortedIndex > 0
					&& array[sortedIndex - 1] > unSortedElement; sortedIndex--) {
				array[sortedIndex] = array[sortedIndex - 1];
			}
			array[sortedIndex] = unSortedElement;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	} 

}
