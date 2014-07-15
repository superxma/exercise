package com.mengangx.test.problems;

import java.util.Iterator;
import java.util.Stack;
import com.mengangx.test.problems.InOrderIterator.TreeNode;

public class InOrderIterator implements Iterator<TreeNode> {
	public static class TreeNode {
		public String val;
		public TreeNode left;
		public TreeNode right;
		TreeNode(String str) {
			val = str;
			left = null;
			right = null;
		}
	}
	
	InOrderIterator(TreeNode root) {
		p = root;
		stack = new Stack<TreeNode>();
	}
	
	public boolean hasNext() {
		return !stack.isEmpty() || p != null;
	}
	
	public TreeNode next() {
        while (!stack.isEmpty() || p != null) {
        	if (p != null) {
        		stack.push(p);
        		p = p.left;
        	} else {
        		TreeNode t = stack.pop();
        		p = t.right;
        		return t;
        	}
        }
        return null;
	}
	
	public void remove() {
		throw new UnsupportedOperationException("remove is not supported");
	}
	
	private TreeNode p;
	private Stack<TreeNode> stack;
	
	
	public static void main(String[] args) {
		TreeNode b = new TreeNode("2");
		TreeNode a = new TreeNode("1");
		TreeNode c = new TreeNode("3");
		TreeNode d = new TreeNode("4");
		a.right = d;
		d.left = b;
		b.right = c;
		
		InOrderIterator it = new InOrderIterator(a);
		while(it.hasNext()) {
			System.out.println(it.next().val);
		}
		
	}
}