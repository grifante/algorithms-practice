package br.com.algorithms.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest  {

	@Test
	public void testIndexOf() {
		assertEquals(2, BinarySearch.indexOf(new int[] {1,1,3,4,5,6,7,8,9,10}, 3));
		assertEquals(4, BinarySearch.indexOf(new int[] {-1,1,3,4,5,6,7,8,9,10}, 5));
		assertEquals(-1, BinarySearch.indexOf(new int[] {1,1,3,4,5,6,7,8,9,10}, -3));
	}

}
