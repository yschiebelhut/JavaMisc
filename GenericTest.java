package de.schiebelhut.misc;

import java.util.Comparator;

/**
 * @author Yannik Schiebelhut
 */
public class GenericTest {

	public static <E> void bubbleSort(E[] arr, Comparator<E> c) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (c.compare(arr[j],arr[j - 1]) < 0) {
					E tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}

	public static <E extends Comparable<E>> void bubbleSort(E[] arr) {
		Comparator<E> c = new Comparator<E>() {
			@Override
			public int compare(E o1, E o2) {
				return o1.compareTo(o2);
			}
		};
		bubbleSort(arr, c);
	}
}
