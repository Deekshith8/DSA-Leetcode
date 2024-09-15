package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public static void main(String[] args) {

        BinaryTreeInorderTraversal_94 obj = new BinaryTreeInorderTraversal_94();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        System.out.println(obj.inorderTraversal(root));

    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results = new LinkedList<>();

         helpingMethod(results, root);
        return results;
    }


    public void helpingMethod(List<Integer> list , TreeNode root){
        if(root == null){
            return;
        }

        // traverse left
        helpingMethod(list , root.left);

        list.add(root.val);

        // traverse right

        helpingMethod(list, root.right);


    }

}
