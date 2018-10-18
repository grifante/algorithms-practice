package br.com.algorithms.collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.algorithms.util.ExpressionEvaluator;

public class ExpressionEvaluatorTest {

	@Test
	public void testEvaluate() {
		assertEquals(5.0, (double) ExpressionEvaluator.evaluate("(2+3)"), 0);
		assertEquals(2.3, (double) ExpressionEvaluator.evaluate("(2+(3 / (2*5)))"), 0);
	}

}
