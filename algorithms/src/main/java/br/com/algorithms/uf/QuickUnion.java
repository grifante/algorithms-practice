package br.com.algorithms.uf;

public class QuickUnion extends UnionFind {

	public QuickUnion(int n) {
		super(n);
	}

	@Override
	public int find(int x) {
		while (id[x] != x) x = id[x];
		return x;
	}

	@Override
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		
		if (pid == qid) return;
		
		id[pid] = qid;
		count--;
	}

}
