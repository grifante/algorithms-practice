package br.com.algorithms.benchmark;

import static org.openjdk.jmh.annotations.Mode.SingleShotTime;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.openjdk.jmh.runner.options.WarmupMode;

public class ThreeSumBenchmark {

	private static final int[] DATASET;

	static {
		try {
			DATASET = Files.lines(Paths.get(ClassLoader.getSystemResource("1Mints.txt").toURI()))
					.limit(1000)
					.map(String::trim)
					.mapToInt(Integer::parseInt)
					.toArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(ThreeSumBenchmark.class.getSimpleName())
				.warmupIterations(0)
				.mode(SingleShotTime)
				.forks(1)
				.build();
		new Runner(options).run();
	}

	@Benchmark
	public void threeSumFast() {
		ThreeSumFast.count(DATASET);
	}
	
	@Benchmark
	public void threeSumBruteForce() {
		ThreeSum.count(DATASET);
	}

}
