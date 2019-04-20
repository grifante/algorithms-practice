package br.com.algorithms.search;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class RedBlackBSTTest {

	private BinarySearchTree<Integer, Integer> bst;

	@Before
	public void init() {
		bst = new RedBlackBST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);
	}

	@Test
	public void deleteTest() {
		assertEquals(5, (int) bst.floor(5));

		bst.delete(5);
		assertEquals(3, (int) bst.floor(5));
		
		bst.delete(3);
		assertEquals(2, (int) bst.floor(3));

		assertEquals(2, (int) bst.size());
	}

	@Test
	public void deleteMaxTest() {
		assertEquals(5, (int) bst.max());

		bst.deleteMax();
		assertEquals(3, (int) bst.max());

		bst.deleteMax();
		assertEquals(2, (int) bst.max());

		assertEquals(2, (int) bst.size());
	}

	@Test
	public void deleteMinTest() {
		assertEquals(1, (int) bst.min());

		bst.deleteMin();
		assertEquals(2, (int) bst.min());

		bst.deleteMin();
		assertEquals(3, (int) bst.min());

		assertEquals(2, (int) bst.size());
	}

	@Test
	public void keysTest() {
		assertArrayEquals(new Integer[] { 1, 2, 3, 5 }, toArray(bst.keys()));
	}

	@Test
	public void keysMinMaxTest() {
		assertArrayEquals(new Integer[] { 1, 2, 3 }, toArray(bst.keys(1, 3)));
	}

	private Integer[] toArray(Iterable<Integer> iterable) {
		List<Integer> l = new LinkedList<>();
		for (Integer k : iterable) {
			l.add(k);
		}
		return l.toArray(new Integer[l.size()]);
	}

	@Test
	public void selectTest() {
		assertEquals(1, (int) bst.select(0));
		assertEquals(2, (int) bst.select(1));
		assertEquals(3, (int) bst.select(2));
		assertEquals(5, (int) bst.select(3));
	}

	@Test(expected = NoSuchElementException.class)
	public void ceilingNSEETest() {
		bst.ceiling(6);
	}

	@Test
	public void ceilingTest() {
		assertEquals(1, (int) bst.ceiling(0));
		assertEquals(1, (int) bst.ceiling(1));
		assertEquals(2, (int) bst.ceiling(2));
		assertEquals(3, (int) bst.ceiling(3));
		assertEquals(5, (int) bst.ceiling(4));
		assertEquals(5, (int) bst.ceiling(5));
	}

	@Test(expected = NoSuchElementException.class)
	public void floorNSEETest() {
		bst.floor(0);
	}

	@Test
	public void floorTest() {
		assertEquals(2, (int) bst.floor(2));
		assertEquals(3, (int) bst.floor(3));
		assertEquals(3, (int) bst.floor(4));
		assertEquals(5, (int) bst.floor(5));
		assertEquals(5, (int) bst.floor(6));
	}

	@Test
	public void rankTest() {
		assertEquals(0, bst.rank(1));
		assertEquals(1, bst.rank(2));
		assertEquals(2, bst.rank(3));
		assertEquals(3, bst.rank(5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void selectNSEETest() {
		bst.select(4);
	}

	@Test
	public void minTest() {
		assertEquals(1, (int) bst.min());
	}

	@Test
	public void maxTest() {
		assertEquals(5, (int) bst.max());
	}

	@Test
	public void sizeTest() {
		assertEquals(4, bst.size());
	}
}
