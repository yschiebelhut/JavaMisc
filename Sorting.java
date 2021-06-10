package de.schiebelhut.misc;

import java.util.Comparator;

/**
 * @author Yannik Schiebelhut
 */
public class Sorting {

	/**
	 * Sorts the given array in place with bubble sort.
	 *
	 * @param a   array to sort
	 * @param c   Comparator to use for sorting
	 * @param <E> type of elements to sort
	 */
	public static <E> void bubbleSort(E[] a, Comparator<E> c) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length - i; j++) {
				if (c.compare(a[j], a[j - 1]) < 0) {
					E tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
		}
	}

	/**
	 * Sort the given array in place with bubble sort.
	 *
	 * @param a   array to sort
	 * @param <E> type of elements to sort; type must implement Comparable
	 */
	public static <E extends Comparable<E>> void bubbleSort(E[] a) {
		Comparator<E> c = Comparable::compareTo;
		bubbleSort(a, c);
	}

	/**
	 * Sort the given array in place with insertion sort.
	 *
	 * @param a   array to sort
	 * @param c   Comparator to use for sorting
	 * @param <E> type of elements to sort
	 */
	public static <E> void insertionSort(E[] a, Comparator<E> c) {
		// start with the second value and repeat the procedure for each of the following values in the array
		for (int i = 1; i < a.length; i++) {
			// if the current value is smaller than the prior, swap it backwards till it's in the right position
			if (c.compare(a[i], a[i - 1]) < 0) {
				for (int j = i; (j > 0) && (c.compare(a[j], a[j - 1]) < 0); j--) {
					E tmp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = tmp;
				}
			}
		}
	}

	/**
	 * Sort the given array in place with insertion sort.
	 *
	 * @param a   array to sort
	 * @param <E> type of elements to sort
	 */
	public static <E extends Comparable<E>> void insertionSort(E[] a) {
		Comparator<E> c = Comparable::compareTo;
		insertionSort(a, c);
	}


	/**
	 * Wrapper method for the merge sort algorithm, so it can be called easily on
	 * every array of integers without having to calculate important values for
	 * calling the actual merge sort.
	 *
	 * @param pArr unsorted array of integers
	 * @return sorted array of integers
	 */
	// TODO: generic
	public static int[] mergeSort(int[] pArr) {
		mergeSort(pArr, 0, pArr.length);
		return pArr;
	}

	public static void mergeSort(int[] pArr, int low, int high) {
		if ((high - low) <= 1) // when there is only one element, it's already sorted
			return;
		int split = (low + high) / 2;

		mergeSort(pArr, low, split);
		mergeSort(pArr, split, high);

		int[] scratch = new int[split - low];
		for (int i = low; i < split; i++) {
			scratch[i - low] = pArr[i];
		}
		int tmp1 = 0;
		int tmp2 = split;
		int i = low;
		while (i < tmp2 && tmp2 < high) {
			if (scratch[tmp1] <= pArr[tmp2]) {
				pArr[i++] = scratch[tmp1++];
			} else
				pArr[i++] = pArr[tmp2++];
		}
		while (i < tmp2) {
			pArr[i++] = scratch[tmp1++];
		}
	}

	/**
	 * Sort the given array in place with selection sort.
	 *
	 * @param a   array to sort
	 * @param c   Comparator to use for sorting
	 * @param <E> type of elements to sort
	 */
	public static <E> void selectionSort(E[] a, Comparator<E> c) {
		// logically separate the sorted part of the array from the unsorted
		for (int curPos = 0; curPos < a.length; curPos++) {
			// remember the value from the first unsorted position
			E min = a[curPos];
			// go through the rest of the unsorted array
			for (int i = curPos + 1; i < a.length; i++) {
				// if smaller value is found, insert the current one into the position of the
				// smaller one and from then remember the new smallest value
				if (c.compare(min, a[i]) > 0) {
					E tmp = min;
					min = a[i];
					a[i] = tmp;
				}
			}
			// paste the smallest value found into the first position of the unsorted array
			// which then becomes the last position of the sorted part
			// all other values remain in the array as they just swapped places with the
			// smallest value
			a[curPos] = min;
		}
	}

	/**
	 * Sort the given array in place with selection sort.
	 *
	 * @param a   array to sort
	 * @param <E> type of elements to sort
	 */
	public static <E extends Comparable<E>> void selectionSort(E[] a) {
		Comparator<E> c = Comparable::compareTo;
		selectionSort(a, c);
	}

	/**
	 * Wrapper method for the quick sort algorithm, so it can be called easily on
	 * every array of integers without having to calculate important values for
	 * calling the actual quick sort.
	 *
	 * @param pArr unsorted array of integers
	 * @return sorted array of integers
	 */
	public static int[] quickSort(int[] pArr) {
		quickSort(pArr, 0, pArr.length);
		return pArr;
	}

	public static void quickSort(int[] pArr, int low, int high) {
		if ((high - low) <= 1) // when there is only one element, it's already sorted
			return;
		int pivot = pArr[high - 1]; // set the pivot to the value of the last index in the range, given by the
		// parameters
		int split = low; // set the splitting point to the very first index; variable used to mark the
		// end of the section containing elements smaller than the pivot

		for (int i = low; i < high - 1; i++) { // rush through each element in the given range
			// if the current element is smaller than the pivot element, swap it to the end
			// of the splitting area and increase the latter by one
			if (pArr[i] < pivot) {
				int tmp = pArr[i];
				pArr[i] = pArr[split];
				pArr[split] = tmp;
				split++;
			}
		}

		// swap the pivot element to the end of the section of smaller elements than the
		// pivot
		int tmp = pArr[split];
		pArr[split] = pArr[high - 1];
		pArr[high - 1] = tmp;

		// recursion
		quickSort(pArr, low, split); // call the quick sort on the elements before the pivot
		quickSort(pArr, ++split, high); // call the quick sort on the elements behind the pivot
	}

	/**
	 * Sort the given range of the given array in place with quick sort.
	 *
	 * @param a    array to sort
	 * @param low  first index of range to be sorted (inclusive)
	 * @param high last index of range to be sorted (inclusive)
	 * @param c    Comparator to use for sorting
	 * @param <E>  type of elements to sort
	 */
	public static <E> void quickSort(E[] a, int low, int high, Comparator<E> c) {
		if ((high - low) < 1) // when first and last index are the same, there is only one element and therefore range
			// is already sorted
			return;
		E pivot = a[high]; // set the pivot to the value of the last index in the given range
		int split = low; // set the splitting point to the very first index of the range; variable used to mark the
		// end of the section containing elements smaller than the pivot

		for (int i = low; i < high; i++) {
			// if the current element is smaller than the pivot element, swap it to the end of the splitting area and
			// increase the latter by one
			if (c.compare(a[i], pivot) < 0) {
				E tmp = a[i];
				a[i] = a[split];
				a[split] = tmp;
				split++;
			}
		}

		// swap the pivot element to the end of the section of smaller elements than the pivot
		E tmp = a[split];
		a[split] = a[high];
		a[high] = tmp;

		// recursion
		quickSort(a, low, split - 1, c); // call the quick sort on the elements before the pivot
		quickSort(a, split + 1, high, c); // call the quicksort on the elements behind the pivot
	}

	/**
	 * Sort the given range of the given array in place with quick sort.
	 *
	 * @param a    array to sort
	 * @param low  first index of range to be sorted (inclusive)
	 * @param high last index of range to be sorted (inclusive)
	 * @param <E>  type of elements to sort
	 */
	public static <E extends Comparable<E>> void quickSort(E[] a, int low, int high) {
		Comparator<E> c = Comparable::compareTo;
		quickSort(a, low, high, c);
	}

	/**
	 * Sort the given array in place with quick sort.
	 *
	 * @param a   array to sort
	 * @param c   Comparator to use for sorting
	 * @param <E> type of elements to sort
	 */
	public static <E> void quickSort(E[] a, Comparator<E> c) {
		quickSort(a, 0, a.length - 1, c);
	}

	/**
	 * Sort the given array in place with quick sort.
	 *
	 * @param a   array to sort
	 * @param <E> type of elements to sort
	 */
	public static <E extends Comparable<E>> void quickSort(E[] a) {
		quickSort(a, 0, a.length - 1);
	}
}