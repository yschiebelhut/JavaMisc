package de.schiebelhut.misc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yannik Schiebelhut
 */
public class Test {
	public static void main(String[] args) {
		String[] arr = {"Hallo", "mein", "Name", "ist", "Yannik"};
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		};
		System.out.println(Arrays.toString(arr));
		Sorting.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		Sorting.quickSort(arr, c);
		System.out.println(Arrays.toString(arr));

		Integer[] arr2 = {1,3,4,2,-1};
		System.out.println(Arrays.toString(arr2));
		Sorting.quickSort(arr2);
		System.out.println(Arrays.toString(arr2));
	}
}


// [Hallo, mein, Name, ist, Yannik]
// [Hallo, Name, Yannik, ist, mein]
// [Hallo, ist, mein, Name, Yannik]
// [1, 3, 4, 2, -1]
// [-1, 1, 2, 3, 4]