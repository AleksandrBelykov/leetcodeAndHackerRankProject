package validateBinarySearchTree;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode27 = new TreeNode(27);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode27);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11, treeNode9, treeNode20);

        System.out.println(isValidBST(treeNode11));
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

}

