package br.com.algorithms.sort;

public class InsertionSort<E extends Comparable<E>> extends Sort<E> {

	@Override
	public void sort(E[] data) {
		int n = data.length;
		for (int i = 1; i < n; i++) {
			for (int y = i; y > 0 && less(data[y], data[y - 1]); y--) {
				exchange(data, y, y - 1);
			}
		}

	}

}
