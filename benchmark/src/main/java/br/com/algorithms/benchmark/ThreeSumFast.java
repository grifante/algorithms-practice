package br.com.algorithms.benchmark;

import java.util.Arrays;

import br.com.algorithms.search.BinarySearch;

public class ThreeSumFast {

	public static int count(int[] a) {
		Arrays.sort(a);
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
					count++;
				}
			}
		}
		return count;
	}

}
