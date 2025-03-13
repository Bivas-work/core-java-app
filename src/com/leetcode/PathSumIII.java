package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class PathSumIII {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        helperPathSum(root, targetSum, new ArrayList<>());
        return count;
    }

    private void helperPathSum(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        int sum = 0;

        // Check all subarrays ending at this node
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) count++;
        }

        helperPathSum(root.left, targetSum, path);
        helperPathSum(root.right, targetSum, path);

        // Backtrack
        path.remove(path.size() - 1);
    }

    public static TreeNode insertLevelOrder(Integer[] values, int i) {
        TreeNode root = null;
        if (i < values.length) {
            if (values[i] != null) {
                root = new TreeNode(values[i]);
                root.left = insertLevelOrder(values, 2 * i + 1);
                root.right = insertLevelOrder(values, 2 * i + 2);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        PathSumIII obj = new PathSumIII();
        PathSumIII.TreeNode node = new PathSumIII.TreeNode(1);
        Integer[] values = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
        TreeNode root = insertLevelOrder(values, 0);
        System.out.println("The result : " +
                obj.pathSum(root, 0));
    }



}
