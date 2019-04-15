package br.com.algorithms.search;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class BSTTest {

	@Test
	public void keysTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);

		assertArrayEquals(new Integer[] { 1, 2, 3, 5 }, toArray(bst.keys()));
		assertArrayEquals(new Integer[] { 2, 3, 5 }, toArray(bst.keys(2, 5)));
	}

	private Integer[] toArray(Iterable<Integer> iterable) {
		List<Integer> l = new LinkedList<>();
		for (Integer k : iterable) {
			l.add(k);
		}
		return l.toArray(new Integer[l.size()]);
	}
	
	@Test
	public void deleteTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);
		assertEquals(3, (int) bst.select(2));
		bst.delete(3);
		assertEquals(5, (int) bst.select(2));

		assertEquals(1, (int) bst.select(0));
		bst.delete(1);
		assertEquals(2, (int) bst.select(0));
	}

	@Test
	public void deleteMaxTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);
		assertEquals(5, (int) bst.max());
		bst.deleteMax();
		assertEquals(3, (int) bst.max());
	}

	@Test
	public void deleteMinTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);
		assertEquals(1, (int) bst.select(0));
		bst.deleteMin();
		assertEquals(2, (int) bst.select(0));
		assertEquals(3, (int) bst.size());
	}

	@Test
	public void rankTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);
		assertEquals(0, (int) bst.rank(1));
		assertEquals(1, (int) bst.rank(2));
		assertEquals(2, (int) bst.rank(3));
		assertEquals(3, (int) bst.rank(5));
	}

	@Test(expected = NoSuchElementException.class)
	public void rankNSEETest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		assertEquals(0, (int) bst.rank(6));
	}

	@Test
	public void selectTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);
		assertEquals(1, (int) bst.select(0));
		assertEquals(2, (int) bst.select(1));
		assertEquals(5, (int) bst.select(3));
	}

	@Test
	public void ceilingTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);
		assertEquals(1, (int) bst.ceiling(1));
		assertEquals(5, (int) bst.ceiling(4));
	}

	@Test(expected = NoSuchElementException.class)
	public void ceilingNSEETest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.ceiling(4);
	}

	@Test
	public void floorTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.put(3, 3);
		bst.put(5, 5);
		assertEquals(1, (int) bst.floor(1));
		assertEquals(5, (int) bst.floor(6));
	}

	@Test(expected = NoSuchElementException.class)
	public void floorNSEETest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, -3);
		bst.floor(0);
	}

	@Test
	public void getTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(1, 1);
		bst.put(2, 2);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(3, -3);
		assertEquals(1, (int) bst.get(1));
		assertEquals(5, (int) bst.get(5));
		assertEquals(-3, (int) bst.get(3));
	}

	@Test
	public void sizeTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(1, 1);
		bst.put(2, 2);
		bst.put(3, 3);
		assertEquals(3, (int) bst.size());

		bst.put(3, -3);
		assertEquals(3, (int) bst.size());
	}

	@Test
	public void minTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(-1, 1);
		bst.put(2, 2);
		bst.put(-3, 3);
		assertEquals(-3, (int) bst.min());
	}

	@Test
	public void maxTest() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(-1, 1);
		bst.put(2, 2);
		bst.put(-3, 3);
		assertEquals(2, (int) bst.max());
	}

}
