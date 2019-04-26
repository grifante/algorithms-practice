package br.com.algorithms.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LinearProbingHashSTTest {

	@Test
	public void crudTest() {
		HashTable<Integer, Integer> hash = new LinearProbingHashST<>(2);
		hash.put(1, 1);
		hash.put(2, 2);
		hash.put(3, 3);
		hash.put(4, 4);

		assertEquals(4, (int) hash.size());
		assertEquals(1, (int) hash.get(1));
		assertEquals(2, (int) hash.get(2));
		assertEquals(3, (int) hash.get(3));
		assertEquals(4, (int) hash.get(4));

		hash.delete(4);
		hash.delete(1);
		assertEquals(2, (int) hash.size());
		assertNull(hash.get(1));
		assertNull(hash.get(4));

		hash.delete(2);
		assertEquals(1, (int) hash.size());
	}
	
	@Test
	public void keysTest() {
		HashTable<Integer, Integer> hash = new LinearProbingHashST<>();
		hash.put(1, 1);
		hash.put(2, 2);
		hash.put(3, 3);
		hash.put(4, 4);

		List<Integer> temp = new ArrayList<>();
		for (Integer key : hash.keys()) {
			temp.add(key);
		}
		assertThat(temp).hasSize(4).contains(1, 2, 3, 4);
	}

}
