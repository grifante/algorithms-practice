package br.com.algorithms.search;

public interface HashTable<K, V> {

	void delete(K key);

	int size();

	void put(K key, V value);

	V get(K key);

	Iterable<K> keys();

}