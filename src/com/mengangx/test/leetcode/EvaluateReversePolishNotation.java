package com.mengangx.test.leetcode;
/**
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";
 
        Stack<String> stack = new Stack<String>();
 
        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t) {
                case "+":
                    stack.push(String.valueOf(a + b));
                    break;
                case "-":
                    stack.push(String.valueOf(b - a));
                    break;
                case "*":
                    stack.push(String.valueOf(a * b));
                    break;
                case "/":
                    stack.push(String.valueOf(b / a));
                    break;
                }
            }
        }
 
        returnValue = Integer.valueOf(stack.pop());
 
        return returnValue;
    }
}