package br.com.algorithms.search;

import java.util.Iterator;

class SequencialSearchST<K, V> implements Iterable<K> {

	private Node first;

	public V get(K key) {
		for (Node x = first; x != null; x = x.next) {
			if (x.key.equals(key))
				return x.val;
		}
		return null;
	}

	public void put(K key, V value) {
		for (Node x = first; x != null; x = x.next) {
			if (x.key.equals(key)) {
				x.val = value;
				return;
			}
		}
		first = new Node(key, value, first);
	}

	public void delete(K key) {
		Node p = null;
		for (Node n = first; n != null; n = n.next) {
			if (!key.equals(n.key)) {
				p = n;
				continue;
			}

			if (n == first)
				first = first.next;
			else
				p.next = n.next;

			return;
		}

	}

	private class Node {

		final K key;
		V val;
		Node next;

		public Node(K key, V val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}

	}

	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>() {

			private Node n = first;

			@Override
			public boolean hasNext() {
				return n != null;
			}

			@Override
			public K next() {
				Node x = n;
				n = x.next;
				return x.key;
			}
		};
	}
}
