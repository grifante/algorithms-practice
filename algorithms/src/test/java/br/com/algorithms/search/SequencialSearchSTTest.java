package br.com.algorithms.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SequencialSearchSTTest {

	private SequencialSearchST<Integer, Integer> ssST;

	@Before
	public void init() {
		ssST = new SequencialSearchST<>();
		ssST.put(1, 1);
		ssST.put(2, 2);
		ssST.put(3, 3);
		ssST.put(4, 4);
	}

	@Test
	public void crudTest() {
		assertEquals(1, (int) ssST.get(1));
		assertEquals(2, (int) ssST.get(2));
		assertEquals(3, (int) ssST.get(3));
		assertEquals(4, (int) ssST.get(4));

		ssST.delete(1);
		ssST.delete(2);
		ssST.delete(3);
		ssST.delete(4);

		assertNull(ssST.get(1));
		assertNull(ssST.get(2));
		assertNull(ssST.get(3));
		assertNull(ssST.get(4));
	}

	@Test
	public void iteratorTest() {
		List<Integer> temp = new ArrayList<>();
		for (Integer key : ssST) {
			temp.add(key);
		}
		assertThat(temp).hasSize(4).contains(1, 2, 3, 4);
	}

}
