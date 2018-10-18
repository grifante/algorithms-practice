package br.com.algorithms.collection;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E> {

	private Node top;
	private int size;

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void push(E item) {
		Node node = new Node();
		node.item = item;
		node.previous = top;
		top = node;
		size++;
	}

	@Override
	public E pop() {
		Node latest = top;
		top = top.previous;
		size--;
		return (E) latest.item;
	}

	private class Node {

		E item;
		Node previous;

	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private Node current = top;
			
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				E e =  current.item;
				current = current.previous;
				return e;
			}
			
		};
	}

}
