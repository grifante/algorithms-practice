package br.com.algorithms.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

public class StackTest {

	@Test
	public void testResizingArrayStack() {
		testIsEmpty(ResizingArrayStack::new);
		testSize(ResizingArrayStack::new);
		testIterator(ResizingArrayStack::new);
	}

	@Test
	public void testLinkedListStack() {
		testIsEmpty(LinkedListStack::new);
		testSize(LinkedListStack::new);
		testIterator(LinkedListStack::new);
	}

	private void testIsEmpty(Supplier<Stack<Integer>> supplier) {
		assertTrue(supplier.get().isEmpty());
	}

	private void testSize(Supplier<Stack<Integer>> supplier) {
		Stack<Integer> stack = supplier.get();
		assertEquals(0, stack.size());

		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.size());

		assertEquals(2, (int) stack.pop());
		assertEquals(1, stack.size());

		assertEquals(1, (int) stack.pop());
		assertTrue(stack.isEmpty());
	}

	private void testIterator(Supplier<Stack<Integer>> supplier) {
		Stack<Integer> stack = supplier.get();
		stack.push(1);
		stack.push(2);

		List<Integer> l = new ArrayList<>(2);
		for (Integer item : stack) {
			l.add(item);
		}

		assertEquals(2, (int) l.get(0));
		assertEquals(1, (int) l.get(1));
		assertEquals(2, stack.size());
	}

}
