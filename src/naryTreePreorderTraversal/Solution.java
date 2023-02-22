package naryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Node root3 = new Node(3);
        Node root2 = new Node(2);
        Node root1 = new Node(1, List.of(root2, root3));

        System.out.println(preorder(root1));
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        preOrderTraversal(root, result);
        return result;
    }

    private static void preOrderTraversal(Node root, List<Integer> result){
        result.add(root.val);

        if (root.children != null) {
            for (Node child : root.children) {
                preOrderTraversal(child, result);
            }
        }
    }

}
