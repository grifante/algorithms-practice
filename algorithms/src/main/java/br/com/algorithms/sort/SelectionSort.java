package br.com.algorithms.sort;

public class SelectionSort<E extends Comparable<E>> extends Sort<E> {

	@Override
	public void sort(E[] data) {
		int n = data.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int y = i + 1; y < n; y++) {
				if (less(data[y], data[min])) {
					min = y;
				}
			}
			exchange(data, i, min);
		}
	}

}
