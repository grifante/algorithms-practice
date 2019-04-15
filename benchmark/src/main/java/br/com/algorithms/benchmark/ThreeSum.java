package br.com.algorithms.benchmark;

public class ThreeSum {

	public static int count(int[] a) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				for (int k = j; k < n; k++) {
					if (a[i] + a[j] + a[k] == 0)
						count++;
				}
			}
		}
		return count;
	}

}
