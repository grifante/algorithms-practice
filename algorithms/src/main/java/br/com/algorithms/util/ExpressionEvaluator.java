package br.com.algorithms.util;

import br.com.algorithms.collection.LinkedListStack;
import br.com.algorithms.collection.ResizingArrayStack;
import br.com.algorithms.collection.Stack;

/**
 * Based on Dijkstra's Two-Stack Algorithm
 */
public class ExpressionEvaluator {

	public static Double evaluate(String arithmeticExpression) {
		Stack<Character> ops = new ResizingArrayStack<>();
		Stack<Double> vals = new LinkedListStack<>();

		for (char c : arithmeticExpression.toCharArray()) {
			switch (c) {
				case ' ':
				case '(':
					continue;
				case '+':
				case '-':
				case '*':
				case '/':
					ops.push(c);
					break;
				case ')':
					switch (ops.pop()) {
						case '+':
							vals.push(vals.pop() + vals.pop());
							break;
						case '-':
							vals.push(vals.pop() - vals.pop());
							break;
						case '*':
							vals.push(vals.pop() * vals.pop());
							break;
						case '/':
							Double denominator = vals.pop();
							Double numerator = vals.pop();
							vals.push(numerator / denominator);
							break;
					}
					break;
				default:
					vals.push((double) Character.getNumericValue(c));
			}
		}
		return vals.pop();
	}

}
