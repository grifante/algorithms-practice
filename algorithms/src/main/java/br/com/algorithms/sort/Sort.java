package br.com.algorithms.sort;

public abstract class Sort<E extends Comparable<E>> {

	public abstract void sort(E[] data);

	protected void exchange(E[] data, int i, int y) {
		E x = data[i];
		data[i] = data[y];
		data[y] = x;
	}

	protected boolean less(E a, E b) {
		return a.compareTo(b) < 0;
	}

}
