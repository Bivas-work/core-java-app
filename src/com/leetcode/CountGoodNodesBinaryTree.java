package com.leetcode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */

 
public class CountGoodNodesBinaryTree {

    int count = 0;
    public void dfs(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max){
            max = root.val;
            count++;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    public static void main(String[] args) {
        CountGoodNodesBinaryTree obj = new CountGoodNodesBinaryTree();
        System.out.println("The result is " + obj.goodNodes(null));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
