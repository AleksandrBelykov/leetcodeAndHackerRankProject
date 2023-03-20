package kthSmallestElementInABST;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode27 = new TreeNode(27);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode27);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11, treeNode9, treeNode20);

        System.out.println(kthSmallest(treeNode11, 4));
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }
}
