package com.leetcode;

/**
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 */
public class LongestZigZagPath {
    int longestPath = Integer.MIN_VALUE;
    int tempPath = 0;
    public int longestZigZag(TreeNode root) {
        nodeTraverseStart(root);
        return longestPath;
    }

    private void nodeTraverseStart(TreeNode root) {
        if (root == null) return;
        tempPath = 0;
        moveLeft(root.left);
        longestPath =  Math.max(longestPath, tempPath);
        tempPath = 0;
        moveRight(root.right);
        longestPath =  Math.max(longestPath, tempPath);
        nodeTraverseStart(root.left);
        nodeTraverseStart(root.right);

    }

    // Take left step in zigzag path
    private void moveLeft(TreeNode root) {
        if (root == null) return;
        tempPath++;
        moveRight(root.right);

    }

    // Take Right step in zigzag path
    private void moveRight(TreeNode root) {
        if (root == null) return;
        tempPath++;
        moveLeft(root.left);
    }


    public static LongestZigZagPath.TreeNode insertLevelOrder(Integer[] values, int i) {
        LongestZigZagPath.TreeNode root = null;
        if (i < values.length) {
            if (values[i] != null) {
                root = new LongestZigZagPath.TreeNode(values[i]);
                root.left = insertLevelOrder(values, 2 * i + 1);
                root.right = insertLevelOrder(values, 2 * i + 2);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        LongestZigZagPath.TreeNode left;
        LongestZigZagPath.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, LongestZigZagPath.TreeNode left, LongestZigZagPath.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        LongestZigZagPath obj = new LongestZigZagPath();
        LongestZigZagPath.TreeNode node = new LongestZigZagPath.TreeNode(1);
        Integer[] values = {1,1,1,null,1,null,null,1,1,null,1};
        LongestZigZagPath.TreeNode root = insertLevelOrder(values, 0);
        System.out.println("The result : " +
                obj.longestZigZag(root));
    }


}
