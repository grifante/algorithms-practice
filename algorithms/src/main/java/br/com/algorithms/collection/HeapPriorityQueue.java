package br.com.algorithms.collection;

import java.util.Iterator;

public class HeapPriorityQueue<E extends Comparable<E>> implements Queue<E> {

	private E[] pq;
	private int n;

	@SuppressWarnings("unchecked")
	public HeapPriorityQueue(int maxSize) {
		pq = (E[]) new Comparable[maxSize + 1];
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public void enqueue(E e) {
		pq[++n] = e;
		swim(n);
	}

	@Override
	public E dequeue() {
		E e = pq[1];
		pq[1] = pq[n];
		pq[n--] = null;
		sink(1);
		return e;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exchange(int i, int j) {
		E e = pq[j];
		pq[j] = pq[i];
		pq[i] = e;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exchange(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (k * 2 <= n) {
			int j = k * 2;
			if (j < n && less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exchange(k, j);
			k = j;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				throw new UnsupportedOperationException();
			}

			@Override
			public E next() {
				throw new UnsupportedOperationException();
			}
		};
	}

}
