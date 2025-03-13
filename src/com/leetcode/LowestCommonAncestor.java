package com.leetcode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 */
public class LowestCommonAncestor {
    boolean pFound  = false;
    boolean qFound = false;
    TreeNode parentRoot;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return parentRoot;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null) return;
        if(root.val == p.val) pFound = true;
        if(root.val == q.val) qFound = true;
        if(pFound && qFound)
            return;
        parentRoot = root;
        dfs(root.left, p, q);
        if(pFound || qFound)
            parentRoot = root;
        dfs(root.right, p, q);

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

        TreeNode(int val, LowestCommonAncestor.TreeNode left, LowestCommonAncestor.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor obj = new LowestCommonAncestor();
        LowestCommonAncestor.TreeNode node = new LowestCommonAncestor.TreeNode(1);
        Integer[] values = {1,1,1,null,1,null,null,1,1,null,1};
        LowestCommonAncestor.TreeNode root = insertLevelOrder(values, 0);
        System.out.println("The result : " +
                obj.lowestCommonAncestor(root, null, null));
    }

    public static LowestCommonAncestor.TreeNode insertLevelOrder(Integer[] values, int i) {
        LowestCommonAncestor.TreeNode root = null;
        if (i < values.length) {
            if (values[i] != null) {
                root = new LowestCommonAncestor.TreeNode(values[i]);
                root.left = insertLevelOrder(values, 2 * i + 1);
                root.right = insertLevelOrder(values, 2 * i + 2);
            }
        }
        return root;
    }

}
