package br.com.algorithms.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.junit.BeforeClass;
import org.junit.Test;

public class SortTest {

	private static Integer[] randomData;
	private static Integer[] sortedData;

	@BeforeClass
	public static void initData() {
		randomData = new Random().ints(1000_000).boxed().toArray(Integer[]::new);
		sortedData = IntStream.rangeClosed(1, randomData.length).boxed().toArray(Integer[]::new);
	}

	@Test
	public void shellSortUnorderedDateTest() {
		test(ShellSort::new, randomData);
	}

	@Test
	public void shellSortSortedDataTest() {
		test(ShellSort::new, sortedData);
	}

	@Test
	public void selectionSortUnorderedDateTest() {
		test(SelectionSort::new, randomData);
	}

	@Test
	public void selectionSortSortedDataTest() {
		test(SelectionSort::new, sortedData);
	}

	@Test
	public void insertionSortUnorderedDataTest() {
		test(InsertionSort::new, randomData);
	}

	@Test
	public void insertionSortSortedDataTest() {
		test(InsertionSort::new, sortedData);
	}

	private void test(Supplier<Sort<Integer>> algorithm, Integer[] data) {
		Integer[] testData = Arrays.copyOf(data, data.length);
		algorithm.get().sort(testData);
		assertTrue(isSorted(testData));
	}

	private boolean isSorted(Integer[] data) {
		return IntStream.range(1, data.length).noneMatch(x -> data[x - 1].compareTo(data[x]) > 0);
	}

}
