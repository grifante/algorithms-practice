package br.com.algorithms.search;

public interface BinarySearchTree<E extends Comparable<E>, T> {

	int size();

	Iterable<E> keys();

	void delete(E key);

	void deleteMin();

	void deleteMax();

	int rank(E key);

	E select(int i);

	T get(E key);

	void put(E key, T value);

	E floor(E key);

	E ceiling(E key);

	E min();

	E max();

	Iterable<E> keys(E min, E max);

}