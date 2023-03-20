package lowestCommonAncestorOfaBinarySearchTree;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode27 = new TreeNode(27);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode27);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11, treeNode9, treeNode20);

        System.out.println(lowestCommonAncestor(treeNode11, treeNode15, treeNode27));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int smallest = Math.min(p.val,q.val);
        int biggest = Math.max(p.val, q.val);

        while(root != null){
            if(root.val < smallest){
                root = root.right;
            } else if(root.val > biggest){
                root = root.left;
            } else { //smallest<=root.val<=biggest
                return root;
            }
        }

        return null;
    }
}
