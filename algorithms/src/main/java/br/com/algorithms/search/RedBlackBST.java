package br.com.algorithms.search;

import java.util.NoSuchElementException;

import br.com.algorithms.collection.LinkedListQueue;
import br.com.algorithms.collection.Queue;

public class RedBlackBST<E extends Comparable<E>, V> implements BinarySearchTree<E, V> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root;

	@Override
	public V get(E key) {
		return get(root, key);
	}

	private V get(Node x, E key) {
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

	@Override
	public void delete(E key) {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = delete(root, key);
		if (!isEmpty())
			root.color = BLACK;

	}

	private Node delete(Node x, E key) {
		if (key.compareTo(x.key) < 0) {
			if (!isRed(x.left) && !isRed(x.left.left))
				x = moveReadLeft(x);
			x.left = delete(x.left, key);
		} else {
			if (isRed(x.left))
				x = rotateRight(x);

			if (key.compareTo(x.key) == 0 && x.right == null)
				return null;

			if (!isRed(x.right) && !isRed(x.right.left))
				x = moveReadRight(x);

			if (key.compareTo(x.key) == 0) {
				Node h = min(x.right);
				x.key = h.key;
				x.val = h.val;
				x.right = deleteMin(x.right);
			} else {
				x.right = delete(x.right, key);
			}
		}
		return balance(x);
	}

	@Override
	public void deleteMin() {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMin(root);
		if (!isEmpty())
			root.color = BLACK;
	}

	@Override
	public void deleteMax() {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMax(root);
		if (!isEmpty())
			root.color = BLACK;
	}

	private Node deleteMax(Node x) {
		if (isRed(x.left))
			x = rotateRight(x);

		if (x.right == null)
			return null;

		if (!isRed(x.left) && !isRed(x.right))
			x = moveReadRight(x);

		x.right = deleteMax(x.right);
		return balance(x);
	}

	private Node moveReadRight(Node x) {
		flipColors(x);
		if (isRed(x.left.left)) {
			x = rotateRight(x);
			flipColors(x);
		}
		return x;
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return null;

		if (!isRed(x.left) && !isRed(x.left.left))
			x = moveReadLeft(x);
		x.left = deleteMin(x.left);
		return balance(x);
	}

	private Node moveReadLeft(Node x) {
		flipColors(x);
		if (isRed(x.right.left)) {
			x.right = rotateRight(x.right);
			x = rotateLeft(x);
			flipColors(x);
		}
		return x;
	}

	private Node balance(Node x) {
		if (isRed(x.right))
			x = rotateLeft(x);

		if (isRed(x.left) && isRed(x.left.left))
			x = rotateRight(x);

		if (isRed(x.left) && isRed(x.right))
			flipColors(x);

		x.n = size(x.left) + 1 + size(x.right);
		return x;
	}

	@Override
	public Iterable<E> keys() {
		return keys(min(), max());
	}

	@Override
	public Iterable<E> keys(E min, E max) {
		Queue<E> queue = new LinkedListQueue<>();
		keys(root, queue, min, max);
		return queue;
	}

	private void keys(Node x, Queue<E> queue, E min, E max) {
		if (x == null)
			return;

		int cmplo = min.compareTo(x.key);
		int cmphi = max.compareTo(x.key);

		if (cmplo < 0)
			keys(x.left, queue, min, max);

		if (cmplo <= 0 && cmphi >= 0)
			queue.enqueue(x.key);

		if (cmphi > 0)
			keys(x.right, queue, min, max);
	}

	@Override
	public E ceiling(E key) {
		Node x = ceiling(root, key);
		if (x == null)
			throw new NoSuchElementException();
		return x.key;
	}

	private Node ceiling(Node x, E key) {
		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);

		if (cmp == 0)
			return x;
		if (cmp > 0)
			return ceiling(x.right, key);

		Node t = ceiling(x.left, key);
		return t != null ? t : x;
	}

	@Override
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
		return t != null ? t : x;
	}

	@Override
	public int rank(E key) {
		return rank(root, key);
	}

	private int rank(Node x, E key) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(x.left, key);
		else if (cmp > 0)
			return size(x.left) + 1 + rank(x.right, key);
		else
			return size(x.left);
	}

	@Override
	public E select(int i) {
		if (i < 0 || i >= size())
			throw new IllegalArgumentException();
		Node x = select(root, i);
		return x.key;
	}

	private Node select(Node x, int i) {
		int t = size(x.left);

		if (i < t)
			return select(x.left, i);
		else if (i > t)
			return select(x.right, i - t - 1);
		else
			return x;
	}

	@Override
	public E min() {
		if (isEmpty())
			throw new NoSuchElementException();
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	@Override
	public E max() {
		if (isEmpty())
			throw new NoSuchElementException();
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null)
			return x;
		return max(x.right);
	}

	private boolean isEmpty() {
		return size() == 0;
	}

	private boolean isRed(Node node) {
		if (node == null)
			return false;
		return node.color;
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}

	private void flipColors(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		return node == null ? 0 : node.n;
	}

	@Override
	public void put(E key, V value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node h, E key, V val) {
		if (h == null) // Standard insert with red link to parent
			return new Node(key, val, 1, RED);

		int cmp = key.compareTo(h.key);

		if (cmp < 0)
			h.left = put(h.left, key, val);
		else if (cmp > 0)
			h.right = put(h.right, key, val);
		else
			h.val = val;

		// Tree balancing
		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);

		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);

		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		h.n = 1 + size(h.left) + size(h.right);
		return h;
	}

	private class Node {

		E key;
		V val;
		Node left, right;
		int n; // nodes in the subtree
		boolean color; // color of the link from parent to this node

		public Node(E key, V val, int n, boolean color) {
			this.key = key;
			this.val = val;
			this.n = n;
			this.color = color;
		}

	}

}
