package br.com.algorithms.collection;

public interface Queue <E> extends Collection<E> {

	void enqueue(E item);
	
	E dequeue();
}
