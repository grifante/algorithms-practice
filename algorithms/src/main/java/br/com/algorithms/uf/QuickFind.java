package br.com.algorithms.uf;

public class QuickFind extends UnionFind {

	public QuickFind(int n) {
		super(n);
	}

	@Override
	public int find(int x) {
		return id[x];
	}

	@Override
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);

		if (qid == pid) return;
		
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) id[i] = qid;
		}
		count--;
	}

}
