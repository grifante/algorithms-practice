package br.com.algorithms.search;

import br.com.algorithms.collection.LinkedListQueue;
import br.com.algorithms.collection.Queue;

public class LinearProbingHashST<K, V> implements HashTable<K, V> {

	private int n;
	private int m;
	private K[] keys;
	private V[] values;

	public LinearProbingHashST() {
		this(16);
	}

	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int capacity) {
		m = capacity;
		keys = (K[]) new Object[m];
		values = (V[]) new Object[m];
	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		K[] k = keys;
		V[] v = values;
		keys = (K[]) new Object[capacity];
		values = (V[]) new Object[capacity];
		m = capacity;
		n = 0;
		for (int i = 0; i < k.length; i++)
			if (k[i] != null)
				put(k[i], v[i]);
	}

	@Override
	public void delete(K key) {
		int i = hash(key);
		while (!key.equals(keys[i])) {
			if (keys[i] == null)
				return;
			i = (i + 1) % m;
		}

		keys[i] = null;
		values[i] = null;

		i = (i + 1) % m;
		while (keys[i] != null) {
			K k = keys[i];
			V v = values[i];
			keys[i] = null;
			values[i] = null;
			n--;
			put(k, v);
			i = (i + 1) % m;
		}
		n--;

		if (n > 0 && n <= m % 8)
			resize(m / 2);
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public void put(K key, V value) {
		if (n > m / 2)
			resize(m * 2);

		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}

		keys[i] = key;
		values[i] = value;
		n++;
	}

	@Override
	public V get(K key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
			if (keys[i].equals(key))
				return values[i];
		}
		return null;
	}

	@Override
	public Iterable<K> keys() {
		Queue<K> queue = new LinkedListQueue<>();
		for (K k : keys)
			if (k != null)
			queue.enqueue(k);
		return queue;
	}

}
