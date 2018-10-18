package br.com.algorithms.collection;

public interface Stack<E> extends Iterable<E> {

	boolean isEmpty();

	int size();

	void push(E item);

	E pop();

}