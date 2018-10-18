package br.com.algorithms.search;

public class BinarySearch {

	public static int indexOf(int[] values, int key) {
		int lo = 0;
		int li = values.length - 1;
		while (lo <= li) {
			int mid = lo + (li - lo) / 2;
			if (key < values[mid]) {
				li = mid - 1;
			} else if (key > values[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
