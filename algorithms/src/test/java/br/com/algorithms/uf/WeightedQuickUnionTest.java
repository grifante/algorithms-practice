package br.com.algorithms.uf;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WeightedQuickUnionTest extends UnionFindTest {

	@Test
	public void weightedQuickUnionTest() {
		UnionFind unionFind = processDataset("tinyUF.txt", WeightedQuickUnion::new);
		assertEquals(2, unionFind.count());
		assertArrayEquals(new int[] { 6, 2, 6, 4, 4, 6, 6, 2, 4, 4 }, unionFind.data());
	}
	
}
