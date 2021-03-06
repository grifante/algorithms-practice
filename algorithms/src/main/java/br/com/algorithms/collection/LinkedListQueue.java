package br.com.algorithms.collection;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E> {

	private Node first;
	private Node last;
	private int size;

	@Override
	public void enqueue(E item) {
		Node oldLast = last;

		last = new Node();
		last.item = item;

		if (isEmpty()) {
			first = last;
		} else
			oldLast.next = last;
		size++;
	}

	@Override
	public E dequeue() {
		E item = first.item;
		first = first.next;
		size--;
		if (isEmpty())
			last = null;
		return item;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private Node current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				E item = current.item;
				current = current.next;
				return item;
			}
		};
	}

	private class Node {

		E item;
		Node next;

	}

}
