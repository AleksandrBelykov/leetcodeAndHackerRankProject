package validateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode27 = new TreeNode(27);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode27);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11, treeNode9, treeNode20);

        System.out.println(isValidBST(treeNode11));
        System.out.println(inorderTraversal(treeNode11));
        System.out.println(isValidBSTiterative(treeNode11));
    }

    public static boolean isValidBST(TreeNode root) {
        return coreFunction(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean coreFunction(TreeNode node, long minVal, long maxVal){
        if (null == node){
            return true;
        }
        if (minVal >= node.val || maxVal <= node.val){
            return false;
        }
        return coreFunction(node.left, minVal, node.val) && coreFunction(node.right, node.val, maxVal);
    }

    //-------------------------------------------

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }


    public static boolean isValidBSTiterative(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
            System.out.println(pre.val + " " + root);

        }
        return true;
    }
}

