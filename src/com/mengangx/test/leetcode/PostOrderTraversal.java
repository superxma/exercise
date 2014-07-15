package com.mengangx.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public static class TreeNode {
              int val;
              TreeNode left;
              TreeNode right;
              TreeNode(int x) { val = x; }
    }
    
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (root == null) {
    		return result;
    	}
    	
    	List<Integer> left = postorderTraversal(root.left);
    	List<Integer> right = postorderTraversal(root.right);
    	result.addAll(left);
    	result.addAll(right);
    	result.add(root.val);
    	return result;
    }
    
    public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	node1.right = node2;
    	node2.left = node3;
    	
    	for(Integer i : postorderTraversal(node1)) {
    		System.out.println(i);
    	}
    }

}