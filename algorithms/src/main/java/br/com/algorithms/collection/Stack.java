package br.com.algorithms.collection;

public interface Stack<E> extends Collection<E> {

	void push(E item);

	E pop();

}