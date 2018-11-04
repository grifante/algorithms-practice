package br.com.algorithms.sort;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {

	@Override
	public void sort(E[] data) {
		int n = data.length;
		int h = 1;
		
		// increment sequence
		while (h < n / 3)
			h = 3 * h + 1;

		while (h >= 1) {
			for (int x = h; x < n; x++) {
				for(int y = x; y >= h && less(data[y], data[y -h]); y -= h)
					exchange(data, y, y - h);
			}
			h = h/3;
		}
	}

}
