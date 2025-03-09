package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSidView {

    List<Integer> result = new ArrayList<>();

    private void bfs(TreeNode root, List<Integer> result) {

    }
    public List<Integer> rightSideView(TreeNode root) {
     return null;
    }

    public static void main(String[] args) {
        BinaryTreeRightSidView obj = new BinaryTreeRightSidView();
        System.out.println("The result is " + obj.rightSideView(null));
    }

    public class TreeNode {
        int val;
        CountGoodNodesBinaryTree.TreeNode left;
        CountGoodNodesBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, CountGoodNodesBinaryTree.TreeNode left, CountGoodNodesBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
