package com.mengangx.test.leetcode;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * */

import java.util.LinkedList;
import java.util.Queue;

import com.mengangx.test.leetcode.PostOrderTraversal.TreeNode;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> nodeq = new LinkedList<TreeNode>();
        Queue<Integer> depthq = new LinkedList<Integer>();
        
        nodeq.add(root);
        depthq.add(1);
        while (nodeq.peek() != null) {
            TreeNode cur = nodeq.poll();
            int count = depthq.poll();
            if(cur.left == null && cur.right == null) { //reach a leaf at this level
                return count;
            } else {
                if(cur.left != null) {
                    nodeq.add(cur.left);
                    depthq.add(count + 1);
                } 
                if (cur.right != null) {
                    nodeq.add(cur.right);
                    depthq.add(count + 1);
                }
            }
        }
        return -1;
    }    
}