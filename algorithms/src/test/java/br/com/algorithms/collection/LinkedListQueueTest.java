package br.com.algorithms.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LinkedListQueueTest {

	@Test
	public void testQueue() {
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		assertTrue(queue.isEmpty());

		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(2, queue.size());
		assertFalse(queue.isEmpty());

		assertEquals(1, (int) queue.dequeue());
		assertEquals(2, (int) queue.dequeue());

		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
	}

	@Test
	public void testIterator() {
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);

		List<Integer> resultList = new ArrayList<>();
		for (Integer i : queue) {
			resultList.add(i);
		}

		assertEquals(1, (int) resultList.get(0));
		assertEquals(2, (int) resultList.get(1));
	}

}
