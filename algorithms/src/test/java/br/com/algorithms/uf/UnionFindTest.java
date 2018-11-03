package br.com.algorithms.uf;

import static java.util.stream.Collectors.toList;

import java.util.Iterator;
import java.util.List;
import java.util.function.IntFunction;

import br.com.algorithms.util.Utils;

abstract class UnionFindTest {

	UnionFind processDataset(String dataset, IntFunction<UnionFind> funcBuilder) {
		List<String> data = Utils.lines(dataset).collect(toList());

		Iterator<String> iterator = data.iterator();

		UnionFind unionFind = funcBuilder.apply(Integer.parseInt(iterator.next()));

		while (iterator.hasNext()) {
			String[] points = iterator.next().split(" ");
			int p = Integer.parseInt(points[0]);
			int q = Integer.parseInt(points[1]);

			if (unionFind.connected(p, q))
				continue;

			unionFind.union(p, q);
		}

		return unionFind;
	}

}
