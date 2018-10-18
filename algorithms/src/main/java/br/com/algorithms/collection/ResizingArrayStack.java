package br.com.algorithms.collection;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ResizingArrayStack<E> implements Stack<E> {

	private Object[] stack = new Object[1];
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
		if (size == stack.length) {
			resize(stack.length * 2);
		}
		stack[size++] = item;
	}

	@Override
	public E pop() {
		Object item = stack[--size];
		stack[size] = null;
		if (size > 0 && size == stack.length / 4)
			resize(stack.length / 2);
		return (E) item;
	}

	private void resize(int capacity) {
		Object[] tempStack = new Object[capacity];
		for (int i = 0; i < size; i++) {
			tempStack[i] = stack[i];
		}
		stack = tempStack;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int index = size - 1;

			@Override
			public boolean hasNext() {
				return index >= 0;
			}

			@Override
			public E next() {
				return (E) stack[index--];
			}

		};
	}

}
