package com.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaximumLevelSumBinaryTree {
    int maxSum = 0;
    int selectedLevel = 0;
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levelSum = new HashMap<>();
        maxSum(root, 1, levelSum);
        return Collections.max(levelSum.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public void maxSum(TreeNode root, int level, Map levelSum) {
        if(root == null) return;
        levelSum.put(level, (int) levelSum.getOrDefault(level, 0) + root.val);
        maxSum(root.left, level+1, levelSum);
        maxSum(root.right, level+1, levelSum);
    }

    public static class TreeNode {
        int val;
        MaximumLevelSumBinaryTree.TreeNode left;
        MaximumLevelSumBinaryTree.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, MaximumLevelSumBinaryTree.TreeNode left, MaximumLevelSumBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        MaximumLevelSumBinaryTree obj = new MaximumLevelSumBinaryTree();
        MaximumLevelSumBinaryTree.TreeNode node = new MaximumLevelSumBinaryTree.TreeNode(1);
        Integer[] values = {1,7,0,7,-8,null,null};
        MaximumLevelSumBinaryTree.TreeNode root = insertLevelOrder(values, 0);
        System.out.println("The result : " +
                obj.maxLevelSum(root));
    }

    public static MaximumLevelSumBinaryTree.TreeNode insertLevelOrder(Integer[] values, int i) {
        MaximumLevelSumBinaryTree.TreeNode root = null;
        if (i < values.length) {
            if (values[i] != null) {
                root = new MaximumLevelSumBinaryTree.TreeNode(values[i]);
                root.left = insertLevelOrder(values, 2 * i + 1);
                root.right = insertLevelOrder(values, 2 * i + 2);
            }
        }
        return root;
    }
}
