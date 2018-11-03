package br.com.algorithms.uf;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuickUnionTest extends UnionFindTest {

	@Test
	public void quickUnionTest() {
		UnionFind unionFind = processDataset("tinyUF.txt", QuickUnion::new);
		assertEquals(2, unionFind.count());
		assertArrayEquals(new int[] { 1, 1, 1, 8, 3, 0, 5, 1, 8, 8 }, unionFind.data());
	}

}
