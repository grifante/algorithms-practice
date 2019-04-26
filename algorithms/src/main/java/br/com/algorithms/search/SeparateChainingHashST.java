package br.com.algorithms.search;

import br.com.algorithms.collection.LinkedListQueue;
import br.com.algorithms.collection.Queue;

public class SeparateChainingHashST<K, V> implements HashTable<K, V> {

	private int m;
	private int n;
	private SequencialSearchST<K, V>[] st;

	public SeparateChainingHashST() {
		this(997);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int m) {
		this.m = m;
		st = (SequencialSearchST<K, V>[]) new SequencialSearchST[m];
		for (int i = 0; i < m; i++)
			st[i] = new SequencialSearchST<>();
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public V get(K key) {
		return st[hash(key)].get(key);
	}

	@Override
	public void put(K key, V value) {
		st[hash(key)].put(key, value);
		n++;
	}

	@Override
	public void delete(K key) {
		st[hash(key)].delete(key);
		n--;
	}

	@Override
	public Iterable<K> keys() {
		Queue<K> queue = new LinkedListQueue<>();
		for (int i = 0; i < m; i++) {
			for (K key : st[i]) {
				queue.enqueue(key);
			}
		}
		return queue;
	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

}
