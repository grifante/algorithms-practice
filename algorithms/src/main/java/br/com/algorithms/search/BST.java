package br.com.algorithms.search;

import java.util.NoSuchElementException;

import br.com.algorithms.collection.LinkedListQueue;
import br.com.algorithms.collection.Queue;

public class BST<E extends Comparable<E>, T> {

	private Node root;

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		return node == null ? 0 : node.n;
	}

	public Iterable<E> keys() {
		return keys(min(), max());
	}

	public Iterable<E> keys(E min, E max) {
		Queue<E> queue = new LinkedListQueue<>();
		keys(root, queue, min, max);
		return queue;
	}

	private void keys(Node x, Queue<E> queue, E lo, E hi) {
		if (x == null)
			return;

		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);

		if (cmplo < 0)
			keys(x.left, queue, lo, hi);

		if (cmplo <= 0 && cmphi >= 0)
			queue.enqueue(x.key);

		if (cmphi > 0)
			keys(x.right, queue, lo, hi);
	}

	public void delete(E key) {
		delete(root, key);
	}

	private Node delete(Node x, E k) {
		if (x == null)
			throw new NoSuchElementException();

		int cmp = k.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, k);
		else if (cmp > 0)
			x.right = delete(x.right, k);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;

			Node t = x;
			x = min(x.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}

		x.n = 1 + size(x.left) + size(x.right);
		return x;
	}

	public void deleteMin() {
		if (isEmpty())
			throw new NoSuchElementException();
		deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.n = 1 + size(x.left) + size(x.right);
		return x;
	}

	public void deleteMax() {
		if (isEmpty())
			throw new NoSuchElementException();
		deleteMax(root);
	}

	private Node deleteMax(Node n) {
		if (n.right == null)
			return n.left;
		n.right = deleteMax(n.right);
		n.n = 1 + size(n.left) + size(n.right);
		return n;

	}

	public int rank(E key) {
		return rank(root, key);
	}

	private int rank(Node x, E key) {
		if (x == null)
			throw new NoSuchElementException();
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(x.left, key);
		else if (cmp > 0)
			return 1 + size(x.left) + rank(x.right, key);
		else
			return size(x.left);
	}

	public E select(int i) {
		if (i < 0 || i >= size())
			throw new IllegalArgumentException();
		Node x = select(root, i);
		return x.key;
	}

	private Node select(Node x, int i) {
		int t = size(x.left);
		if (t > i)
			return select(x.left, i);
		else if (t < i)
			return select(x.right, i - t - 1);
		else
			return x;
	}

	public T get(E key) {
		return get(root, key);
	}

	private T get(Node x, E key) {
		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	public void put(E key, T value) {
		root = put(root, key, value);
	}

	private Node put(Node x, E key, T value) {
		if (x == null)
			return new Node(key, value, 1);

		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else
			x.val = value;

		x.n = 1 + size(x.left) + size(x.right);
		return x;

	}

	public E floor(E key) {
		Node x = floor(root, key);
		if (x == null)
			throw new NoSuchElementException();
		return x.key;
	}

	private Node floor(Node x, E key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0)
			return floor(x.left, key);

		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;

	}

	public E ceiling(E key) {
		Node x = ceiling(root, key);
		if (x == null)
			throw new NoSuchElementException();
		return x.key;
	}

	public Node ceiling(Node x, E key) {
		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;

		if (cmp > 0)
			return ceiling(x.right, key);

		Node t = ceiling(x.left, key);
		if (t != null)
			return t;
		else
			return x;
	}

	public E min() {
		if (isEmpty())
			throw new NoSuchElementException();
		Node minNode = min(root);
		return minNode.key;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	public E max() {
		if (isEmpty())
			throw new NoSuchElementException();
		Node maxNode = max(root);
		return maxNode.key;
	}

	private Node max(Node x) {
		if (x.right == null)
			return x;
		return max(x.right);
	}

	private boolean isEmpty() {
		return size() == 0;
	}

	private class Node {

		E key;
		T val;
		int n;
		Node left, right;

		public Node(E key, T val, int n) {
			this.key = key;
			this.val = val;
			this.n = n;
		}

	}

}
