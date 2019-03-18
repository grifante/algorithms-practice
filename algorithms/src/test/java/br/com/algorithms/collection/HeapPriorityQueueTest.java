package br.com.algorithms.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HeapPriorityQueueTest {

	@Test
	public void testIsEmpty() {
		Queue<Integer> pq = new HeapPriorityQueue<>(10);
		assertTrue(pq.isEmpty());

		pq.enqueue(5);
		assertFalse(pq.isEmpty());

		pq.dequeue();
		assertTrue(pq.isEmpty());

	}

	@Test
	public void testSize() {
		Queue<Integer> pq = new HeapPriorityQueue<>(10);
		pq.enqueue(5);
		pq.enqueue(3);
		pq.enqueue(4);
		assertEquals(3, pq.size());

		pq.enqueue(4);
		assertEquals(4, pq.size());

		pq.dequeue();
		assertEquals(3, pq.size());
	}

	@Test
	public void testEnqueueDequeue() {
		Queue<Integer> pq = new HeapPriorityQueue<>(10);
		pq.enqueue(5);
		pq.enqueue(3);
		pq.enqueue(4);
		pq.enqueue(1);
		pq.enqueue(2);
		assertEquals(5, (int) pq.dequeue());
		assertEquals(4, (int) pq.dequeue());
		assertEquals(3, (int) pq.dequeue());
		assertEquals(2, (int) pq.dequeue());
		assertEquals(1, (int) pq.dequeue());
	}

}
