package br.com.algorithms.uf;

public class WeightedQuickUnion extends QuickUnion {

	private int[] sizes;
	
	public WeightedQuickUnion(int n) {
		super(n);
		sizes = new int[n];
		for (int i = 0; i < n; i++) {
			sizes[i] = 1;
		}
	}


	@Override
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		
		if (pid == qid) return;
		
		if (sizes[pid] < sizes[qid]) {
			id[pid] = qid;
			sizes[qid] += sizes[pid]; 
		} else {
			id[qid] = pid;
			sizes[pid] += sizes[qid];
		}
		count--;
	}

}
