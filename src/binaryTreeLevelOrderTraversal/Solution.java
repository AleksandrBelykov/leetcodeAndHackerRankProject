package binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);

        System.out.println(levelOrder(treeNode3));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()){
            int elementsOnLevel = queue.size();
            List<Integer> levelValsSublist = new ArrayList<>();

            for (int i=0; i<elementsOnLevel; i++){
                TreeNode element = queue.poll();
                levelValsSublist.add(element.val);
                if (null != element.left){
                    queue.add(element.left);
                }
                if (null != element.right){
                    queue.add(element.right);
                }
            }

            result.add(levelValsSublist);
        }

        return result;
    }

}
