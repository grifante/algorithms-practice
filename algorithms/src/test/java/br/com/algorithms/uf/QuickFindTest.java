package br.com.algorithms.uf;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuickFindTest extends UnionFindTest {

	@Test
	public void quickFindTest() {
		UnionFind unionFind = processDataset("tinyUF.txt", QuickFind::new);
		assertEquals(2, unionFind.count());
		assertArrayEquals(new int[] { 1, 1, 1, 8, 8, 1, 1, 1, 8, 8 }, unionFind.data());
	}

}
