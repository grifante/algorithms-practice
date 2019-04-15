package br.com.algorithms.uf;

public abstract class UnionFind {
	
	protected int[] id;
	protected int count;
	
	UnionFind(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	public int[] data() {
		return id;
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public abstract int find(int x);
	
	// Connects site p to q
	public abstract void union(int p, int q);
	
}
