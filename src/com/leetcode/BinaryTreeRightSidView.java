package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSidView {

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    public static void main(String[] args) {
        BinaryTreeRightSidView obj = new BinaryTreeRightSidView();
        System.out.println("The result is " + obj.rightSideView(null));
    }

    public class TreeNode {
        int val;
        BinaryTreeRightSidView.TreeNode left;
        BinaryTreeRightSidView.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BinaryTreeRightSidView.TreeNode left, BinaryTreeRightSidView.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
