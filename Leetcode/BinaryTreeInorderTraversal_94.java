package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public static void main(String[] args) {

        BinaryTreeInorderTraversal_94 obj = new BinaryTreeInorderTraversal_94();

        TreeNod root = new TreeNod(1);
        root.left = new TreeNod(2);

        root.left.left = new TreeNod(4);
        root.left.right = new TreeNod(5);

        root.right = new TreeNod(3);

        root.right.right = new TreeNod(8);
        root.right.right.left = new TreeNod(9);

        System.out.println(obj.inorderTraversal(root));

    }

    public List<Integer> inorderTraversal(TreeNod root) {

        List<Integer> results = new LinkedList<>();

         helpingMethod(results, root);
        return results;
    }


    public void helpingMethod(List<Integer> list , TreeNod root){
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
