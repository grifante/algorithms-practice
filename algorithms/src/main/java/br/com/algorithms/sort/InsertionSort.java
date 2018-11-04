package br.com.algorithms.sort;

public class InsertionSort extends Sort<Integer> {

	@Override
	public void sort(Integer[] data) {
		int n = data.length;
		for (int i = 1; i < n; i++) {
			for (int y = i; y > 0 && less(data[y], data[y - 1]); y--) {
				exchange(data, y, y - 1);
			}
		}

	}

}
