package br.com.algorithms.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SeparateChainingHashSTTest {

	@Test
	public void crudTest() {
		HashTable<Integer, Integer> hash = new SeparateChainingHashST<>();
		hash.put(1, 1);
		hash.put(1, 2);
		hash.put(2, 3);

		assertEquals(3, (int) hash.size());
		assertEquals(2, (int) hash.get(1));
		assertEquals(3, (int) hash.get(2));

		hash.delete(1);
		hash.delete(2);

		assertEquals(1, (int) hash.size());
		assertNull(hash.get(1));
		assertNull(hash.get(2));

	}

	@Test
	public void keysTest() {
		HashTable<Integer, Integer> hash = new SeparateChainingHashST<>();
		hash.put(1, 1);
		hash.put(2, 2);
		hash.put(3, 3);
		hash.put(-4, -4);
		hash.put(-5, -5);

		List<Integer> temp = new ArrayList<>();
		for (Integer key : hash.keys()) {
			temp.add(key);
		}
		assertThat(temp).hasSize(5).contains(1, 2, 3, -4, -5);
	}

}
